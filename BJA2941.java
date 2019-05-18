package Baekjoon_Algorithm;
import java.util.*;

public class BJA2941 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String str = input.next();
		int len = str.length();
		
		int cro = 0;
		
		if(len<=100) {
			for (int i=0 ; i<len-1 ; i++) {
				if(str.charAt(i)=='c' && (str.charAt(i+1)=='=' || str.charAt(i+1)=='-')){
					cro++;
					i++;
					continue;	
					/* i번째 인덱스에 대한 for문을 실행하는 도중 크로아티아 알파벳임을 확인하면
					 * i+1번째 인덱스에 대해선 for문을 실행할 필요가 없다. 이미 i번째 인덱스와 함께 하나의 알파벳이라고 쳤으니까.
					 * 그 이유 때문에 i++; continue; 문을 쓴 것이다.
					 */
				}
				
				if(str.charAt(i)=='d' && str.charAt(i+1)=='z' && str.charAt(i+2)=='='){
					cro+=2;		
					// 'dz=' 이 하나의 알파벳이므로 길이가 2 감소한다. 이는 크로아티아 알파벳이 2개 있는 것과 같다.
					i++;
					continue;
				}
					
				
				if((str.charAt(i)=='l' || str.charAt(i)=='n') && str.charAt(i+1)=='j'){
					cro++;
					i++;
					continue;
				}
				
				if(str.charAt(i)=='d' && str.charAt(i+1)=='-'){
					cro++;
					i++;
					continue;
				}
				
				if((str.charAt(i)=='s' || str.charAt(i)=='z') && str.charAt(i+1)=='='){
					cro++;
					i++;
					continue;
				}
			}
			System.out.println(len-cro);
		}

	}
}

