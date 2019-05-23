import java.util.ArrayList;
import java.util.List;


/*
 * 
 * 交叉插入
 * */
public class test4 {

	
	public static List<String> changeArry(String first[],String second[]){
		List<String> list = new ArrayList<String>();
		int index=0;
		int a=first.length;
		int b =second.length;
		while(index<first.length&&index<second.length){
			list.add(first[index]);
			list.add(second[index]);
			++index;
		}
		if(index>=first.length){
			for(int i=index;i<b;i++)
				list.add(second[i]);
		}else if (index>=second.length){
			for(int i=index;i<a;i++)
				list.add(first[i]);
		}
		return list;
	}
	
	public static void main(String [] args){
		String []first = new String[]{"a","b","c","d","e","f","g"};
		String []second = new String[]{"A","B"};
		List<String> list = changeArry(first,second);
		String str="";
		for(String s:list)
			str+=s;
		System.out.println(str);
	}


}
