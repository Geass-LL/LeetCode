package Leet;
/*
 * ����OneNote��˼·д�ġ�������iλ�õ�ֵcur[i+1]�洢���������㴦�����ơ������� ���ַ�i-2�������
 */

public class q32 {
    public int longestValidParentheses(String s) {
    	int res=0;
    	int[] cur=new int[s.length()+1];
    	cur[0]=0;
    	for (int i=0;i<s.length();i++) {
    		if(s.charAt(i)=='(') {
    			cur[i+1]=0;
    		}else if(i>=1&&s.charAt(i-1)=='(') {
    			cur[i+1]=cur[i-1]+2;
    		}else if(i>=cur[i]+1&&s.charAt(i-1)==')'&&s.charAt(i-cur[i]-1)=='(') {
    			cur[i+1]=cur[i]+2+cur[i-cur[i]-1];
    		}else {
    			cur[i+1]=0;
    		}
    		res=Math.max(res,cur[i+1]);
    	}
    	return res;
    }
}