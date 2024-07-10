package Assignment.Day5;

import java.util.HashMap;
import java.util.Map;

class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node current = root;
        for (char ch : word.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                current.children.put(ch, new Node());
            }
            current = current.children.get(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean isPrefix(String prefix) {
        Node current = root;
        for (char ch : prefix.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return false;
            }
            current = current.children.get(ch);
        }
        return true;
    }

    private static class Node {
        boolean isEndOfWord;
        Map<Character, Node> children;

        public Node() {
            isEndOfWord = false;
            children = new HashMap<>();
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        // Insert some words into the Trie
        trie.insert("apple");
        trie.insert("banana");
        trie.insert("app");
        trie.insert("application");

        // Check if some prefixes are present in the Trie
        System.out.println("Is 'ap' a prefix? " + trie.isPrefix("ap")); // true
        System.out.println("Is 'ban' a prefix? " + trie.isPrefix("ban")); // true
        System.out.println("Is 'or' a prefix? " + trie.isPrefix("or")); // false
        System.out.println("Is 'applic' a prefix? " + trie.isPrefix("applic")); // true
    }
}