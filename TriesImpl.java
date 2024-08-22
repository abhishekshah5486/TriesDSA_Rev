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
    public void setMap(Map<Character, TrieNode> map){
        this.map = map;
    }
}
public class TriesImpl {
    public static void main(String[] args) {
        TrieNode curr = new TrieNode();
        String str = "Abhishek";
        insertIntoTrie(str, curr);
        System.out.println(searchIntoTrie("Abhi", curr));
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
    public static boolean searchIntoTrie(String str, TrieNode curr){
        for (int j=0; j<str.length(); j++){
            char ch = str.charAt(j);
            if (!curr.getMap().containsKey(ch)){
                return false;
            }
            curr = curr.getMap().get(ch);
        }
        if (curr.getIsEnd() == false) return false;
        return true;
    }
}
