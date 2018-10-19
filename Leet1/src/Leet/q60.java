package Leet;

/*
 * 代码写的烂的一逼。。。
 */
public class q60 {
	public String getPermutation(int n, int k) {
		int[] nums=new int[n];
		for(int i=0;i<n;i++) {
			nums[i]=i+1;
		}
	    int[] cho=new int[nums.length];
	    int[] res=new int[n];
	    int[] pra=new int[1];
	    btk(res,0,nums,cho,k,pra);
	    String result="";
	    for(int i=0;i<res.length;i++)
	    	result+=Integer.toString(res[i]);
	    return result;
	}
	void btk(int[] tempres, int deep,int[] nums,int[] cho,int k,int[] pra) {
		if(deep==nums.length) {
			pra[0]++;
			if(pra[0]==k)
				return;
		}else {
			deep++;
			for(int i=0;i<cho.length;i++) {
				if(cho[i]==0) {
					tempres[deep-1]=nums[i];
					cho[i]=1;
					btk(tempres,deep,nums,cho,k,pra);
					if(pra[0]<k) {
						cho[i]=0;
						tempres[deep-1]=0;
					}
				}
			}
		}
	}
}
