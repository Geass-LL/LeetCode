package Leet;

public class q65 {
	public boolean isNumber(String s) {
		if(s==null||s.length()==0) return false;
		int i=0,length=s.length();
		//����ǰ��Ŀո�
		if(s.charAt(0)==' ') {
			return isNumber(s.substring(1, length));
		}
		if(s.charAt(length-1)==' ') {
			return isNumber(s.substring(0,length-1));
		}
		int state=0,dnum=0;
		boolean over=false;
		while(i<length) {
			char cur=s.charAt(i);
			if(isvalid(cur)) {
				//state=0Ϊ�����ʼ���ַ�
				if(state==0) {
					if(cur=='e')
						return false;
					else {
						state=1;//�����׶�
						if(cur=='.') dnum=1;//��¼.����Ŀ
                        else if(isnum(cur)) over=true;//���Խ��������һλ���������֣�
					}
				}else if(state==1) {
					if(isnum(cur)&&dnum<=1) {//���֣���С�������С�ڵ���1��OK
						over=true;
					}else if(cur=='e'&&over&&dnum<=1) {//������e��over��ʾǰ����ֹ����֣�dnum��ʾС�������С�ڵ���1
						over=false;//������e���ܽ���
						state=2;//ת��e���
					}else if(cur=='.'&&dnum<=1) {//��¼С�������
						dnum+=1;
                        if(dnum>=2) return false;//������������
					}else {
						return false;
					}
				}else if(state==2) {
					if((cur=='-'||cur=='+')&&!over) {//ǰ��û���ֹ����֣��������ȳ���-����+
					}else if(isnum(cur)) {//����������
						over=true;//���Խ�����
					}else {
						return false;
					}
				}
			}else {
				return false;
			}
			i++;
		}
		if(over)	
			return true;
		else 
			return false;
    }
	boolean isvalid(char indata) {
		char[] temp={'0','1','2','3','4','5','6','7','8','9','e','.','-','+'};
		for(char eachchar:temp) {
			if(eachchar==indata)
				return true;
		}
		return false;
	}
	boolean isnum(char indata) {
		char[] temp={'0','1','2','3','4','5','6','7','8','9'};
		for(char eachchar:temp) {
			if(eachchar==indata)
				return true;
		}
		return false;
	}
}
