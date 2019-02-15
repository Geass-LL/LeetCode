package Leet;

public class q189 {
	/*
	public void rotate(int[] nums, int k) {
		int length=nums.length;
		for(int i=0;i<k;i++) {
			int temp=nums[length-1];
			for(int j=length-1;j>0;j--) {
				nums[j]=nums[j-1];
			}
			nums[0]=temp;
		}
    }*/
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}
