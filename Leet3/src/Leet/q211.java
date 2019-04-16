package Leet;

public class q211 {
	public boolean end;
	public q211[] next;
	/** Initialize your data structure here. */
    public q211() {
        end=false;
        next=new q211[26];
    }
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        char[] chs=word.toCharArray();
        q211 node=this;
        for(int i=0;i<chs.length;i++) {
        	if(node.next[chs[i]-'a']==null) {
        		node.next[chs[i]-'a']=new q211();
        	}
        	node=node.next[chs[i]-'a'];
        }
        node.end=true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
    	return btk(this,word);
    }
    public boolean btk(q211 cur,String word) {
    	if(word==null||word.length()==0) return cur.end;
    	char ch=word.charAt(0);
    	if(ch=='.') {
    		boolean cho=false;
    		for(int i=0;i<26;i++) {
    			if(cur.next[i]!=null) {
    				cho=cho||btk(cur.next[i],word.substring(1));
    				if(cho)		return true;
    			}
    		}
    		return false;
    	}else {
    		if(cur.next[ch-'a']!=null) {
    			return btk(cur.next[ch-'a'],word.substring(1));
    		}else {
    			return false;
    		}
    	}
    }
}
