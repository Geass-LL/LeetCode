package Leet;

/*
 * ʱ�䵹�ǳ���100%�����Ǵ��벻�����������õ���̰���㷨��
 * 1����gas-cost��ʾʣ������
 * 2����start��ʼ�����ʣ����С��0��ֱ��������
 * �Ӵ���0��ʣ������ʼ�Ӻͣ�ֱ����С��0���¼�¼start����Ҫ�ҵ��������ѭ����start��
 * ���ѭ��������start��
 * start�ҵ����Ҳû���ҵ��������ѭ���ģ�����-1.
 */

public class q134 {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if(gas.length==0||gas==null) return 0;
		int start=0,length=gas.length;
		int[] remain=new int[length];
		for(int i=0;i<length;i++) {
			remain[i]=gas[i]-cost[i];//��gas-cost��ʾʣ������
		}
		while(start<length) {
			if(remain[start]>=0) {
				int cursum=0,i=start;
				while(i<length) {
					cursum+=remain[i];
					if(cursum<0) {//�Ӵ���0��ʣ������ʼ�Ӻͣ�ֱ����С��0���¼�¼start��
						start=i+1;
						break;
					}else {
						i++;
					}
				}
				if(i>=length) {//��Ҫ�ҵ��������ѭ����start��
					while(i-length<start) {
						cursum+=remain[i-length];
						if(cursum<0) {
							return -1;
						}else {
							i++;
						}
					}
					return start;//��Ҫ�ҵ��������ѭ����start��
				}
			}else {
				start++;//���ʣ����С��0��ֱ��������
			}
		}
		return -1;//start�ҵ����Ҳû���ҵ��������ѭ���ģ�����-1.
    }
}
