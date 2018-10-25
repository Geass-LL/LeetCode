package Leet;

public class q66 {
	public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--) {
        	int temp=digits[i]+1;
        	if(temp>=10) {
        		digits[i]=temp-10;
        	}else {
        		digits[i]=temp;
        		return digits;
        	}
        }
        int[] res=new int[digits.length+1];
        res[0]=1;
        for(int i=0;i<digits.length;i++) {
        	res[i+1]=digits[i];
        }
        return res;
    }
}
