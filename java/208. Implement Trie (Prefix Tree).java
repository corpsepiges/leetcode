class TrieNode {
    // Initialize your data structure here.
    Map<Character,TrieNode> sons=new HashMap<Character,TrieNode>();
    char val;
    boolean flag=false;
    public TrieNode(char x) {
        val=x;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode(&#39; &#39;);
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(!search(word)){
            TrieNode tt=root;
            char[] ac=word.toCharArray();
            for(int i=0;i<ac.length;i++){
                Map<Character,TrieNode> sons=root.sons;
                if(sons.get(ac[i])==null){
                    TrieNode node=new TrieNode(ac[i]);
                    if(i==ac.length-1){
                        node.flag=true;
                    }
                    sons.put(ac[i],node);
                    root=node;
                }else{
                    root=sons.get(ac[i]);
                    if(i==ac.length-1){
                        root.flag=true;
                    }
                }
            }
            root=tt;
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode tt=root;
        char[] ac=word.toCharArray();
        for(int i=0;i<ac.length;i++){
            Map<Character,TrieNode> sons=root.sons;
            if(sons.get(ac[i])==null){
                root=tt;
                return false;
            }
            root=sons.get(ac[i]);
        }
        boolean ans=root.flag;
        root=tt;
        return ans;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode tt=root;
        char[] ac=prefix.toCharArray();
        for(int i=0;i<ac.length;i++){
            Map<Character,TrieNode> sons=root.sons;
            if(sons.get(ac[i])==null){
                root=tt;
                return false;
            }
            root=sons.get(ac[i]);
        }
        root=tt;
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");