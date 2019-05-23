import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
/*
 * 密文
 * */
public class test2 {
	private static void  move(String x[] ,int n){
		n%=x.length;
		while (n>0){
			String temp = x[0];
		    for(int i = 0;i<x.length-1;i++){
		    	x[i] = x[i+1]; 
		    }
			x[x.length-1] = temp;
		n--;
		}
	}
	public static void main(String args[] ){
		String A9[] = new String[]{"A","B","C","D","E","F","G","H","I"};
		String J9[] = new String[]{"J","K","L","M","N","O","P","Q","R"};
		String S9[] = new String[]{"S","T","U","V","W","X","Y","Z","*"};
		String main[] = new String[]{"A9","J9","S9"};
		
		Scanner sc = new Scanner(System.in);
		String date = sc.nextLine();
		String content = sc.nextLine();
		char[] contentArray = content.toCharArray();
        //把空格换位*
         for (int i = 0; i < contentArray.length; i++) {
            if (contentArray[i] == ' ') {
                contentArray[i] = '*';
            }
        }
		int mon = Integer.parseInt(date.split("\\s+")[0]);
		int day = Integer.parseInt(date.split("\\s+")[1]);
		
		/*先根据月份数m，以整个分组为单位进行循环左移，移动(m-1)次。
		然后根据日期数d，对每个分组内的字符进行循环左移，移动(d-1)次*/
		int m =mon-1;
		int d =day-1;
	
		move(main,m);
		int falgA = 0;
		int falgJ = 0;
		int falgS = 0;
		for(int i=0;i<3;i++){
			if(main[i].contains("A"))
				falgA =i+1;
			if(main[i].contains("J"))
				falgJ =i+1;
			if(main[i].contains("S"))
				falgS =i+1;
		}
		//System.out.println(falgA+","+falgJ+","+falgS);
		move(A9,d);
		move(J9,d);
		move(S9,d);
		/*for(String x:A9)
			System.out.println(x);
		for(String x:J9)
			System.out.println(x);
		for(String x:S9)
			System.out.println(x);*/
		
		String str = "";
	        for (int i = 0; i < contentArray.length; i++) {
	        	for (int j = 0; j < 9; j++) {
	        		if(String.valueOf( contentArray[i]).equals(A9[j]))
	        			str+=falgA+""+(j+1)+" ";
	        		if(String.valueOf( contentArray[i]).equals(J9[j]))
	        			str+=falgJ+""+(j+1)+" ";;
	        		if(String.valueOf( contentArray[i]).equals(S9[j]))
	        			str+=falgS+""+(j+1)+" ";;
	        	}
	        	
	        	
	        }
		System.out.println(str);
		
		
	
	
	}
	
}

