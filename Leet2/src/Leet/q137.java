package Leet;

public class q137 {
	public int singleNumber(int[] nums) {
        int res = 0;
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            sum = 0;
            for (int num : nums) {
                sum += (num >> i) & 1;//&�������ǰ���λ�Ľ����Ϊ1����0.
            }
            if (sum % 3 != 0) {//���������ȫ�ǳ��������εĻ�,�ǿ϶����������ģ��޷�����ֻ��˵�����Ǹ������ڸ�λ��ֵΪ1.
                res |= 1 << i;//�����1���Ƶ�������λ�ã�res�ڵ�ǰλ�϶�ȫΪ0���û�������ѵ�ǰλ�޸�Ϊ1���Ҳ�Ӱ������λ�����ݡ�
            }
        }
        return res;
    }
}
