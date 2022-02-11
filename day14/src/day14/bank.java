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
			System.out.println("계좌번호\t비밀번호\t계좌잔액");
			System.out.println("----------------------");
			System.out.println(a.name);
			System.out.println("----------------------");
			try {
				System.out.println("상태: " + a.acc[a.nc] + " 로그인");
			} catch (Exception e) {
				System.out.println("상태: 로그아웃");
			}
			System.out.println("----------------------");
			System.out.println("[NH Bank]");
			System.out.println(
					"[1] 회원가입\n[2] 회원탈퇴\n[3] 로그인\n[4] 로그아웃\n[5] " + "입금하기\n[6] 이체하기\n[7] 잔액조회\n[0] 종료하기\n메뉴 선택 : ");
			int slt = sc.nextInt();

			if (slt == 0) { // 종료
				System.out.println("종료합니다.");
				break;
			} else if ((slt == 1) && (a.nc == -1)) {// 가입
				while (true) {
					System.out.println("[가입] 계좌 번호를 입력하세요");
					String uAcc = sc.next();
					for (int i = 0; i < a.acc.length; i++) {
						if (uAcc.equals(a.acc[i])) {
							System.out.println("이미 가입된 계좌입니다.");
							break;
						} else if (i == a.acc.length - 1) {
							a.cnt += 1;
							System.out.println("[가입] 비밀 번호를 입력하세요");
							String uPw = sc.next();
							System.out.println("[가입] 금액 입력하세요");
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
			} else if ((slt == 2) && (a.nc != -1)) {// 탈퇴
				while (true) {
					System.out.println("[탈퇴] 계좌 번호를 입력하세요");
					String uAcc = sc.next();
					System.out.println("[탈퇴] 비밀 번호를 입력하세요");
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
						System.out.println("다시 입력하여 주시길 바랍니다.");

					}
				}
			} else if ((slt == 3) && (a.nc == -1)) {// 로그인
				while (true) {
					System.out.println("[로그인] 계좌 번호를 입력하세요");
					String uAcc = sc.next();
					System.out.println("[로그인] 비밀 번호를 입력하세요");
					String uPw = sc.next();
					for (int i = 0; i < a.cnt; i++) {
						if (uAcc.equals(a.acc[i])) {
							a.nc = i;
						}
					}
					try {
						if (uPw.equals(a.pw[a.nc])) {
							System.out.println("로그인 되었습니다.");
							break;
						} else {
							System.out.println("아이디 혹은 비밀번호가 맞지 않습니다.");
						}
					} catch (Exception e) {
						System.out.println("아이디 혹은 비밀번호가 맞지 않습니다.");
					}
				}
			} else if ((slt == 4) && (a.nc != -1)) {// 로그아웃
				while (true) {
					System.out.println("[로그아웃] 비밀 번호를 입력하세요");
					String uPw = sc.next();
					if (uPw.equals(a.pw[a.nc])) {
						System.out.println("로그아웃합니다.");
						a.nc = -1;
						break;
					} else {
						System.out.println("비밀번호가 맞지 않습니다.");
					}
				}
			} else if ((slt == 5) && (a.nc != -1)) {// 입금
				while (true) {
					System.out.println("[입금] 비밀 번호를 입력하세요");
					String uPw = sc.next();
					if (uPw.equals(a.pw[a.nc])) {
						System.out.print("금액 입력: ");
						int inm = sc.nextInt();
						a.money[a.nc] += inm;
						System.out.println("입금이 완료되었습니다.");
						break;
					} else {
						System.out.println("비밀번호가 맞지 않습니다.");
					}
				}
			} else if ((slt == 6) && (a.nc != -1)) {// 이체
				while (true) {
					System.out.println("[이체] 비밀 번호를 입력하세요");
					String uPw = sc.next();
					if (uPw.equals(a.pw[a.nc])) {
						System.out.print("받는 사람 계좌: ");
						String sent = sc.next();
						int s = -1;
						for (int i = 0; i < a.cnt; i++) {
							if (sent.equals(a.acc[i])) {
								s = i;
							}
						}
						if (s == -1) {
							System.out.println("존재하지 않는 계좌입니다.");
						} else {
							System.out.println("금액 입력: ");
							int inm = sc.nextInt();
							if (inm <= a.money[a.nc]) {
								a.money[s] += inm;
								a.money[a.nc] -= inm;
								System.out.println("이체가 완료되었습니다.");
								break;
							} else {
								System.out.println("잔액 부족");
							}
						}
					}
				}
			} else if ((slt == 7) && (a.nc != -1)) {// 잔액조회
				while (true) {
					System.out.println("[입금] 비밀 번호를 입력하세요");
					String uPw = sc.next();
					if (uPw.equals(a.pw[a.nc])) {
						System.out.println(a.acc[a.nc]+"님의 잔액은 "+a.money[a.nc]+"원입니다.");
						break;
					} else {
						System.out.println("비밀번호가 맞지 않습니다.");
					}
				}
			} else if (a.nc != -1) {
				System.out.println("로그아웃 후 이용하여 주시길 바랍니다.");

			} else {
				System.out.println("로그인 후 이용하여 주시길 바랍니다.");
			}
		}
	}
}
