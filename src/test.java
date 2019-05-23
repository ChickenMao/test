import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/*
 * 可使用的固定钱，  最多可买多少物品
 * 
 * */
public class test {

	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in); 
        Scanner sc2 = new Scanner(System.in); 
        String moneyMax = sc1.nextLine();
        String money = sc2.nextLine();
		
        List<Integer> list = new ArrayList();
        String moneys[] = money.split("\\s+");
        for(String m :moneys){
        	int ms = 0;
        	if(m!=null)
        		ms = Integer.parseInt(m);
        	if(ms>0&&ms<=1000)
        		list.add(ms);
        }
        Collections.sort(list);
		int moneyMaxs = Integer.parseInt(moneyMax);
        int sum =0;
        
        for(Integer x: list){
        	if(sum+x>moneyMaxs)
        		break;
        	else
        		sum+=x;
        }
      System.out.println(sum);
	}

}
