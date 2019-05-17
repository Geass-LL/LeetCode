package Leet;

/*
 * ¼ûOnenote
 */

public class q316 {
	public String removeDuplicateLetters(String s) {
		int[] nums=new int[26];
		boolean[] visited=new boolean[26];
		for(int i=0;i<s.length();i++) {
			nums[s.charAt(i)-'a']++;
		}
		char[] res=new char[s.length()];
		int resi=0;
		if(s==null||s.length()==0)	return "";
		res[0]=s.charAt(0);
		nums[s.charAt(0)-'a']--;
		visited[s.charAt(0)-'a']=true;
		for(int i=1;i<s.length();i++) {
			char ch=s.charAt(i);
			nums[ch-'a']--;
			if(visited[ch-'a'])	continue;
			while(resi>=0&&ch<res[resi]&&nums[res[resi]-'a']>0) {
				visited[res[resi]-'a']=false;
				resi--;
			}
			res[++resi]=ch;
			visited[ch-'a']=true;
		}
		return String.valueOf(res,0,resi+1);
    }
}
