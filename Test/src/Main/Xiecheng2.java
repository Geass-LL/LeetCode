package Main;

import java.util.*;

public class Xiecheng2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		List<Pair> pairs=new ArrayList<Pair>();
		for(int i=0;i<n;i++) {
			pairs.add(new Pair(sc.nextFloat(),sc.nextFloat()));
		}
		Collections.sort(pairs, new Comparator<Pair>() {
			public int compare(Pair p1,Pair p2) {
				return p1.pr>p2.pr?-1:1;
			}
		});
		int ne=0,po=0;
		for(Pair pair:pairs) {
			if(pair.tr==1) {
				po++;
			}else {
				ne++;
			}
		}
		float x=0,y=0,sum=0;
		for(Pair pair:pairs) {
			float vh=pair.pr;
			float tp=0,np=0;
			for(Pair each:pairs) {
				if(each.pr>=vh) {
					if(each.tr==1) {
						tp++;
					}else {
						np++;
					}
				}
			}
			float x1=np/ne,y1=tp/po;
			sum+=(x1-x)*y1;
			x=x1;
		}
		System.out.println(sum);
	}
}
class Pair{
	public float tr;
	public float pr;
	Pair(float intr,float infa) {
		this.tr=intr;
		this.pr=infa;
	}
}
class myc implements Comparator<Pair>{
	public int compare(Pair a,Pair b) {
		return a.pr>b.pr?1:0;
	}
}
