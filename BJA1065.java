package Baekjoon_Algorithm;
import java.util.*;

public class BJA1065 {
	
	public static int[] splitNum(int value) {		
		// ���� value���� �� �ڸ��� ���� �迭�� �����Ͽ� �� �迭�� �ּҰ��� ��ȯ�ϴ� �Լ�
		
		int[] splited_num_array = new int[Integer.toString(value).length()];
		// �� �ڸ� ���� ������ �迭 ����. ũ��� ���ڿ��� ��ȯ�� value�� ���̸�ŭ.
		
		for (int i=0 ; value!=0 ; i++) {
			splited_num_array[i] = (value % 10);
			value /= 10;
		}
		/* ������ �� �ڸ����� ���ϴ� �˰����̴�. value�� 10���� ������ ���ٰ� ���� 0�� �Ǳ� ������ value%10 ���� �迭�� �����Ѵ�.
		 * ���� ��� value = 645 ��� �迭�� [5,4,6] ó�� �Ųٷ� ������ �ǰ�����,
		 * �Ʒ� main�Լ����� ������������ �Ǻ��ϴ� �˰����� �����ϴ� ������ ������ ����.
		 */
		
		return splited_num_array;	// �迭�� �ּҰ��� ��ȯ�Ѵ�.
	}
	
	public static void main(String[] args) {
		int hansoo = 0;		// �Ѽ��� ������ ��Ÿ���� ����
		Scanner input = new Scanner(System.in);
		
		int input_num = input.nextInt();
				
		if(1 <= input_num && input_num < 100) {
			System.out.println(input_num);		// 1�̻� 100 ������ ���� �Ѽ��� ������ �ڱ� �ڽŰ� ����.
		}else if(input_num >= 100) {			// 100�̻��� ���� ���� �Ѽ��� ������ ���ϴ� �˰���.
			boolean is_hansoo = false;			// �������������� ��Ÿ���� boolean ����
			int i = 100;
			while (i <= input_num) {			// 100 �̻��̰� �ڱ� �ڽź��� ũ�ų� ���� ��� ���� ���Ͽ� �Ʒ� �˰����� �����Ѵ�.
				int[] splited_num_array = splitNum(i);		// �켱 splitNum �Լ��� ����Ͽ� �� �ڸ��� ���� ����� �迭�� �ּҰ��� �޴´�.
				
				/*
				 * �Ʒ����ʹ� ������������ Ȯ���ϴ� �˰����̴�.
				 * ������, 13579 ��� ���� ���������̸� 1,3 ��° �ڸ��� ���� ���� 2��° �ڸ��� ���� 2�� �� �Ͱ� ����, (and)
				 * 2,4 ��° �ڸ� ���� ���� 3��° �ڸ� ���� 2�� �� �Ͱ� ������,(and) 3,5��° �ڸ� ���� ���� 4��° �ڸ� ���� 2���� �Ͱ� ���ƾ� �Ѵ�.
				 */
				
				for (int j=0 ; j<splited_num_array.length - 2 ; j++) {
					if (splited_num_array[j] + splited_num_array[j+2] == 2 * splited_num_array[j+1]) {
						is_hansoo = true;	// j, j+2 ��° �ڸ� ���� ���� j+1��° �ڸ� ���� 2���� �Ͱ� ���ٸ� is_hansoo �� true�� �����.
					}else {
						is_hansoo = false;
						break;				
						// Ȯ�� �������� ���������� �������� �ʴ� �� �ڸ��� ������ �ִٸ� is_hansoo�� false�� ����� for���� Ż���Ѵ�.
						// ������ �ڸ��� Ȯ���� �͵� ���� �� ������ ���������� �������� �����ϱ�.
					}
				}
				
				if (is_hansoo == true)
					hansoo++;		// for���� ��� ���鼭  ���������� ���������� �������� Ȯ�εǾ��ٸ� �� ���� �Ѽ���.
				
				
				i++;	// ���� ���� ���Ͽ� while���� �ݺ��Ѵ�.
			}
			
			System.out.println(hansoo+99);	
			// input_num�� 100 �̻��� ������� �˰����� ���� ���� 100�̻��� �Ѽ��� ������ 100 �̸��� �Ѽ� ������ ���ؾ� �Ѵ�.
			// ���� ��� 111�� �Ѽ��� ������ 99 + 1�� (111) = 100�� �̴�.
		}
		BJA1065.main(args);
	}
}
