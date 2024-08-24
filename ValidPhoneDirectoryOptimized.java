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
public class ValidPhoneDirectoryOptimized {
    public static void main(String[] args) {
        // String[] directory = {"1234", "2342", "567"};
        String[] directory = {"001", "001"};
        List<String> replDirectory = new ArrayList<>();
        TrieNode curr = new TrieNode();
        for (int j=0; j<directory.length; j++){
            replDirectory.add(directory[j]);
        }
        boolean finalAns = isValidPhoneDirectory(replDirectory, curr);
        System.out.println(finalAns);
    }
    public static boolean isValidPhoneDirectory(List<String> replDirectory, TrieNode curr){
        for (int j=0; j<replDirectory.size(); j++){
            TrieNode replCurr = curr;
            String str = replDirectory.get(j);
            boolean flag = true;

            for (int k=0; k<str.length(); k++){
                char ch = str.charAt(k);
                if (!replCurr.getMap().containsKey(ch)){
                    replCurr.getMap().put(ch, new TrieNode());
                    flag = false;
                }
                replCurr = replCurr.getMap().get(ch);
                if (replCurr.getIsEnd()) return false;
            }
            replCurr.setIsEnd(true);
            if (flag) return false;
        }
        return true;
    }
}
