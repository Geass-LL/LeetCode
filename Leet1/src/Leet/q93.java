package Leet;

import java.util.*;

/*
 * ����Ļ��ݷ��������Ѿ������������û��ݷ�����ʽ�ˡ�
 */

public class q93 {
	public List<String> restoreIpAddresses(String s) {
        List<String> res=new ArrayList<String>();
        btk(res,"",s,0);
        return res;
    }
	void btk(List<String> res,String temp,String s,int deep) {
		if(deep==3) {
			if(valid(s)){
				res.add(new String(temp+s));
			}else {
				return;
			}
		}else {
			deep++;
			int i=1;
			while(s.length()>=i&&valid(s.substring(0, i))) {//ֱ����whileѭ����Ѱ�ҿ��н�
				temp=temp+s.substring(0,i)+'.';
				btk(res,temp,s.substring(i),deep);
				temp=temp.substring(0,temp.length()-i-1);
				i++;
			}
		}
	}
	boolean valid(String s) {
		if(s.length()>0&&s.length()<4) { //ע��������ȹ������ܻ�����תΪint�Ĵ���
			int temp=Integer.valueOf(s);
			if(String.valueOf(temp).length()==s.length()&&temp<256) //���ݳ������ȥ��00��01���������������
				return true;
		}
		return false;
	}
}
