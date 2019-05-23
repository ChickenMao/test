import java.util.HashMap;

/*给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。*/
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