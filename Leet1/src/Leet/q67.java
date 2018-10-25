package Leet;

public class q67 {
	public String addBinary(String a, String b) {
		if(a.length()==0||a==null) return b;
		if(b.length()==0||b==null) return a;
		String res="";
		int addnum=0;
		int i=0,lengtha=a.length()-1,lengthb=b.length()-1;
		while(lengtha>=i||lengthb>=i) {
			int numa=(lengtha>=i)?(a.charAt(lengtha-i)-'0'):0;
			int numb=(lengthb>=i)?(b.charAt(lengthb-i)-'0'):0;
			int numsum=numa+numb+addnum;
			if(numsum==2) {
				res="0"+res;
				addnum=1;
			}else if(numsum==3) {
				res="1"+res;
				addnum=1;
			}else if(numsum==1) {
				res="1"+res;
				addnum=0;
			}else {
				res="0"+res;
				addnum=0;
			}
			i++;
		}
		if(addnum==1)
			res="1"+res;
		return res;
    }
}
