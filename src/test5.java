import java.util.Arrays;
import java.util.Scanner;

/*
 * 保龄球
 * */
public class test5 {
	
	public static int flag[] =new int[10];//判断状态： 0： 2次没中10；， 1 ：补中 ；2：第一次全中
	public static int[] finScore =new int[10];//每轮分数
	public static int[][] eachScore = new int[10][3];//每次分数，最后一次若有3次另外算
	/*
	 * 记录每轮的得分
	 * */
	public static void getScore(int firstSore,int secondSore,int count ){
		if(firstSore!=10){
			eachScore[count][0] = firstSore;
			if(10-firstSore>secondSore){
				flag[count]=0;
				eachScore[count][1]=secondSore;
				finScore[count] =firstSore+secondSore;
				System.out.println("本轮为"+(count+1)+"轮，2次都没全中哦~"+"本轮成绩为"+finScore[count]);
			}else if(10-firstSore==secondSore){
				flag[count]=1;
				eachScore[count][1]=secondSore;
				finScore[count]=10;
				System.out.println("本轮为"+(count+1)+"轮，补中。"+"本轮成绩暂时为"+finScore[count]+",等下一轮补分");
			}
		}else{
			flag[count]=2;
			eachScore[count][0]=10;
			eachScore[count][1]=0;
			finScore[count]=10;
			System.out.println("本轮为"+(count+1)+"全中。"+"本轮成绩暂时为"+finScore[count]+",等下一轮补分");
		}
	}
	/*
	 * 补分方法
	 * 全中，补2次
	 * 补中，补一次
	 * flag 判断类型
	 * count 补哪一轮的分
	 * */
	public static void supPonit(int flag,int count){
		if(flag==1){
			finScore[count]+=eachScore[count+1][0];
		}else if(flag==2){
			if(eachScore[count+1][0]!=10){
				finScore[count]+=eachScore[count+1][0]+eachScore[count+1][1];
			}else if(count!=8)
				finScore[count]+=eachScore[count+1][0]+eachScore[count+2][0];
			else
				finScore[count]+=eachScore[count+1][0]+eachScore[count+1][1];
		}
	}
	public static void listFinScore(){
		for(int i=0;i<10;i++){
			System.out.println("第"+(i+1)+"轮得分为"+finScore[i]+"。详细为"+eachScore[i][0]+","+eachScore[i][1]+","+eachScore[i][2]);
		}
	}
	
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		String iString =sc.next();
		String iStrings[] = new String[iString.length()]; 
		int iInt []  = new int[iString.length()];
		for(int i=0;i<iString.length();i++){
			iStrings[i] =String.valueOf(iString.charAt(i));
			if(iStrings[i].equals("X"))
				iStrings[i]="10";
			if(iStrings[i].equals("/")){
				iStrings[i] =10-Integer.parseInt(iStrings[i-1])+"";
			}
			if(iStrings[i].equals("-"))
				iStrings[i] ="0";
			iInt [i] = Integer.parseInt(iStrings[i]);
		}
		
		int count =0;
		for(int i=0;i<iInt.length;i++){
				if(count<9){
					if(iInt[i]==10){
						getScore(10,0,count);
						iInt[i]=-1;
					}
					else{
						getScore(iInt[2*i],iInt[2*i+1],count);
						iInt[2*i]=-1;
						iInt[2*i+1]=-1;
					}
					count++;
					continue;
				}
				
				if(iInt[i]!=-1){
					//10次
					if(iInt[i]==10){
						eachScore[9][0]=10;
						eachScore[9][1]=iInt[i+1];
						eachScore[9][2]=iInt[i+2];
						finScore[9] =10+iInt[i+1]+iInt[i+2];
						break;
					}else if(iInt[i]+iInt[i+1]==10){
						eachScore[9][0]=iInt[i];
						eachScore[9][1]=iInt[i+1];
						eachScore[9][2]=iInt[i+2];
						finScore[9] =iInt[i]+iInt[i+1]+iInt[i+2];
						break;
					}else{
						eachScore[9][0]=iInt[i];
						eachScore[9][1]=iInt[i+1];
						finScore[9]=iInt[i]+iInt[i+1];
						break;
					}
				}
			}
		
		
		/*for(String s :iStrings)
			System.out.println(s);*/
		for(int i=0;i<10;i++){
			System.out.print(i+1+":  ");
			for(int j=0;j<3;j++)
				System.out.print(eachScore[i][j]+" ");
			System.out.println();
		}
		
		for(int j=0;j<9;j++){
			supPonit(flag[j],j);
		}
		int re =0;
		for(int j=0;j<10;j++){
			re+=finScore[j];
		}
		listFinScore();
		System.out.println(re);
	}
	
}
