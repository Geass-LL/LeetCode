import java.util.*;

public class Main {
	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt(),k=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=i;
        }
        int i=1;
        while(i<k){
        	i++;
            nextnums(nums,m);
        }
        char[] res=new char[m+n];
        Arrays.fill(res, 'z');
        for(i=0;i<n;i++) {
        	res[nums[i]]='a';
        }
        System.out.println(String.valueOf(res));
    }
    static void nextnums(int[] nums,int m){
        int pos=nums.length-1;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]>=m+i){
                pos--;
            }else{
                if(pos<nums.length-1){
		            nums[pos]++;
		            for(int j=pos+1;j<nums.length;j++){
		                nums[j]=nums[j-1]+1;
		            }
		        }else {
		        	nums[i]++;
		        }
                return;
            }
        }
    }
}
