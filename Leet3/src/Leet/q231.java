package Leet;

public class q231 {
	public boolean isPowerOfTwo(int n) {
        int temp=1;
        for(int i=0;i<31;i++){
            if(temp==n)     return true;
            else    temp<<=1;
        }
        return false;
    }
}
