package day14;

import java.util.Scanner;

class Sr {
	int[] ids = { 1001, 1002, 1003, 1004, 1005 };
	int[] scores = new int[5];
}

public class score {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Sr std = new Sr();
		int sum = 0, cnt = 0;

		while (true) {
			System.out.println("<���� ���� ���α׷�>");
			System.out.println("1. ���� �Է�");
			System.out.println("2. ���� Ȯ��");
			System.out.println("3. ���� ���(�ε���)");
			System.out.println("4. ���� ���(�й�)");
			System.out.println("5. �ε��� ���");
			System.out.println("6. ����");
			int slt = sc.nextInt();

			if (slt == 1) {
				for (int i = 0; i < std.ids.length; i++) {
					System.out.println((i + 1) + "��° �л� ���� �Է�: ");
					std.scores[i] = sc.nextInt();
					sum += std.scores[i];
					if (std.scores[i] >= 60) {
						cnt++;
					}
				}
				System.out.println("���� �Է��� �Ϸ�Ǿ����ϴ�.");
			}
			if (slt == 2) {
				System.out.println("������ ����: " + sum + "/���: " + (sum / std.ids.length));
				int max = 0, idx = 0;
				for (int i = 0; i < std.scores.length; i++) {
					if (max < std.scores[i]) {
						max = std.scores[i];
						idx = i;
					}
				}
				System.out.println("1��: " + max + "��(" + std.ids[idx] + "�й�)");
			}
			if (slt == 3) {
				System.out.println("�ε��� �Է�: ");
				int idx = sc.nextInt();
				if (idx >= std.ids.length) {
					System.out.println("�������� �ʽ��ϴ�.");
				} else {
					System.out.println(std.scores[idx] + "��");
				}
			}
			if (slt == 4) {
				System.out.println("�й� �Է�: ");
				int num = sc.nextInt();
				try {
					System.out.println(std.scores[num - 1001] + "��");
				} catch (Exception e) {
					System.out.println("�������� �ʽ��ϴ�.");
				}
			}
			if (slt == 5) {
				System.out.println("���� �Է�: ");
				int scr = sc.nextInt();
				String data ="�ε���: ";
				for (int i = 0; i < std.ids.length; i++) {
					if (scr == std.scores[i]) {
						data+=i+", ";
					}
				}
				data = data.substring(0, data.length() - 2);
				System.out.println(data);
			}
			if (slt == 6) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}

		}

	}
}
