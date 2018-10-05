package Leet;

/*
 * 去你妈的，一个比一个溜，用起了Long，我在这里拼命想怎么才能好好处理越界的问题，4个if-else不想捣鼓了。
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
            //每次减的时候都用移位的方法尝试减最大的可能值。
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
