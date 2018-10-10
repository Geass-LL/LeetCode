package Leet;

/*
 * 不愧是Hard级别的问题；有两点收获：
 * 1、说采用constant extra space，可以试想用原有数组的space，这个想法没出现过；
 * 2、桶排序中，在添桶的时候，要使用while，直到将当前位置的值换为无效值（超出范围的值）
 * 	  或属于它的值（桶应存放的如a[i]=i+1）为止
 * 注意：这个条件nums[i]!=nums[nums[i]-1]（待交换的数据在桶内已经存在了，即多个数据同时出现）
 * 		乍一看好像可以去掉，但是去掉会引起相同数据死循环。
 * http://www.cnblogs.com/AnnieKim/archive/2013/04/21/3034631.html
 * 参考网址
 */
public class q41 {
	public int firstMissingPositive(int[] nums) {
		int i=0;
		while(i<nums.length) {
			if(nums[i]<=nums.length&&nums[i]>0&&nums[i]!=i+1&&nums[i]!=nums[nums[i]-1]) {
				int temp=nums[nums[i]-1];
				nums[nums[i]-1]=nums[i];
				nums[i]=temp;
			}else {
				i++;
			}
		}
		for(i=0;i<nums.length;i++) {
			if(nums[i]!=i+1)
				return i+1;
		}
		return nums.length+1;
    }
}
