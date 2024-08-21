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
}

public class TriesImpl {
    public static void main(String[] args) {
        
    }
}
