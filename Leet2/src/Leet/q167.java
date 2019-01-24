package Leet;

public class q167 {
	public int[] twoSum(int[] numbers, int target) {
		int[] res= {0,0};
        for(int i=0;i<numbers.length;i++) {
        	int searchvalue=target-numbers[i];
        	int left=i,right=numbers.length-1;
        	while(left<=right) {
        		int mid=(left+right)/2;
        		if(numbers[mid]==searchvalue) {
        			res[0]=i+1;
        			res[1]=mid+1;
        			if(res[0]==res[1]) res[1]++;
        			return res;
        		}else if(numbers[mid]<searchvalue) {
        			left=mid+1;
        		}else {
        			right=mid-1;
        		}
        	}
        }
        return res;
    }
}
