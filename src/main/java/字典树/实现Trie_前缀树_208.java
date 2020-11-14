package 字典树;

import java.util.*;

public class 实现Trie_前缀树_208 {
}

class Trie {

    private TrieNode root = new TrieNode(null);

    /**
     * Initialize your data structure here.
     */
    public Trie() {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null) {
            return;
        }
        TrieNode curNode = root;
        for (int i = 0; i < word.length(); i++) {
            char childChar = word.charAt(i);
            if (!curNode.contains(childChar)) {
                curNode.put(childChar);
            }
            curNode = curNode.get(childChar);
        }
        curNode.setIsEnd(true);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode finalChildNode = this.getChildNode(word);
        return finalChildNode != null && finalChildNode.getIsEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode finalChildNode = this.getChildNode(prefix);
        return finalChildNode != null;
    }

    private TrieNode getChildNode(String word) {
        if (word == null) {
            return null;
        }
        TrieNode curNode = root;
        for (int i = 0; i < word.length(); i++) {
            curNode = curNode.get(word.charAt(i));
            if (curNode == null) {
                return null;
            }
        }

        return curNode;
    }

    class TrieNode {
        private Character nodeChar;
        private TrieNode[] children;
        private boolean isEnd = false;

        public TrieNode(Character nodeChar) {
            this.nodeChar = nodeChar;
            this.children = new TrieNode[26];
        }

        public TrieNode get(char childChar) {
            return this.children[childChar - 'a'];
        }

        public void put(char childChar) {
            this.children[childChar - 'a'] = new TrieNode(childChar);
        }

        public boolean contains(char childChar) {
            return this.children[childChar - 'a'] != null;
        }

        public void setIsEnd(boolean isEnd) {
            this.isEnd = isEnd;
        }

        public boolean getIsEnd() {
            return this.isEnd;
        }
    }
}

