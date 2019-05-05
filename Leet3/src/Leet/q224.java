package Leet;

import java.util.*;

public class q224 {
	public int calculate(String s) {
        /*
        思路：使用res记录当前结果，sign记录当前符号，利用栈来实现括号的优先计算
        遍历字符串中的字符，如果是数字那么继续往后遍历直到不是数字为止获取整个数，res+=sign*num；
        如果是+，那么sign为1；如果是-，那么sign为-1；
        如果是左括号那么将当前res、sign的值依次压入栈中，然后将res重置为0、sign重置为1准备计算括号中的值；
        如果是右括号，说明res中当前存的是括号中计算的结果，那么弹出栈顶的sign，res*=sign，
        继续弹出栈顶存储的之前的res，res+=res
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
