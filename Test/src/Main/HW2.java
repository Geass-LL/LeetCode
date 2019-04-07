package Main;
import java.util.*;
public class HW2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner sc=new Scanner(System.in);
//		String str=sc.nextLine();
		//String str="SwSE$3454356DD$$#E#eswsxxsssAAWDxxdderfvcRFER65645hbg^^%%^UnbnvccTRChnyvcxcvVCFR";
		String str="a,";
		Map<Character,Integer> map=new HashMap<Character,Integer>();
		for(int i=0;i<str.length();i++) {
			char temp=str.charAt(i);
			if(map.containsKey(temp)) {
				map.put(temp, map.get(temp)+1);
			}else {
				map.put(temp, 1);
			}
		}
		char start1='A',start2='a';
		boolean state=true,notfound=true;
		while(state) {
			String res="";
			boolean flag=false;
			for(int i=0;i<26;i++) {
				char key1=(char)(start1+i),key2=(char)(start2+i);
				if(map.containsKey(key1)&&map.containsKey(key2)&&map.get(key1)>0&&map.get(key2)>0){
					res+=key1;
					res+=key2;
					map.put(key1, map.get(key1)-1);
					map.put(key2, map.get(key2)-1);
					flag=true;
					notfound=false;
				}else if(flag) {
					System.out.println(res);
					break;
				}
			}
			if(notfound) {
				System.out.println("Not Found");
			}
			if(!flag) {
				state=false;
			}
		}
	}
}
