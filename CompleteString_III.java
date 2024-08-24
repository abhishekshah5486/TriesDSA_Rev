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
public class CompleteString_III {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        TrieNode curr = new TrieNode();
        String[] words = {"a", "ap", "app", "appl", "apple"};
        List<String> replWords = new ArrayList<>();
        for (int j=0; j<words.length; j++){
            replWords.add(words[j]);
            insertWordIntoTrie(words[j], curr);
        }
        String finalAns = solveCompleteString(replWords, curr);
        System.out.println(finalAns);
        scn.close();
    }
    public static String solveCompleteString(List<String> replWords, TrieNode curr){
        String ans = "";
        int maxCompleteStr = Integer.MIN_VALUE;

        for (int j=0; j<replWords.size(); j++){
            String str = replWords.get(j);
            TrieNode replCurr = curr;
            boolean flag = true;
            for (int k=0; k<str.length(); k++){
                char ch = str.charAt(k);
                replCurr = replCurr.getMap().get(ch);
                if (!replCurr.isEnd()){
                    flag = !flag;
                    break;
                }
            }
            if (flag){
                if (str.length() > maxCompleteStr){
                    ans = str;
                    maxCompleteStr = str.length();
                }
                else if (str.length() == maxCompleteStr && ans.compareTo(str) > 0){
                    ans = str;
                }
            }
        }
        if (ans.equals("")) return "None";
        else return ans;
    }
    public static void insertWordIntoTrie(String str, TrieNode curr){
        for (int j=0; j<str.length(); j++){
            char ch = str.charAt(j);
            if (!curr.getMap().containsKey(ch)){
                curr.getMap().put(ch, new TrieNode());
            }
            curr = curr.getMap().get(ch);
        }
        curr.setEnd(true);
    }
}
