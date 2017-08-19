package problem28;
import java.util.Arrays;
/*
 * ������28���ַ���������(�ݹ�)
 * ����һ���ַ�������ӡ���ַ������ַ����������У���������abc�����abc��acb��bac��bca��cab��cba��
 * ˼·����һ���ַ��������������֣���һ���������ĵ�һ���ַ����ڶ�����������ߵ������ַ������������еĹ��̿ɿ�����������һ�������п��ܳ����ڵ�һ��λ�õ��ַ������ѵ�һ���ַ��ͺ���������ַ�������
 * �ڶ����̶���һ���ַ�������������ַ������У���ʱ�԰Ѻ��������ַ��ֳ������������֣�Ȼ��ݹ鴦����ע�Ȿ�⿼����ȥ�ظ����⣬����ͬ����ֻ��ʾһ�Σ��������ڽ�����һ��Ԫ�غͺ�ߵ�Ԫ��ʱ�����ֵ��ȾͲ����������ߺ�����ֵ��֮ǰλ�ó��ֹ���˵����������������Ҳ��������
 * �����Ŀ1������һ������8�����ֵ����飬�ж���û�п��ܰ���8�����ֱַ�ŵ��������8�������ϣ�ʹ����������������Ե����ϵ�4������ĺͶ���ȡ�
 * ˼·���൱���ȵõ�8�����ֵ��������У�Ȼ��ѡ���������������С�
 * �����Ŀ2���˻ʺ����⣬��8x8�Ĺ��������ϰڷ�8���ʺ������������ܴ���ͬһ�С�ͬһ�л�ͬһ�Խ��ߡ��ж����ְڷ���
 * ˼·������8���ʺ����������������ͬһ��ͬһ�У����Կ϶�ÿ��һ���ʺ�ÿ��һ���ʺ�����������һ������Ϊ8��������±��ʾ�кţ���ֵΪ0-7��ʾ�кţ�Ȼ����ȫ���С����һ���������˲�ͬ�в�ͬ�е�Ҫ������ж϶Խ��߼��ɣ�������������ľ���ֵ����������ľ���ֵ��
 */
public class Permutation {
	void permutation(char[] str){
		if(str == null) return ;
		int begin = 0;//��ǰ�������ַ����ֵ���ʼλ��
		permutation(str,begin);
	}
	void permutation(char[] str,int begin){
		if(begin+1 == str.length){//������һ���ַ�������ӡ���һ�Σ�����
			System.out.println(Arrays.toString(str));
		}else{
			for(int i=begin;i<str.length;i++){
				if(notSame(str,begin,i)){//ȥ���жϣ������ǰ�ַ��ͺ�ߵ��ַ�һ�������ߺ���ַ���֮ǰ���ֹ�������������һ���Լ����Լ������⡣
					//1,���ܳ����ڵ�һ��λ�õ��ַ�����������һ���ַ��ͺ�������ַ�����һ�����Լ����Լ�����
					swap(str,begin,i);
					//2,�̶���һ���ַ����ݹ�����������ַ�������
					permutation(str, begin+1);
					//3,�ݹ鴦�����ߵ��ַ��󣬼ǵð�ǰ�߽������ַ��ٻ���������֤��һ��λ�õ��ַ����ظ�
					swap(str,begin,i);
				}
			}
		}
	}
	boolean notSame(char[] str,int begin,int end){
		for(int p = begin;p < end;p++){
			if(str[p] == str[end]){
				return false;
			}
		}
		return true;
	}
	void swap(char[] str,int a,int b){
		char temp = str[a];
		str[a] = str[b];
		str[b] = temp;
	}
	public static void main(String[] args) {
		Permutation test = new Permutation();
		String s = "bbabb";
		test.permutation(s.toCharArray());
	}
}