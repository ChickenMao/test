
/*给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321
 示例 2:

输入: -123
输出: -321
示例 3:

输入: 120
输出: 21
注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。*/
class Solution2 {
	 public static int reverse(int x) {
		 try{
			 String x2 =String.valueOf(x); 
		     int length =x2.length();
		     int isFu =0;
		     if(String.valueOf(x2.charAt(0)).equals("-")){
	    		 isFu=1;
	    		 length--;
	    	 }
		     String iString [] =  new String[length]; 
		     for(int i=0;i<length;i++){
		    	 if(isFu==1){
		    		 iString[i] =String.valueOf(x2.charAt(i+1));
		    	 }else
		    		 iString[i] =String.valueOf(x2.charAt(i)); 
		    	// System.out.println(iString[i]);
		     }
		     for(int j=0;j<iString.length/2;j++){
		    	 String re = iString[0+j];
		    	 iString[0+j] = iString[iString.length-1-j];
		    	 iString[iString.length-1-j] = re;
		     }
		     String result ="";
		     for(String s:iString){
		    	 if(s!=null&&s!="")
		    	 result+=s;
		     }
		    // System.out.println(result);
		     int result2 = Integer.parseInt(result);
		     if(isFu ==1)
		    	 result2 = -result2;
			 return result2;
		 }catch(Exception e){
			 return 0;
		 }
		
	    }
	 public static int reverse2(int x){
		 
		 
		 return 0;
	 }
	
	
    public static void main(String []args){
    	System.out.println(reverse(-123));
    }
}