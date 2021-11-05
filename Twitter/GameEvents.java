package Twitter;
// https://leetcode.com/discuss/interview-question/375258/Twitter-or-OA-2019-or-Game-Events
// SKIPPED!

import java.util.*;

class GameEvents {
    static class Score {
        int actualTime;
        String timeString;
        String teamName;
        String playerName;
        String substituteName;
        char eventType;
        boolean isFirstHalf;

        public Score(int actualTime, String timeString, String teamName, String playerName, String substituteName,
                char eventType, boolean isFirstHalf) {
            this.actualTime = actualTime;
            this.timeString = timeString;
            this.teamName = teamName;
            this.playerName = playerName;
            this.substituteName = substituteName;
            this.eventType = eventType;
            this.isFirstHalf = isFirstHalf;
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

    static Map<Character, Integer> map = new HashMap<>();

    public static List<String> getEventsOrder(String team1, String team2, List<String> events1, List<String> events2) {
        map.put('G', 1);
        map.put('Y', 2);
        map.put('R', 3);
        map.put('S', 4);
        List<Score> scores = new ArrayList<>();
        for (String e1 : events1) {
            Score score = parseString(e1, team1);
            scores.add(score);
            System.out.println(score);
        }
        for (String e2 : events2) {
            Score score = parseString(e2, team2);
            scores.add(score);
            System.out.println(score);
        }
        Collections.sort(scores, new Comparator<Score>() {
            public int compare(Score s1, Score s2) {
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
        for (Score score : scores) {
            answer.add(score.getOutputString().trim());
        }
        return answer;

    }

    public static Score parseString(String str, String team) {
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
        int actualTime = 0;
        boolean isFirstHalf = false;
        if (words[time].contains("+")) {
            String timeSplit[] = words[time].split("\\+");
            actualTime += Integer.parseInt(timeSplit[0]);
            if (actualTime <= 45) {
                isFirstHalf = true;
            }
            actualTime += Integer.parseInt(timeSplit[1]);
        } else {
            actualTime += Integer.parseInt(words[time]);
            if (actualTime <= 45) {
                isFirstHalf = true;
            }
        }
        Score score = new Score(actualTime, words[time], team, player, sub, event, isFirstHalf);
        return score;
    }

    public static int getTimeIndex(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].charAt(0) >= '0' && words[i].charAt(0) <= '9') {
                return i;
            }
        }
        return -1;
    }

}