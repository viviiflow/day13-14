package day14;

import java.util.Scanner;

class ATM {
	String name = "";
	String[] acc = { "1111", "2222", "3333", "4444", "5555" };
	String[] pw = { "1234", "2345", "3456", "4567", "5678" };
	int[] money = { 87000, 34000, 17500, 98000, 12500 };
	int cnt = 5;
	int nc = 2;
}

public class bank {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ATM a = new ATM();
		while (true) {
			a.name = "";
			for (int i = 0; i < a.cnt; i++) {
				a.name += a.acc[i] + "\t" + a.pw[i] + "\t" + a.money[i] + "\n";
			}
			a.name = a.name.substring(0, a.name.length() - 1);
			System.out.println("----------------------");
			System.out.println("���¹�ȣ\t��й�ȣ\t�����ܾ�");
			System.out.println("----------------------");
			System.out.println(a.name);
			System.out.println("----------------------");
			try {
				System.out.println("����: " + a.acc[a.nc] + " �α���");
			} catch (Exception e) {
				System.out.println("����: �α׾ƿ�");
			}
			System.out.println("----------------------");
			System.out.println("[NH Bank]");
			System.out.println(
					"[1] ȸ������\n[2] ȸ��Ż��\n[3] �α���\n[4] �α׾ƿ�\n[5] " + "�Ա��ϱ�\n[6] ��ü�ϱ�\n[7] �ܾ���ȸ\n[0] �����ϱ�\n�޴� ���� : ");
			int slt = sc.nextInt();

			if (slt == 0) { // ����
				System.out.println("�����մϴ�.");
				break;
			} else if ((slt == 1) && (a.nc == -1)) {// ����
				while (true) {
					System.out.println("[����] ���� ��ȣ�� �Է��ϼ���");
					String uAcc = sc.next();
					for (int i = 0; i < a.acc.length; i++) {
						if (uAcc.equals(a.acc[i])) {
							System.out.println("�̹� ���Ե� �����Դϴ�.");
							break;
						} else if (i == a.acc.length - 1) {
							a.cnt += 1;
							System.out.println("[����] ��� ��ȣ�� �Է��ϼ���");
							String uPw = sc.next();
							System.out.println("[����] �ݾ� �Է��ϼ���");
							int uMoney = sc.nextInt();
							String[] ta = new String[a.cnt];
							String[] tp = new String[a.cnt];
							int[] tm = new int[a.cnt];
							for (int j = 0; j < a.acc.length; j++) {
								ta[j] = a.acc[j];
								tp[j] = a.pw[j];
								tm[j] = a.money[j];
							}
							ta[a.cnt - 1] = uAcc;
							tp[a.cnt - 1] = uPw;
							tm[a.cnt - 1] = uMoney;
							a.acc = new String[a.cnt];
							a.pw = new String[a.cnt];
							a.money = new int[a.cnt];
							for (int j = 0; j < a.cnt; j++) {
								a.acc[j] = ta[j];
								a.pw[j] = tp[j];
								a.money[j] = tm[j];
							}
							a.name += "\n" + a.acc[a.cnt - 1] + "\t" + a.pw[a.cnt - 1] + "\t" + a.money[a.cnt - 1];
							break;
						}
					}
					break;
				}
			} else if ((slt == 2) && (a.nc != -1)) {// Ż��
				while (true) {
					System.out.println("[Ż��] ���� ��ȣ�� �Է��ϼ���");
					String uAcc = sc.next();
					System.out.println("[Ż��] ��� ��ȣ�� �Է��ϼ���");
					String uPw = sc.next();
					if ((uAcc.equals(a.acc[a.nc])) && (uPw.equals(a.pw[a.nc]))) {
						a.cnt -= 1;
						String[] ta = new String[a.cnt];
						String[] tp = new String[a.cnt];
						int[] tm = new int[a.cnt];
						for (int i = 0; i < a.cnt; i++) {
							if (i >= a.nc) {
								ta[i] = a.acc[i + 1];
								tp[i] = a.pw[i + 1];
								tm[i] = a.money[i + 1];
							} else {
								ta[i] = a.acc[i];
								tp[i] = a.pw[i];
								tm[i] = a.money[i];
							}
						}
						a.acc = new String[a.cnt];
						a.pw = new String[a.cnt];
						a.money = new int[a.cnt];

						for (int i = 0; i < a.cnt; i++) {
							a.acc[i] = ta[i];
							a.pw[i] = tp[i];
							a.money[i] = tm[i];
						}
						a.nc = -1;
						break;
					} else {
						System.out.println("�ٽ� �Է��Ͽ� �ֽñ� �ٶ��ϴ�.");

					}
				}
			} else if ((slt == 3) && (a.nc == -1)) {// �α���
				while (true) {
					System.out.println("[�α���] ���� ��ȣ�� �Է��ϼ���");
					String uAcc = sc.next();
					System.out.println("[�α���] ��� ��ȣ�� �Է��ϼ���");
					String uPw = sc.next();
					for (int i = 0; i < a.cnt; i++) {
						if (uAcc.equals(a.acc[i])) {
							a.nc = i;
						}
					}
					try {
						if (uPw.equals(a.pw[a.nc])) {
							System.out.println("�α��� �Ǿ����ϴ�.");
							break;
						} else {
							System.out.println("���̵� Ȥ�� ��й�ȣ�� ���� �ʽ��ϴ�.");
						}
					} catch (Exception e) {
						System.out.println("���̵� Ȥ�� ��й�ȣ�� ���� �ʽ��ϴ�.");
					}
				}
			} else if ((slt == 4) && (a.nc != -1)) {// �α׾ƿ�
				while (true) {
					System.out.println("[�α׾ƿ�] ��� ��ȣ�� �Է��ϼ���");
					String uPw = sc.next();
					if (uPw.equals(a.pw[a.nc])) {
						System.out.println("�α׾ƿ��մϴ�.");
						a.nc = -1;
						break;
					} else {
						System.out.println("��й�ȣ�� ���� �ʽ��ϴ�.");
					}
				}
			} else if ((slt == 5) && (a.nc != -1)) {// �Ա�
				while (true) {
					System.out.println("[�Ա�] ��� ��ȣ�� �Է��ϼ���");
					String uPw = sc.next();
					if (uPw.equals(a.pw[a.nc])) {
						System.out.print("�ݾ� �Է�: ");
						int inm = sc.nextInt();
						a.money[a.nc] += inm;
						System.out.println("�Ա��� �Ϸ�Ǿ����ϴ�.");
						break;
					} else {
						System.out.println("��й�ȣ�� ���� �ʽ��ϴ�.");
					}
				}
			} else if ((slt == 6) && (a.nc != -1)) {// ��ü
				while (true) {
					System.out.println("[��ü] ��� ��ȣ�� �Է��ϼ���");
					String uPw = sc.next();
					if (uPw.equals(a.pw[a.nc])) {
						System.out.print("�޴� ��� ����: ");
						String sent = sc.next();
						int s = -1;
						for (int i = 0; i < a.cnt; i++) {
							if (sent.equals(a.acc[i])) {
								s = i;
							}
						}
						if (s == -1) {
							System.out.println("�������� �ʴ� �����Դϴ�.");
						} else {
							System.out.println("�ݾ� �Է�: ");
							int inm = sc.nextInt();
							if (inm <= a.money[a.nc]) {
								a.money[s] += inm;
								a.money[a.nc] -= inm;
								System.out.println("��ü�� �Ϸ�Ǿ����ϴ�.");
								break;
							} else {
								System.out.println("�ܾ� ����");
							}
						}
					}
				}
			} else if ((slt == 7) && (a.nc != -1)) {// �ܾ���ȸ
				while (true) {
					System.out.println("[�Ա�] ��� ��ȣ�� �Է��ϼ���");
					String uPw = sc.next();
					if (uPw.equals(a.pw[a.nc])) {
						System.out.println(a.acc[a.nc]+"���� �ܾ��� "+a.money[a.nc]+"���Դϴ�.");
						break;
					} else {
						System.out.println("��й�ȣ�� ���� �ʽ��ϴ�.");
					}
				}
			} else if (a.nc != -1) {
				System.out.println("�α׾ƿ� �� �̿��Ͽ� �ֽñ� �ٶ��ϴ�.");

			} else {
				System.out.println("�α��� �� �̿��Ͽ� �ֽñ� �ٶ��ϴ�.");
			}
		}
	}
}
