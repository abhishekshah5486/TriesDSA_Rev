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
public class ShortestUniquePrefix {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        TrieNode curr = new TrieNode();
        // String[] words = {"zebra", "dog", "duck", "dove"};
        String[] words = {"apple", "ball", "cat"};
        for (int j=0; j<words.length; j++){
            insertWordIntoTrie(words[j], curr);
        }
        List<String> ans = new ArrayList<>();
        solveShortestUniquePrefix(words, ans, curr);
        printList(ans);

        scn.close();
    }
    public static void solveShortestUniquePrefix(String[] words,  List<String> ans, TrieNode curr){
        for (int j=0; j<words.length; j++){
            int lastUniqueIdx = -1;
            TrieNode currNode = curr;
            for (int k=0; k<words[j].length(); k++){
                char ch = words[j].charAt(k);
                if (currNode.getMap().size() > 1) lastUniqueIdx = k;
                currNode = currNode.getMap().get(ch);
            }
            if (lastUniqueIdx == -1) ans.add(words[j].substring(0, words[j].length()));
            else ans.add(words[j].substring(0, lastUniqueIdx + 1));
        }
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
    public static boolean searchIntoTrie(String str, TrieNode curr){
        for (int j=0; j<str.length(); j++){
            char ch = str.charAt(j);
            if (!curr.getMap().containsKey(ch)) return false;
            curr = curr.getMap().get(ch);
        }
        if (curr.isEnd() == false) return false;
        return true;
    }
    public static void printList(List<String> arr){
        for (int j=0; j<arr.size(); j++){
            System.out.print(arr.get(j) + " ");
        }
    }
}
