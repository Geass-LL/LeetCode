package Leet;



import java.util.*;

/*
 * �ο����ͣ�https://www.cnblogs.com/grandyang/p/4814506.html
 * �����һ��ʽ�ӿ���A+B+C+D����ʽ�����е�ABCD�����Ǹ�����Ҳ���������ֵ����˻���
 * ��ô�����diff���Ǳ�ʾÿһ����ABCD��
 * ���統ǰ��������A+B,��ֵΪc
 * ���ڼӷ���diffֱ�Ӹ���ֵ���ɣ�A+B+c
 * ���Ǽ�����diffΪ��ֵ�ĸ�����A+B+(-c)
 * ���ǳ˷����µ�diffӦ��Ϊǰһ��diff�뵱ǰ��ֵ��˰�˻���A+(B*c)
 * curnum���ʾ���㵽��ǰΪֹ��ȡֵ���Ӽ�����������⣻
 * ���ڳ˷�����һ��curnum=A+B,���е�BΪ��һ��diff,��ô�µ�curnumӦ��Ϊnew_curnum=A+B*c=curnum-diff+diff*c
 */
public class q282 {
	public List<String> addOperators(String num, int target) {
		List<String> res=new ArrayList<String>();
		helper(num,target,0,0,"",res);
		return res;
    }
	void helper(String num,int target,long diff,long curnum,String tempres,List<String> res) {
		if(num.length()==0&&curnum==target) {
			res.add(tempres);
			return;
		}
		for(int i=1;i<=num.length();i++) {
			String cur=num.substring(0, i);
			if(cur.length()>1&&cur.charAt(0)=='0')	return;//�ų�0����������
			String next=num.substring(i);
			if(tempres.length()>0) {
				helper(next,target,Long.valueOf(cur),curnum+Long.valueOf(cur),tempres+"+"+cur,res);
				helper(next,target,-Long.valueOf(cur),curnum-Long.valueOf(cur),tempres+"-"+cur,res);
				helper(next,target,diff*Long.valueOf(cur),(curnum-diff)+diff*Long.valueOf(cur),tempres+"*"+cur,res);
			}else {
				helper(next,target,Long.valueOf(cur),Long.valueOf(cur),cur,res);//����д����Ϊʽ���ʼû�з��ţ��ǵ���������
			}
		}
	}
}
