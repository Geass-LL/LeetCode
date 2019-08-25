package Main;

public class In2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="vvvlo";
		int[] counts=new int[26];
		for(int i=0;i<s.length();i++) {
			counts[s.charAt(i)-'a']++;
		}
		int mae=-1,i=0;
		String res="";
		for(i=0;i<26;i++) {
			if(counts[i]!=0) {
				if(mae==-1) {
					res+=(char)('a'+i);
					counts[i]--;
					if(counts[i]!=0)	mae=i;
				}else {
					int temp=0;
					while(counts[i]!=0&&counts[mae]!=0) {
						if((temp&1)==0) {
							res+=(char)('a'+i);
							temp++;
							counts[i]--;
						}else {
							res+=(char)('a'+mae);
							temp++;
							counts[mae]--;
						}
					}
					if(counts[i]==0&&counts[mae]==0) {
						mae=-1;
					}else if(counts[mae]==0) {
						res+=(char)('a'+i);
						counts[i]--;
						if(counts[i]!=0)	mae=i;
						else	mae=-1;
					}
				}
			}
		}
		if(mae==-1&&i==26) {
			System.out.println(res);
		}else if(mae!=-1&&counts[mae]==1&&res.charAt(res.length()-1)-'a'!=mae) {
			System.out.println(res+(char)('a'+mae));
		}else {
			System.out.println(-1);
		}
	}

}
