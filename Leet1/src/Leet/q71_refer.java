package Leet;
/*
 * ������ûʲô��˼�����ַ����ĳ�/�ֿ����ַ������顣
 */

import java.util.*;
public class q71_refer {
	public static String simplifyPath(String path) {
		
		String[] pathArray=path.split("/");
		int length=pathArray.length;
		Stack< String> stack=new Stack<>();
		String result="";
		for(int i=0;i<length;i++)
		{
			if(pathArray[i].equals("")||pathArray[i].equals("."))
			{}
			else if(pathArray[i].equals(".."))
			{
				if(!stack.isEmpty())
				{
				stack.pop();
				}
				
			}
			else {
				stack.push(pathArray[i]);
			}
		}
		if(stack.isEmpty())
			return "/";
		while(!stack.isEmpty())
		{
		result="/"+stack.pop()+result;
		}
		
		return result;
        
    }
}
