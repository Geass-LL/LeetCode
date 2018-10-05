package Leet;

/*
 * ȥ����ģ�һ����һ���������Long����������ƴ������ô���ܺúô���Խ������⣬4��if-else���뵷���ˡ�
 */
public class q29 {
	public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int res=0;
        while(a>=b){
            long x=b;
            long y=1;
            //ÿ�μ���ʱ������λ�ķ������Լ����Ŀ���ֵ��
            while(a>=(x<<1)){
                x<<=1;
                y<<=1;
            }
            a-=x;
            res+=y;
        }
        if ((dividend < 0 && divisor > 0) || dividend > 0 && divisor < 0) {
            return -res;
        }
        return res;
    }
}
