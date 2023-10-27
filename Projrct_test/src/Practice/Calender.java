package Practice;

import java.util.Scanner;
import java.util.Calendar;
public class Calender {
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		System.out.println("년 월 ");
		int year= scan.nextInt();
		int month =scan.nextInt();
		
		Calendar cal =Calendar.getInstance();
		
		cal.set(Calendar.YEAR,year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DATE, 1);
		
		String strweek[]= {"일","월","화","수","목","금","토"};
		int week = cal.get(Calendar.DAY_OF_WEEK)-1;
		int lastday =cal.getActualMaximum(Calendar.DATE);
		System.out.println(year+"년 "+month+"월");
		for (String string : strweek) {
			System.out.print(string+"\t");
		}
		System.out.println();
		for(int i=1;i<=lastday;i++) {
			if (i==1) {
				for(int j=0;j<week;j++) {
					System.out.print("\t");
				}
			}
			System.out.print(i+"\t");
			week++;
			if (week>6) {
				week=0;
				System.out.println();
			}
		}
		
	}
}
