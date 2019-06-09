package Main;

public class MergeSort {
	public void mergeSort(int[] nums) {
		mergesort(nums,0,nums.length-1);
	}
	void mergesort(int[] nums,int start,int end) {
    	int length=end-start+1;
    	if(length<=1)	return;
    	if(length==2) {
    		if(nums[start]<=nums[start+1])	return;
    		nums[start]=nums[start]^nums[start+1];
    		nums[start+1]=nums[start]^nums[start+1];
    		nums[start]=nums[start]^nums[start+1];
    		return;
    	}
    	mergesort(nums,start,start+length/2);
    	mergesort(nums,start+length/2+1,end);
    	int[] temp=new int[length];
    	int j1=start+length/2,j2=end,j=length-1;
    	while(j1>=start&&j2>=start+length/2+1) {
    		if(nums[j1]>nums[j2]) {
    			temp[j--]=nums[j1--];
    		}else {
    			temp[j--]=nums[j2--];
    		}
    	}
    	while(j1>=start) {
    		temp[j--]=nums[j1--];
    	}
    	while(j2>=start+length/2+1) {
    		temp[j--]=nums[j2--];
    	}
    	for(int i=0;i<length;i++) {
    		nums[start+i]=temp[i];
    	}
    }
}
