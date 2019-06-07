package Leet;

/*
 * A和B玩这个游戏，A先取；
 * 事实上只有当n为4的倍数时，A才会输。
 * 原因：如果不是4的倍数，那么n%4的值为1，2，3，第一步A只需取这么n%4个石子；
 * 其后无论B取多少石子，A总是保证剩余石子数为4的倍数即可；那么最后肯定是A取剩下的石子。
 * 
 */

public class q292 {
	public boolean canWinNim(int n) {
		return n%4!=0;
    }
}
