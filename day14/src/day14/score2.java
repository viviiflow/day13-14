package day14;

import java.util.Scanner;

class School {
	String name = "";
	int[] ids = { 1001, 1002, 1003, 1004, 1005 };
	int[] scores = { 92, 38, 87, 100, 11 };
}

public class score2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		School mega = new School();
		mega.name = "�л����� ���� ���α׷�";
		while (true) {
			System.out.println("=== " + mega.name + " ===");
			System.out.println("1. ������ ����Ȯ��");
			System.out.println("2. 1���л� ����Ȯ��");
			System.out.println("3. �õ��л� ����Ȯ��");
			System.out.println("4. ����Ȯ���ϱ�");
			System.out.println("5. �����ϱ�");
			int slt = sc.nextInt();

			if (slt == 1) {
				for (int i = 0; i < mega.ids.length; i++) {
					System.out.println(mega.ids[i] + "�й�: " + mega.scores[i] + "��");
				}
			}
			if (slt == 2) {
				int max = 0, idx = 0;
				for (int i = 0; i < mega.scores.length; i++) {
					if (max < mega.scores[i]) {
						max = mega.scores[i];
						idx = i;
					}
				}
				System.out.println("1��: " + max + "��(" + mega.ids[idx] + "�й�)");
			}
			if (slt == 3) {
				int min = 1000, idx = 0;
				for (int i = 0; i < mega.scores.length; i++) {
					if (min > mega.scores[i]) {
						min = mega.scores[i];
						idx = i;
					}
				}
				System.out.println("�õ�: " + min + "��(" + mega.ids[idx] + "�й�)");
			}
			if (slt == 4) {
				System.out.println("�й� �Է�: ");
				int num = sc.nextInt();
				try {
					System.out.println(mega.scores[num - 1001] + "��");
				} catch (Exception e) {
					System.out.println("�������� �ʽ��ϴ�.");
				}
			}
			if (slt == 5) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}
		}
	}
}
