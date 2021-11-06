// Skipped
// https://leetcode.com/discuss/interview-question/378237/Twitter-or-OA-2019-or-Authentication-Tokens
import java.util.HashMap;
import java.util.List;

class AuthentificationTokens {
    public static int numberOfTokens(int expiryLimit, List<List<Integer>> commands) {
        if(commands == null || commands.isEmpty()) {
            //invalid input
            return 0;
        }
        //maintain tokenid with expiry in a map
        HashMap<Integer, Integer> tokenIdToTokenExpiry = new HashMap<>();

        for (List<Integer> token : commands) {
            if(token.size() != 3){
                //invalid input
                return 0;
            }
            //tokenCommand can be either 0 (get) or 1 (reset)
            Integer tokenCommand = token.get(0);
            Integer tokenId = token.get(1);
            Integer tokenTime = token.get(2);
            
            if(tokenCommand == 0){
                // Get command
                tokenIdToTokenExpiry.put(tokenId, tokenTime + expiryLimit);
            } else {
                //Reset command
                if(tokenIdToTokenExpiry.containsKey(tokenId)){
                    if(tokenTime <= tokenIdToTokenExpiry.get(tokenId)){
                        //If not expired, update token time with new value
                        tokenIdToTokenExpiry.put(tokenId, tokenTime + expiryLimit);
                    } else {
                        //if expired, remove token from map
                        tokenIdToTokenExpiry.remove(tokenId);
                    }
                }
            }
        }
        
        //find the last inputed tokentime and filter data based on expiry
        Integer lastTime = commands.get(commands.size() - 1).get(2);        
        return (int) tokenIdToTokenExpiry.values().stream().filter(tokenTime ->  tokenTime >= lastTime).count();
    }
}
