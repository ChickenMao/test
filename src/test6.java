/*
 * 冒泡排序
 * */
public class test6 {
	public static void maopao(int []a){
		int temp;
		int size = a.length;
		
		for(int i=1;i<size;i++){
			for(int j=0;j<size-i;j++){
				if(a[j]>a[j+1]){
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] =temp;
				}
			}
		}
		
	}
	public static void main(String[] args){
		int a[] = new int[]{1,9,8,5,2,0,13,10};
		maopao(a);
		for(int as:a)
			System.out.println(as);
	}
		
}
