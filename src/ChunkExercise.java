/*
 * ChunkExercise.java
 * monologue96
 */

import java.util.*;

class ChunkExercise {
	Scanner input = new Scanner(System.in);
	
	private String[] chunk_array = {"a few","as well", "because of..."};
	private String[] meaning_array = {"��� ����, ����, �ణ", "�Դٰ�, ������", "~������"};
	
	// �ʱ�ȭ�� �޼ҵ�
	public int showMainPage() {
		System.out.println("\n==========================================================");
		System.out.println("| 1. ��ü ���� ����Ʈ  | 2. ���� �߰�  | 3. ���� ����  | 4. �˻�  | 5. ����  | ");
		System.out.println("==========================================================");
		System.out.print("\n �޴� ��ȣ �Է�>> ");
		
		return input.nextInt();
	}
	// ��� �ܾ� ����Ʈ�� ǥ��
	public void getChunkList() {
		for(int i=0; i<chunk_array.length; i++) 
			System.out.println((i+1) + "   " + chunk_array[i] + "\n         " + meaning_array[i] + "\n");
	}
	
	// �ܾ� �߰�
	public void addChunk() {
		System.out.println("���� ������ ���� : " + chunk_array.length);
		System.out.println("�߰��� ������ �Է�>> ");
		String eng = input.nextLine();	// �������
		List<String> c_list = new ArrayList<>(Arrays.asList(chunk_array));
		c_list.add(eng);
		chunk_array = c_list.toArray(new String[c_list.size()]);
		
		System.out.println("�� �Է�>> ");
		String kor = input.nextLine();
		List<String> m_list = new ArrayList<>(Arrays.asList(meaning_array));
		m_list.add(kor);
		meaning_array = m_list.toArray(new String[m_list.size()]);
	}
	
	// �ܾ� ����
	public void removeChunk(String eng, String kor) {
			List<String> w_list = new ArrayList<>(Arrays.asList(chunk_array));
			w_list.remove(eng);
			chunk_array = w_list.toArray(new String[w_list.size()]);
			
			List<String> m_list = new ArrayList<>(Arrays.asList(meaning_array));
			m_list.remove(kor);
			meaning_array = m_list.toArray(new String[m_list.size()]);
		}
		
	// �ܾ� ����
	public void editChunkEng(int index, String eng) {
		chunk_array[index-1] = eng;
	}
	public void editChunkKor(int index, String kor) {
		meaning_array[index-1] = kor;
	}
	
	// �ܾ� ��ȸ
	public void findChunk(String target) {
		for(int i=0 ; i<chunk_array.length ; i++) {
			if(target.equals(chunk_array[i])) {
				System.out.println("\n<���>\n");
				System.out.println((i+1) + "   " + chunk_array[i] + "\n         " + meaning_array[i] + "\n");
			}else continue;
		}
	}
}
