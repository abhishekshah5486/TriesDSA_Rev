import java.util.*;

class TrieNode{
    private Map<Character, TrieNode> map;
    private boolean isEnd;

    public TrieNode(){
        this.map = new HashMap<>();
        this.isEnd = false;
    }
    // Getters and Setters
    public Map<Character, TrieNode> getMap() {
        return map;
    }
    public void setMap(Map<Character, TrieNode> map) {
        this.map = map;
    }
    public boolean isEnd() {
        return isEnd;
    }
    public void setEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }
}
public class CompleteString_II {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        TrieNode curr = new TrieNode();
        String[] words = {"a", "ap", "app", "appl", "apple"};
        List<String> replWords = new ArrayList<>();
        // Sorting the string array lexicographically using Collections.sort
        for (int j=0; j<words.length; j++){
            replWords.add(words[j]);
        }
        Collections.sort(replWords);
        String finalAns = solveCompleteStringII(replWords, curr);
        System.out.println(finalAns);
        scn.close();
    }
    public static String solveCompleteStringII(List<String> replWords, TrieNode curr){
        int ansIdx = -1;
        int maxCompleteStr = Integer.MIN_VALUE;

        for (int j=0; j<replWords.size(); j++){
            String str = replWords.get(j);
            TrieNode replCurr = curr;
            boolean flag = true;

            for (int k=0; k<str.length(); k++){
                char ch = str.charAt(k);
                if (!replCurr.getMap().containsKey(ch)){
                    replCurr.getMap().put(ch, new TrieNode());
                }
                replCurr = replCurr.getMap().get(ch);
                if (!replCurr.isEnd() && k < (str.length() - 1)){
                    flag = !flag;
                    break;
                }
            }
            replCurr.setEnd(true);
            if (flag && str.length() > maxCompleteStr){
                ansIdx = j;
                maxCompleteStr = str.length();
            }
        }
        if (ansIdx == -1) return "None";
        else return replWords.get(ansIdx);
    }
}
