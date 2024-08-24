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
public class CompleteString {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        TrieNode curr = new TrieNode();
        String[] words = {"a", "ap", "app", "appl", "apple"};
        List<String> replWords = new ArrayList<>();
        for (int j=0; j<words.length; j++){
            replWords.add(words[j]);
            insertWordIntoTrie(words[j], curr);
        }
        // Sorting the string array lexicographically using Collections.sort
        Collections.sort(replWords);
        String finalAns = solveCompleteString(replWords, curr);
        System.out.println(finalAns);
        scn.close();
    }
    public static String solveCompleteString(List<String> replWords, TrieNode curr){
        int ansIdx = -1;
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
            if (flag && str.length() > maxCompleteStr){
                ansIdx = j;
                maxCompleteStr = str.length();
            }
        }
        if (ansIdx == -1) return "None";
        else return replWords.get(ansIdx);
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
    public static void printList(List<String> arr){
        for (int j=0; j<arr.size(); j++){
            System.out.print(arr.get(j) + " ");
        }
    }
}
