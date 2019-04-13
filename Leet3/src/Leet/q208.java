package Leet;

import java.util.*;

public class q208 {
	/** Initialize your data structure here. */
    public q208() {}
    class TrieNode {
    	public boolean end;
    	public TrieNode[] children;
    	public TrieNode() {
    		end=false;
    		children=new TrieNode[26];
    	}
    }
    TrieNode root=new TrieNode();

    public void insert(String word) {
    	if(word==null) return;
    	char[] chs=word.toCharArray();
    	TrieNode node=root;
    	for(int i=0;i<chs.length;i++) {
    		int index=chs[i]-'a';
    		if(node.children[index]==null) {
    			node.children[index]=new TrieNode();
    		}
    		node=node.children[index];
    	}
    	node.end=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] chs=word.toCharArray();
        TrieNode node=root;
        for(int i=0;i<chs.length;i++) {
        	int index=chs[i]-'a';
        	if(node.children[index]==null) {
        		return false;
        	}
        	node=node.children[index];
        }
        return node.end;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	char[] chs=prefix.toCharArray();
        TrieNode node=root;
        for(int i=0;i<chs.length;i++) {
        	int index=chs[i]-'a';
        	if(node.children[index]==null) {
        		return false;
        	}
        	node=node.children[index];
        }
        return true;
    }
}