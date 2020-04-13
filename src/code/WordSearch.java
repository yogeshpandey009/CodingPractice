package code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch {
    private boolean[][] visited = null;
    private Trie wordsSet = null;

    public List<String> findWords(char[][] board, String[] words) {
	visited = new boolean[board.length][board[0].length];
	wordsSet = new Trie();
	for (String word : words) {
	    wordsSet.insert(word);
	}
	Set<String> result = new HashSet<>();
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[0].length; j++) {
		List<String> found = findWordsInTrie(board,
			new StringBuilder(), i, j);
		result.addAll(found);
	    }
	}
	return new ArrayList<>(result);
    }

    private List<String> findWordsInTrie(char[][] board,
	    StringBuilder wordSoFar, int i, int j) {
	List<String> found = new ArrayList<>();
	if (i >= 0 && i < board.length && j >= 0 && j < board[0].length
		&& visited[i][j] == false) {
	    wordSoFar.append(board[i][j]);
	    String wordStr = wordSoFar.toString();
	    if (!wordsSet.startsWith(wordStr)) {
		wordSoFar.setLength(wordSoFar.length() - 1);
		return found;
	    }
	    visited[i][j] = true;
	    if (wordsSet.search(wordStr)) {
		found.add(wordStr);
	    }
	    found.addAll(findWordsInTrie(board, wordSoFar, i, j + 1));
	    found.addAll(findWordsInTrie(board, wordSoFar, i, j - 1));
	    found.addAll(findWordsInTrie(board, wordSoFar, i + 1, j));
	    found.addAll(findWordsInTrie(board, wordSoFar, i - 1, j));
	    wordSoFar.setLength(wordSoFar.length() - 1);
	    visited[i][j] = false;
	}
	return found;
    }

    class TrieNode {
	TrieNode[] arr;
	boolean isEnd;

	// Initialize your data structure here.
	public TrieNode() {
	    this.arr = new TrieNode[26];
	}
    }

    public class Trie {
	private TrieNode root;

	public Trie() {
	    root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
	    TrieNode p = root;
	    for (int i = 0; i < word.length(); i++) {
		char c = word.charAt(i);
		int index = c - 'a';
		if (p.arr[index] == null) {
		    TrieNode temp = new TrieNode();
		    p.arr[index] = temp;
		    p = temp;
		} else {
		    p = p.arr[index];
		}
	    }
	    p.isEnd = true;
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
	    TrieNode p = searchNode(word);
	    if (p == null) {
		return false;
	    } else {
		if (p.isEnd)
		    return true;
	    }
	    return false;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
	    TrieNode p = searchNode(prefix);
	    if (p == null) {
		return false;
	    } else {
		return true;
	    }
	}

	public TrieNode searchNode(String s) {
	    TrieNode p = root;
	    for (int i = 0; i < s.length(); i++) {
		char c = s.charAt(i);
		int index = c - 'a';
		if (p.arr[index] != null) {
		    p = p.arr[index];
		} else {
		    return null;
		}
	    }
	    if (p == root)
		return null;
	    return p;
	}
    }
}
