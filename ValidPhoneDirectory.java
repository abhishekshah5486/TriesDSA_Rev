import java.util.*;

class TrieNode{
    private Map<Character, TrieNode> map;
    private boolean isEnd;
    private int counter;

    public TrieNode(){
        this.map = new HashMap<>();
        this.isEnd = false;
        this.counter = 0;
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
    public int getCounter(){
        return this.counter;
    }
    public void incrementCounter(){
        this.counter = this.counter + 1;
    }
}
public class ValidPhoneDirectory {
    public static void main(String[] args) {
        // String[] directory = {"1234", "2342", "567"};
        String[] directory = {"001", "001"};
        List<String> replDirectory = new ArrayList<>();
        TrieNode curr = new TrieNode();
        for (int j=0; j<directory.length; j++){
            replDirectory.add(directory[j]);
            insertIntoTrie(directory[j], curr);
        }
        boolean finalAns = isValidPhoneDirectory(replDirectory, curr);
        System.out.println(finalAns);
    }
    public static boolean isValidPhoneDirectory(List<String> replDirectory, TrieNode curr){
        for (int j=0; j<replDirectory.size(); j++){
            TrieNode replCurr = curr;
            String str = replDirectory.get(j);

            for (int k=0; k<str.length(); k++){
                char ch = str.charAt(k);
                replCurr = replCurr.getMap().get(ch);
                if (replCurr.getIsEnd() && k < (str.length() - 1)) return false;
            }
            if (replCurr.getCounter() > 1) return false; 
        }
        return true;
    }
    public static void insertIntoTrie(String str, TrieNode curr){
        for (int j=0; j<str.length(); j++){
            char ch = str.charAt(j);
            if (!curr.getMap().containsKey(ch)){
                curr.getMap().put(ch, new TrieNode());
            }
            curr = curr.getMap().get(ch);
            curr.incrementCounter();
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