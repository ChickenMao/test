package test_5_15;

import java.util.ArrayList;
import java.util.Collections;

/*给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
示例 1：

输入：[-4,-1,0,3,10]
输出：[0,1,9,16,100]
示例 2：

输入：[-7,-3,2,3,11]
输出：[4,9,9,49,121]*/
public class test {
	
	
	 public static int[] sortedSquares(int[] A) {
		 //ArrayList<Integer> list = new ArrayList<Integer>();
	        for(int i=0;i<A.length;i++){
	        	A[i] =A[i]*A[i];
	        	//list.add(A[i]);
	        }
	        //Collections.sort(list);
	        int temp =0;
	        for(int i=1;i<A.length;i++){
	        	for(int j=0;j<A.length-i;j++){
	        		if(A[j]>A[j+1]){
	        			temp =A[j];
	        			A[j] =A[j+1];
	        			A[j+1] =temp;
	        		}
	        	}
	        }
		 	return A;
	    }
	 
	 public static void main(String[] args){
		 int a[] = sortedSquares(new int[]{-4,-1,0,3,10});
		 for(int i:a)
			 System.out.println(i);
	 }
}
