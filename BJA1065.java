package Baekjoon_Algorithm;
import java.util.*;

public class BJA1065 {
	
	public static int[] splitNum(int value) {		
		// 정수 value값의 각 자리의 수를 배열에 저장하여 그 배열의 주소값을 반환하는 함수
		
		int[] splited_num_array = new int[Integer.toString(value).length()];
		// 각 자리 수를 저장할 배열 선언. 크기는 문자열로 변환된 value의 길이만큼.
		
		for (int i=0 ; value!=0 ; i++) {
			splited_num_array[i] = (value % 10);
			value /= 10;
		}
		/* 숫자의 각 자리수를 구하는 알고리즘이다. value가 10으로 나누어 지다가 몫이 0이 되기 전까지 value%10 값을 배열에 저장한다.
		 * 예를 들어 value = 645 라면 배열에 [5,4,6] 처럼 거꾸로 저장이 되겠지만,
		 * 아래 main함수에서 등차수열인지 판별하는 알고리즘을 적용하는 데에는 문제가 없다.
		 */
		
		return splited_num_array;	// 배열의 주소값을 반환한다.
	}
	
	public static void main(String[] args) {
		int hansoo = 0;		// 한수의 개수를 나타내는 변수
		Scanner input = new Scanner(System.in);
		
		int input_num = input.nextInt();
				
		if(1 <= input_num && input_num < 100) {
			System.out.println(input_num);		// 1이상 100 이하의 수의 한수의 개수는 자기 자신과 같다.
		}else if(input_num >= 100) {			// 100이상의 수에 대해 한수의 개수를 구하는 알고리즘.
			boolean is_hansoo = false;			// 등차수열인지를 나타내는 boolean 변수
			int i = 100;
			while (i <= input_num) {			// 100 이상이고 자기 자신보다 크거나 같은 모든 수에 대하여 아래 알고리즘을 적용한다.
				int[] splited_num_array = splitNum(i);		// 우선 splitNum 함수를 사용하여 각 자리의 수가 저장된 배열의 주소값을 받는다.
				
				/*
				 * 아래부터는 등차수열인지 확인하는 알고리즘이다.
				 * 예컨대, 13579 라는 수가 등차수열이면 1,3 번째 자리의 수의 합이 2번째 자리의 수를 2배 한 것과 같고, (and)
				 * 2,4 번째 자리 수의 합이 3번째 자리 수를 2배 한 것과 같으며,(and) 3,5번째 자리 수의 합이 4번째 자리 수를 2배한 것과 같아야 한다.
				 */
				
				for (int j=0 ; j<splited_num_array.length - 2 ; j++) {
					if (splited_num_array[j] + splited_num_array[j+2] == 2 * splited_num_array[j+1]) {
						is_hansoo = true;	// j, j+2 번째 자리 수의 합이 j+1번째 자리 수를 2배한 것과 같다면 is_hansoo 를 true로 만든다.
					}else {
						is_hansoo = false;
						break;				
						// 확인 과정에서 등차중항을 만족하지 않는 세 자리의 수들이 있다면 is_hansoo를 false로 만들고 for문을 탈출한다.
						// 나머지 자리는 확인할 것도 없이 이 정수는 등차수열을 만족하지 않으니까.
					}
				}
				
				if (is_hansoo == true)
					hansoo++;		// for문을 모두 돌면서  최종적으로 등차수열을 만족함이 확인되었다면 그 수는 한수다.
				
				
				i++;	// 다음 수에 대하여 while문을 반복한다.
			}
			
			System.out.println(hansoo+99);	
			// input_num가 100 이상의 수라면위 알고리즘을 통해 얻은 100이상의 한수의 개수에 100 미만의 한수 개수를 더해야 한다.
			// 예를 들어 111의 한수의 개수는 99 + 1개 (111) = 100개 이다.
		}
		BJA1065.main(args);
	}
}
