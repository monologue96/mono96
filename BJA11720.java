package Baekjoon_Algorithm;
import java.util.*;

public class BJA11720 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int l1_num = input.nextInt();
		
		if(1 <= l1_num && l1_num <= 100) {
			String l2_num = input.next();

			if(l1_num == l2_num.length()) {
				int sum = 0;
				for(int i=0 ; i<l2_num.length() ; i++) {
					sum += (l2_num.charAt(i) - '0');
				}
				
				System.out.println(sum);
			}
		}
		
	}
}
