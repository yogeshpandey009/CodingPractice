package code;

public class TrieSearch {

    Node trie = new Node('$');

    public static void main(String[] args) {
        TrieSearch wordDictionary = new TrieSearch();
        wordDictionary.addWord("w");
        System.out.println(wordDictionary.search("."));
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        // word = word + "*";
        char[] chars = word.toCharArray();
        Node curr = trie;
        for (char c : chars) {
            Node n = new Node(c);
            Node child = curr.children[c - 'a'];
            if (child == null) {
                curr.children[c - 'a'] = n;
                child = n;
            }
            curr = child;
        }
        curr.isLeaf = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchHelper(word, trie);
    }

    private boolean searchHelper(String word, Node trie) {
        if ("".equals(word)) {
            if (trie.isLeaf)
                return true;
            return false;
        }
        char c = word.charAt(0);
        if (c != '.') {
            Node child = trie.children[c - 'a'];
            if (child == null) {
                return false;
            } else {
                trie = child;
                return searchHelper(word.substring(1), trie);
            }
        } else {
            for (Node child : trie.children) {
                if (child != null && searchHelper(word.substring(1), child))
                    return true;
            }
        }
        return false;
    }

    class Node {
        char value;
        Node[] children;
        boolean isLeaf = false;

        Node(Character value) {
            this.value = value;
            this.children = new Node[26];
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
