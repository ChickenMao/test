
class Solution3 {
	public static boolean isPalindrome(int x) {
		int y =x;
		int temp =0;
		if(x<0)
			return false;
		while(x!=0){
			int re = x%10;
			x = x/10;
			temp = temp*10+re;
		}
		if(temp==y)
			return true;
		else
			return false;
    }
    public static void main(String []args){
    	System.out.println(isPalindrome(-121));
    }
}