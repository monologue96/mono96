package Baekjoon_Algorithm;
import java.util.*;

public class BJA4673 {
	
	public static int dNum(int value) {		// ���� value�� ���� d(n) �Լ� ����
			
		int sum = 0;	// ���� value�� ���� d(n)���� ������ ����
		sum += value;	// �켱 �ڱ� �ڽ��� ���Ѵ�.
		
		for (int i=0 ; value!=0 ; i++) {
			sum += (value % 10);
			value /= 10;
		}
		/* �� for ���� ������ �� �ڸ����� ���ϴ� �˰����� ���ԵǾ� �ִ�.
		 *  value�� 10���� ������ ���ٰ� ���� 0�� �Ǳ� ������ value%10 ��(�� �ڸ��� ��) �� sum�� ���Ѵ�.
		 */		
		
		return sum;	// d(n)���� ��ȯ�Ѵ�.
	}
	
	public static void main(String[] args) {
		
		int[] dNum_array = new int[10000];	// �����ڰ� �ִ� ���� ������ �迭
		
		for (int i=0 ; i<=9999 ; i++) {		// d(1)~d(10000)�� ���� �迭�� ����
			dNum_array[i] = dNum(i);
		}
		
		Arrays.sort(dNum_array);	//dNum_array �迭�� �������� ����
		
		int[] array = new int[10001];	//0���� 10000���� ������ �迭 array ����
		for(int i=0 ; i<array.length ; i++) {
			array[i] = i;
		}	//0���� 10000�� �迭�� ���� 
		
		/*
		 * �Ʒ� �˰����� ������ ������ ����.
		 * array�� 0���� 10000���� ������ ���� dNum_array�� ��� �ε��� ������ ���Ͽ�
		 * ��ġ�ϴ� ���� ������ stack ���� 1��ŭ ������Ų��.
		 * �� �������� ����ϰ��� �ϴ� ���� 0���� 10000���� �� �� �����ڰ� ����, �� dNum_array�� ��ġ�ϴ� ���� ���� �����̴�.
		 * ���� stack �� 0 �� i������ ����ϸ� �� ���̴�.
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
