package Leet;

/*
 * ע�͵����ַ�����ʵ��һ���ģ�ֻ������һ�ַ��������漰����ıȽϣ�����Ч�ʸ��ͣ����ɶ���ǿ��
 * ��1��2��3��4��5��Ϊ���ӣ������ֵͨ������2����ĳ������3����ĳ������5����ĳ��������Сֵ�õ���
 * ֻҪ������Сֵ��ȵ�������˵������λ�þ�Ӧ�ú��ơ�
 */

public class q264 {
	public int nthUglyNumber(int n) {
		if(n<=5) return n;
		int[] nums=new int[n+1];
		int i=0;
		while(i<=5) {
			nums[i]=i++;
		}
		/*
		int[] pos= {3,2,2};
		int[] p= {2,3,5};
		while(i<=n) {
			int[] value= {p[0]*nums[pos[0]],p[1]*nums[pos[1]],p[2]*nums[pos[2]]};
			int min=Math.min(value[0], Math.min(value[1], value[2]));
			nums[i++]=min;
			for(int j=0;j<3;j++) {
				if(value[j]==min) pos[j]++;
			}
		}
		*/
		/*
		int pos2=3,pos3=2,pos5=2;
		while(i<=n) {
			int num1=nums[pos2]*2,num2=nums[pos3]*3,num3=nums[pos5]*5;
			if(num1<num2&&num1<num3) {
				pos2++;
				nums[i++]=num1;
			}else if(num2<num1&&num2<num3) {
				pos3++;
				nums[i++]=num2;
			}else if(num3<num2&&num3<num1) {
				pos5++;
				nums[i++]=num3;
			}else if(num1==num2&&num1<num3) {
				pos2++;
				pos3++;
				nums[i++]=num1;
			}else if(num2==num3&&num2<num1) {
				pos3++;
				pos5++;
				nums[i++]=num2;
			}else if(num3==num1&&num3<num2) {
				pos2++;
				pos5++;
				nums[i++]=num3;
			}else if(num1==num2&&num1==num3) {
				pos2++;
				pos3++;
				pos5++;
				nums[i++]=num1;
			}
		}*/
		for(int j=0;j<=n;j++) {
			System.out.println(String.valueOf(nums[j])+' ');
		}
		return nums[n];
    }
}
