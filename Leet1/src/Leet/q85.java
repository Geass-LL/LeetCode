package Leet;

/*
 * 很有难度。
 * https://www.cnblogs.com/lupx/archive/2015/10/20/leetcode-85.html
 * https://blog.csdn.net/maxiaotiaoti/article/details/62230381
 * l[j] = Math.max(l[j], cur_left);这句代码很难理解。
 */
public class q85 {
	public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null) return 0;

        int m = matrix.length, n = matrix[0].length;
        int[] l = new int[n];
        int[] r = new int[n];
        int[] h = new int[n];
        int result = 0;

        for(int i = 0; i < n; i++){
            l[i] = 0;
            r[i] = n;
            h[i] = 0;
        }
        for(int i = 0; i < m; i++){
            int cur_left = 0, cur_right = n;
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1') h[j] += 1;
                else                    h[j] = 0;
            }
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    l[j] = Math.max(l[j], cur_left);
                }
                else{
                    l[j] = 0;
                    cur_left = j + 1;
                }
            }
            for(int j = n-1; j >= 0; j--){
                if(matrix[i][j] == '1'){
                    r[j] = Math.min(r[j], cur_right);
                }
                else{
                    r[j] = n;
                    cur_right = j;
                }
            }
            for(int j = 0; j < n; j++){
                result = Math.max(result, (r[j] - l[j]) * h[j]);
            }
            System.out.println();
        }
        return result;
    }
}
