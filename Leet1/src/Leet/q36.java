package Leet;
/*
 * 根据题目的要求，board一定是9*9的char;
 * 维护三个数组，一个为行，一个为列，一个为小盒子；数组a[i]=N，表示数字i+1出现了N次，判断如果N>1，则返回false；
 * num3的序号需要特别注意，容易出错。
 * 判断是否为-3是区别‘.’和其他非数字字符。
 */
public class q36 {
	public boolean isValidSudoku(char[][] board) {
		for(int i=0;i<9;i++) {
			int[] rows=new int[9],cols=new int[9],boxes=new int[9];	
			for(int j=0;j<9;j++) {
				int num1=Integer.valueOf(board[i][j])-Integer.valueOf('1');
				int num2=Integer.valueOf(board[j][i])-Integer.valueOf('1');
				int num3=Integer.valueOf(board[i/3*3+j/3][(i%3)*3+j%3])-Integer.valueOf('1');
				if(num1>=0&&num1<=8){
                    rows[num1]++;
                }else if(num1!=-3){
                    return false;
                }
                if(num2>=0&&num2<=8){
                    cols[num2]++;
                }else if(num2!=-3){
                    return false;
                }
                if(num3>=0&&num3<=8){
                    boxes[num3]++;
                }else if(num3!=-3){
                    return false;
                }
			}
			if(!isvalid(rows)||!isvalid(cols)||!isvalid(boxes)) {
				return false;
			}
		}
		return true;
    }
	boolean isvalid(int[] nums) {
		for (int i=0;i<nums.length;i++) {
			if(nums[i]>1) {
				return false;
			}
		}
		return true;
	}
}
