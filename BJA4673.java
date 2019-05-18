package Baekjoon_Algorithm;
import java.util.*;

public class BJA4673 {
	
	public static int dNum(int value) {		// 정수 value에 대한 d(n) 함수 구현
			
		int sum = 0;	// 정수 value에 대한 d(n)값을 저장할 변수
		sum += value;	// 우선 자기 자신을 더한다.
		
		for (int i=0 ; value!=0 ; i++) {
			sum += (value % 10);
			value /= 10;
		}
		/* 위 for 문은 숫자의 각 자리수를 구하는 알고리즘이 포함되어 있다.
		 *  value가 10으로 나누어 지다가 몫이 0이 되기 전까지 value%10 값(각 자리의 수) 을 sum에 더한다.
		 */		
		
		return sum;	// d(n)값을 반환한다.
	}
	
	public static void main(String[] args) {
		
		int[] dNum_array = new int[10000];	// 생성자가 있는 수를 저장할 배열
		
		for (int i=0 ; i<=9999 ; i++) {		// d(1)~d(10000)의 값을 배열에 저장
			dNum_array[i] = dNum(i);
		}
		
		Arrays.sort(dNum_array);	//dNum_array 배열을 오름차순 정렬
		
		int[] array = new int[10001];	//0에서 10000까지 저장할 배열 array 생성
		for(int i=0 ; i<array.length ; i++) {
			array[i] = i;
		}	//0에서 10000을 배열에 저장 
		
		/*
		 * 아래 알고리즘의 구조는 다음과 같다.
		 * array의 0에서 10000까지 각각에 대해 dNum_array의 모든 인덱스 값들을 비교하여
		 * 일치하는 것이 있으면 stack 값을 1만큼 증가시킨다.
		 * 이 문제에서 출력하고자 하는 값은 0부터 10000까지 수 중 생성자가 없는, 즉 dNum_array와 일치하는 값이 없는 수들이다.
		 * 따라서 stack 이 0 인 i값들을 출력하면 될 것이다.
		 */
		
		for(int i=0 ; i<array.length ; i++) {
			
			int stack = 0;
			
			for(int j=0 ; j<dNum_array.length ; j++) {
				if(array[i] == dNum_array[j])
					stack++;
			}
			
			if(stack == 0)
				System.out.println(i);
		}
		
	}
}
