package Leet;

public class q137 {
	public int singleNumber(int[] nums) {
        int res = 0;
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            sum = 0;
            for (int num : nums) {
                sum += (num >> i) & 1;//&的作用是把移位的结果变为1或者0.
            }
            if (sum % 3 != 0) {//理论上如果全是出现了三次的话,是肯定可以整除的，无法整除只能说明，那个数据在该位的值为1.
                res |= 1 << i;//把这个1左移到本来的位置，res在当前位肯定全为0，用或操作，把当前位修改为1，且不影响其他位的数据。
            }
        }
        return res;
    }
}
