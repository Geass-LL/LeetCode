package Leet;

public class q223 {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int left=Math.max(A, E),right=Math.max(left, Math.min(C, G));
		int bottom=Math.max(B, F),top=Math.max(bottom, Math.min(D, H));
		return (C-A)*(D-B)+(G-E)*(H-F)-(right-left)*(top-bottom);
    }
}
