package Leet;


public class q91 {
	public int numDecodings(String s) {
		int i=0;
		int[] res=new int[s.length()+1];
		while(i<s.length()) {
			if(s.charAt(i)=='0') {	//�����ǰΪ0
				if(i>=1&&(s.charAt(i-1)=='1'||s.charAt(i-1)=='2')) { 	//���0�п������10����20����Ϊǰ�����Ľ��
						res[i+1]=res[i-1];
				}else {	//���û�����10��20�Ŀ��ܣ���ô��ǰλ��Ϊ0
					res[i+1]=0;	//ֱ�ӽ���
					break;
				}
				i++;
			}else if(i==0){	//��0��ʼ��0λ�ó�ʼ��Ϊ1��1λ��Ҳ��ʼ��Ϊ1
				res[0]=1;
				res[1]=1;
				i++;
			}else {
				int temp=(s.charAt(i-1)-'0')*10+(s.charAt(i)-'0');
				if(temp>10&&temp<=26) {	//ǰһ�����ַ�0��������11��26�ķ�Χ��
					res[i+1]=res[i]+res[i-1];	//�������ϲ���Ϊres[i-1]�����ϲ���Ϊres[i]���ϲ��벻�ϲ���������
				}else {
					res[i+1]=res[i];	//����
				}
				i++;
			}
		}
		return res[s.length()];
    }
	
}
