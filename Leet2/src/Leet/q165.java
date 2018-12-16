package Leet;



public class q165 {
	public int compareVersion(String version1, String version2) {
		String[] ver1=version1.split("\\."),ver2=version2.split("\\.");
		int i=0;
		while(i<Math.min(ver1.length, ver2.length)) {
			if(Integer.valueOf(ver1[i])<Integer.valueOf(ver2[i])) {
				return -1;
			}else if(Integer.valueOf(ver1[i])>Integer.valueOf(ver2[i])) {
				return 1;
			}
			i++;
		}
		if(ver1.length>ver2.length) {
			while(i<ver1.length) {
				if(Integer.valueOf(ver1[i])>0) {
					return 1;
				}
				i++;
			}
		}else if(ver1.length<ver2.length) {
			while(i<ver2.length) {
				if(Integer.valueOf(ver2[i])>0) {
					return -1;
				}
				i++;
			}
		}else {
			return 0;
		}
		return 0;
    }
}
