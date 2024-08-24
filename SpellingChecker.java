import java.util.*;

class TrieNode{
    private Map<Character, TrieNode> map;
    private boolean isEnd;

    public TrieNode(){
        this.map = new HashMap<>();
        this.isEnd = false;
    }
    public Map<Character, TrieNode> getMap(){
        return this.map;
    }
    public boolean getIsEnd(){
        return this.isEnd;
    }
    public void setIsEnd(boolean bool){
        this.isEnd = bool;
    }
    public void setMap(Map<Character, TrieNode> map){
        this.map = map;
    }
}

public class SpellingChecker {
    public static void main(String[] args) {
        TrieNode curr = new TrieNode();
        String[] A = {"hat", "cat", "rat"};
        for (int j=0; j<A.length; j++){
            insertIntoTrie(A[j], curr);
        }
        String[] B = {"cat", "ball"};
        int[] ans = new int[B.length];
        solveSpellingChecker(B, ans, curr);
        
    }
    public static void solveSpellingChecker(String[] B, int[] ans, TrieNode curr){
        for (int j=0; j<B.length; j++){
            String str = B[j];
            TrieNode replCurr = curr;

            for (int k=0; k<str.length(); k++){
                char ch = str.charAt(k);
                if (!replCurr.getMap().containsKey(ch)){
                    ans[j] = 0;
                    break;
                }
                replCurr = replCurr.getMap().get(ch);
            }
            if (!replCurr.getIsEnd()) ans[j] = 0;
            else ans[j] = 1;
        }
    }
    public static void insertIntoTrie(String str, TrieNode curr){
        for (int j=0; j<str.length(); j++){
            char ch = str.charAt(j);
            if (!curr.getMap().containsKey(ch)){
                curr.getMap().put(ch, new TrieNode());
            }
            curr = curr.getMap().get(ch);
        }
        curr.setIsEnd(true);
    }
}
