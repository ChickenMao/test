import java.util.HashMap;

class Solution {
	public static int lengthOfLongestSubstring(String s) {
		int length =s.length();
        int max =0;
        int del =0;
        HashMap<String,Integer> hash = new HashMap<>();
		for(int i=0;i<length;i++){
			String iStr =String.valueOf(s.charAt(i));
			if(!hash.containsKey(iStr)){
				hash.put(iStr, i);
				if(hash.size()>max){
					max++;
				}
				System.out.println(iStr+"加入，max="+max);
			}else{
				while(hash.containsKey(iStr)){
					hash.remove(String.valueOf(s.charAt(del)));
					del++;
				}
				System.out.println("hash大小为："+hash.size()+".   比max大嘛："+(hash.size()>max));
				if(!hash.containsKey(iStr))
					hash.put(iStr, i);
				if(hash.size()>max){
					max++;
				}
			}
			System.out.println(hash);
		}
		
		return max;
    }
	
	
	
    public static void main(String []args){
    	//String in = "qrsvbspk";
    	//String in = "abcabcbb";
    	//String in = "bbbbb";
    	String in = "pwwkew";
    	System.out.println(lengthOfLongestSubstring(in));
    }
}