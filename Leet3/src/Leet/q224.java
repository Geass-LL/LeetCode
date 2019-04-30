package Leet;

import java.util.*;

public class q224 {
	public int calculate(String s) {
        /*
        ˼·��ʹ��res��¼��ǰ�����sign��¼��ǰ���ţ�����ջ��ʵ�����ŵ����ȼ���
        �����ַ����е��ַ��������������ô�����������ֱ����������Ϊֹ��ȡ��������res+=sign*num�������+����ôsignΪ1�������-����ôsignΪ-1�������������
        ��ô����ǰres��sign��ֵ����ѹ��ջ�У�Ȼ��res����Ϊ0��sign����Ϊ1׼�����������е�ֵ������������ţ�˵��res�е�ǰ����������м���Ľ������ô����ջ����sign��res*=sign����������ջ���洢��֮ǰ��res��res+=res
         */
        int res=0;
        int sign=1;
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if (c>='0')
            {
                int num=c-'0';
                i++;
                while (i<s.length() && s.charAt(i)>='0')
                {
                    num=num*10+(s.charAt(i)-'0');
                    i++;
                }
                res+=sign*num;
                i--;
            }else if (c=='+')
            {
                sign=1;
            }else if (c=='-')
            {
                sign=-1;
            }else if (c=='(')
            {
                stack.add(res);
                stack.add(sign);
                res=0;
                sign=1;
            }else if (c==')'){
                res*=stack.pop();
                res+=stack.pop();
            }
        }
        return res;
    }
}
