package Leet;
/*
 * ���Ⱪ������ͨ�����ԣ����ǳɼ�5%���ң���ʱ�ܳ���
 * ������̵ĸ��£�ÿ�θ���ʱ�����ݻ���
 * �������������������ݻ����������Ķ̱߾�����
 * ���height[left]>height[right],��ô����ȥ��right�������С�
 * ���裺���㷨��û�б����������������
�������������ʱ��ָ��Ϊp_left��p_right���������裬���ǿ��Լ������ʱ��ָ���ȵ���p_left�����ǵ���ָ��Ϊp_leftʱ����ָ�뻹û�о���p_right��ָ����ƶ���
��֪����ָ��ͣ����p_leftʱ����ֻ�������ֳ����»ᷢ���ı�
1����ָ�����ָ����p_left����������ָ��һ����ǰ��p_left��;�о���p_right��������ì��
2����ָ��λ��p_right�Ҳ��ҵ�ǰ��ֵ������ָ�롣������������£���ʱ������ʢˮ��������������ʢˮ����Ҫ��������ì��
��˸��㷨�ı���һ������������ʢˮ�������
 */
public class q11 {
	public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int resmax=0;
        int res=0;
        while(left<right) {
        	if (height[left]<height[right]) {
        		res=height[left]*(right-left);
        		left++;
        	}else {
        		res=height[right]*(right-left);
        		right--;
        	}
        	if (res>resmax) {
        		resmax=res;
        	}
        }
        return resmax;
    }
}
