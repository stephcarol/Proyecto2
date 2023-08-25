package ec.edu.espol.model;

import java.util.ArrayList;
import java.util.List;


public class Trie {	
    private TrieNode root;
    private static final int R = 256;

    public Trie() {
        root = new TrieNode();
    }

    private class TrieNode {

        private boolean isEnd;
        private TrieNode[] children;

        public TrieNode() {
            isEnd = true;
            children = new TrieNode[R];
        }

        public boolean isIsEnd() {
            return isEnd;
        }

        public void setIsEnd(boolean isEnd) {
            this.isEnd = isEnd;
        }

        public TrieNode[] getChildren() {
            return children;
        }

        public void setChildren(TrieNode[] children) {
            this.children = children;
        }
    }
    
    
    // Inserts a word into the trie.
    public void insert(String word) {
    	TrieNode current = root;
    	for(int i=0, L=word.length(); i<L; i++) {
        	int id = word.charAt(i) - 0;
        	if(current.children[id]==null) {
        		current.children[id] = new TrieNode();
        		current.children[id].isEnd = false;
        	}
        	current = current.children[id];
        }
        current.isEnd = true;
    }
    
    public void insertAll(List<String> list){
        for(String s: list){
            insert(s);
        }
    }

    
    // Retorna si la palabra contiene en el trie
    public boolean contains(String word) {
        List<String> list = listWords();
        for (String s:list){
            if(s.equals(word)){
                return true;
            }
        }
        return false;
    }

  
    //Retorna boolean si existe alguna palabra en el trie que empiece con algun prefijo 
    public boolean containsPrefix(String prefix) {
        return buscar(prefix, 2);
    }
    
    private boolean buscar(String str, int type) {
        TrieNode current = root;
        int i = 0;
        int length = str.length();

        while (i < length) {
            char ch = str.charAt(i);
            int id = ch - 'a'; 
            if (current.children[id] == null) {
                return false;
            }
            current = current.children[id];
            i++;
        }

        if (type == 1) {
            return current.isEnd;
        } else {
            return true;
        }
    }
    
    
    //list of words in the trie
    public List<String> listWords() {
    	List<String> list = new ArrayList<>();
    	list(root, 0, "", list);
    	return list;
    }
    
    
    private void list(TrieNode current, int id, String prefix, List<String> list) {
        if (current == null) {
            return;
        }
        for (int i = 0; i < R; i++) {
            TrieNode child = current.children[i];
            if (child != null) {
                String res = prefix + (char) i;
                if (child.isEnd) {
                    list.add(res);
                }
                list(child, i, res, list);
            }
        }
    }
    
    // print trie contents
    public String print() {
         //print("", root, 0, true, true);
         String output = print("", root, 0, false, true, "");
        return output;
        
    }
    
    private String print(String prefix, TrieNode root, int id, boolean isTail, boolean isRoot, String output) {
        if (!isRoot) {
            output += prefix +
                    (isTail ? "  `--- " : "  |--- ") +
                    (char) id +
                    (root.isEnd ? " ***" : "") + "\n";
        }

        TrieNode lastChild = null; // last child of root
        int lastChildId = 0; // id of last child
        boolean isLastChild = true;
        for (int i = R - 1; i >= 0; i--) {
            if (root.children[i] != null) {
                if (isLastChild) {
                    isLastChild = false;
                    lastChild = root.children[i];
                    lastChildId = i;
                } else {
                    output = print(prefix + (isRoot ? "" : (isTail ? "      " : "  |   ")), root.children[i], i, false, false, output);
                }
            }
        }
        if (lastChild != null) {
            output = print(prefix + (isRoot ? "" : (isTail ? "      " : "  |   ")), lastChild, lastChildId, true, false, output);
        }

        return output;
    }
  

    public void delete(String word) {
        if (contains(word)) {
            delete(root, word, 0);
        }
    }

    private void delete(TrieNode current, String word, int depth) {
        if (depth == word.length()) {
            current.isEnd = false;
            return;
        }

        char charToDelete = word.charAt(depth);
        int charIndex = charToDelete - 'a';

        TrieNode nextNode = current.children[charIndex];
        if (nextNode == null) {
            return;
        }

        delete(nextNode, word, depth + 1);

        // Eliminar nodos no utilizados
        if (!nextNode.isEnd && isNodeEmpty(nextNode)) {
            current.children[charIndex] = null;
        }
    }

    private boolean isNodeEmpty(TrieNode node) {
        for (TrieNode child : node.children) {
            if (child != null) {
                return false;
            }
        }
        return true;
    }
    
}
