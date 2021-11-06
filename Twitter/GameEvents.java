// https://leetcode.com/discuss/interview-question/375258/Twitter-or-OA-2019-or-Game-Events
// SKIPPED!

import java.util.*;

class GameEvents {

    Map<Character, Integer> map = new HashMap<>();

    class Event {
        int actualTime;
        String timeString;
        String teamName;
        String playerName;
        String substituteName;
        char eventType;
        boolean isFirstHalf;

        public Event(String str, String team) {

            String[] words = str.split(" ");
            int time = getTimeIndex(words);
            char event = words[time + 1].charAt(0);
            String player = "";
            for (int i = 0; i < time; i++) {
                player = player + " " + words[i];
            }
            player = player.trim();
            String sub = "";
            if (event == 'S') {
                for (int i = time + 2; i < words.length; i++) {
                    sub += words[i] + " ";
                }
                sub = sub.trim();
            }
            actualTime = 0;
            this.isFirstHalf = false;
            if (words[time].contains("+")) {
                String timeSplit[] = words[time].split("\\+");
                actualTime += Integer.parseInt(timeSplit[0]);
                if (actualTime <= 45) {
                    this.isFirstHalf = true;
                }
                actualTime += Integer.parseInt(timeSplit[1]);
            } else {
                actualTime += Integer.parseInt(words[time]);
                if (actualTime <= 45) {
                    this.isFirstHalf = true;
                }
            }

            this.timeString = words[time];
            this.teamName = team;
            this.playerName = player;
            this.substituteName = sub;
            this.eventType = event;
        }

        public String toString() {
            return actualTime + " " + timeString + "  " + teamName + "  " + playerName + " " + substituteName + " "
                    + eventType + " " + isFirstHalf;
        }

        public String getOutputString() {
            return this.teamName + " " + this.playerName + " " + this.timeString + " " + this.eventType + " "
                    + this.substituteName;
        }
    }

    public List<String> getEventsOrder(String team1, String team2, List<String> events1, List<String> events2) {
        map.put('G', 1);
        map.put('Y', 2);
        map.put('R', 3);
        map.put('S', 4);
        List<Event> Events = new ArrayList<>();
        for (String e1 : events1) {
            Event Event = new Event(e1, team1);
            Events.add(Event);
            System.out.println(Event);
        }
        for (String e2 : events2) {
            Event Event = new Event(e2, team2);
            Events.add(Event);
            System.out.println(Event);
        }
        Collections.sort(Events, new Comparator<Event>() {
            public int compare(Event s1, Event s2) {
                if (s1.isFirstHalf == true && s2.isFirstHalf == false) {
                    return -1;
                }
                if (s1.isFirstHalf == false && s2.isFirstHalf == true) {
                    return 1;
                }
                if (s1.actualTime != s2.actualTime)
                    return s1.actualTime - s2.actualTime;
                if (map.get(s1.eventType) != map.get(s2.eventType)) {
                    return map.get(s1.eventType) - map.get(s2.eventType);
                }
                if (!s1.teamName.equals(s2.teamName))
                    return s1.teamName.compareTo(s2.teamName);
                return s1.playerName.compareTo(s2.playerName);
            }
        });
        List<String> answer = new ArrayList<>();
        for (Event Event : Events) {
            answer.add(Event.getOutputString().trim());
        }
        return answer;

    }

    private int getTimeIndex(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].charAt(0) >= '0' && words[i].charAt(0) <= '9') {
                return i;
            }
        }
        return -1;
    }

}