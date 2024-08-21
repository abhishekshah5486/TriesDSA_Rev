import java.util.*;

class TrieNode{
    private Map<Character, TrieNode> map;
    private boolean isEnd;

    public TrieNode(){
        this.map = new HashMap<>();
        this.isEnd = false;
    }
    // Getters
    public Map<Character, TrieNode> getMap(){
        return this.map;
    }
    public boolean getIsEnd(){
        return this.isEnd;
    }
    public void setIsEnd(boolean bool){
        this.isEnd = bool;
    }
}

public class TriesImpl {
    public static void main(String[] args) {
        TrieNode curr = new TrieNode();
        String str = "Abhishek";
        insertIntoTrie(str, curr);
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
    public static void searchIntoTrie(String str, TrieNode curr){
        
    }
}
