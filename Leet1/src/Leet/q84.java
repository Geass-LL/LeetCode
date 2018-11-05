package Leet;

/*
 * 一次成功，用minheight记录目前为止最短边。
 */
public class q84 {
	public int largestRectangleArea(int[] heights) {
		if(heights.length==0||heights==null)
			return 0;
		int height=heights[0],length=heights.length,maxarea=0,minheight=0;
		for(int i=0;i<length;i++) {
			if(heights[i]<minheight) {
				continue;
			}else {
				height=heights[i];
				for(int j=i;j<length;j++) {
					if(heights[j]>=height) {
						maxarea=(height*(j-i+1)>maxarea)?(height*(j-i+1)):maxarea;
					}else {
						height=heights[j];
						maxarea=(height*(j-i+1)>maxarea)?(height*(j-i+1)):maxarea;
					}
				}
				if(height>minheight)
					minheight=height;
			}
		}
		return maxarea;
    }
}
