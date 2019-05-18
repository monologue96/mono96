package Baekjoon_Algorithm;
import java.util.*;

public class BJA1152 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int blank_num = 0;
		String str = input.nextLine();
		
		if (str.length()<=1000000) {
			for(int i=0 ; i<str.length() ; i++) {
				if(str.charAt(i) == 32) {
					blank_num ++;
				}
			}
			
			if(str.charAt(0) == 32)
				blank_num--;
			
			if(str.charAt(str.length()-1) == 32)
				blank_num--;
		}
				
		System.out.println(blank_num+1);
	}
}
