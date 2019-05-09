package Leet;

public class q238 {
	public int[] productExceptSelf(int[] nums) {
        long product=1;
        int zerocount=0,zeropos=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) {
                if(zerocount==0){
                    zeropos=i;
                    zerocount++;
                }else{
                    zerocount++;
                    break;
                }
            }else{
                product*=nums[i];
            }
        }
        int[] res=new int[nums.length];
        if(zerocount==2){
            return res;
        }else if(zerocount==1){
            res[zeropos]=(int)product;
            return res;
        }else{
            for(int i=0;i<nums.length;i++){
                res[i]=(int) product/nums[i];
            }
        }
        return res;
    }
}
