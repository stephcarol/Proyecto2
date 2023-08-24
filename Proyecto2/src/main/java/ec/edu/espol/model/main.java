/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ec.edu.espol.model;

/**
 *
 * @author USER
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Trie trie = new Trie();
    	trie.insert("abc");
    	trie.insert("bay");
    	trie.insert("bey");
    	trie.insert("bea");
    	trie.insert("bed");
    	trie.insert("bee");
    	trie.insert("boy");
    	trie.insert("boyc");
    	trie.insert("boyd");
    	trie.insert("boye");
    	trie.insert("boycd");
    	trie.insert("bye-bye");
    	trie.insert("by-by");
    	trie.insert("bye");
    	trie.insert("zad");
    	trie.insert("zed");
    	trie.insert("zef");
    	trie.insert("cda");
        trie.insert("abcdd");
        
    	System.out.println("trie content (*** indicates the end of a word): ");
    	String s=trie.print();
        System.out.println(s);
    	System.out.println();

    	System.out.println("list of words in trie: ");
    	System.out.println(trie.listWords());
    	System.out.println();
    	
    	System.out.println("contains boy? " + trie.contains("boy"));
    	System.out.println("contains bo? " + trie.contains("bo"));
    	System.out.println("contains boye? " + trie.contains("boye"));
    	System.out.println("contains byebye? " + trie.contains("byebye"));
    	System.out.println("contains bye-bye? " + trie.contains("bye-bye"));
    	
    	System.out.println();
    	
    	System.out.println("contains prefix bo? " + trie.containsPrefix("bo"));
    	System.out.println("contains prefix b o? " + trie.containsPrefix("b o"));
    	System.out.println("contains prefix bye? " + trie.containsPrefix("bye"));
    	System.out.println("contains prefix ye? " + trie.containsPrefix("ye"));
    	
    	
    	/*
		expected output:
		trie content (*** indicates the end of a word): 
		├── b
		│   ├── o
		│   │   └── y ***
		│   │       ├── d ***
		│   │       ├── c ***
		│   │       │   └── d ***
		│   │       └── e ***
		│   ├── e
		│   │   ├── e ***
		│   │   ├── d ***
		│   │   ├── a ***
		│   │   └── y ***
		│   ├── a
		│   │   └── y ***
		│   └── y
		│       ├── -
		│       │   └── b
		│       │       └── y ***
		│       └── e ***
		│           └── -
		│               └── b
		│                   └── y
		│                       └── e ***
		├── a
		│   └── b
		│       └── c ***
		└── z
		    ├── a
		    │   └── d ***
		    └── e
		        ├── d ***
		        └── f ***
		
		list of words in trie: 
		[abc, bay, bea, bed, bee, bey, boy, boyc, boycd, boyd, boye, by-by, bye, bye-bye, zad, zed, zef]
		
		contains boy? true
		contains bo? false
		contains boye? true
		contains byebye? false
		contains bye-bye? true
		
		contains prefix bo? true
		contains prefix b o? false
		contains prefix bye? true
		contains prefix ye? false
		*/
    }
    
}
