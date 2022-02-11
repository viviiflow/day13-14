package day14;

import java.util.Scanner;

class Buger {
	String name = "";
	int[] price = { 2500, 3800, 1500, 1000 };
	String[] menu = { "치즈버거", "새우버거", "감자튀김", "코카콜라" };
	int[] cnt = new int[4];
	int total = 0;
}

public class receipt {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Buger bg = new Buger();

		bg.name = "맘스터치";
		System.out.println("      " + bg.name);
		System.out.println("------------------");
		while (true) {
			System.out.println("      메뉴선택");
			for (int i = 0; i < 4; i++) {
				System.out.println((i + 1) + ". " + bg.menu[i] + "--" + bg.price[i] + "원");
			}
			System.out.println("0. 영수증 출력");
			int slt = sc.nextInt();
			if (slt == 0) {
				System.out.println("------------------");
				System.out.println("ITEM   QTY   AMT");
				for (int i = 0; i < 4; i++) {
					System.out.println(bg.menu[i] + "   " +bg.cnt[i]+"   "+ bg.price[i]);
				}
				System.out.println("------------------");
				System.out.println("합계금액        "+bg.total);
				System.out.print("받은금액        ");
				int money=sc.nextInt();
				System.out.println("------------------");
				System.out.println("잔   돈        "+(money-bg.total));
				break;
			}
			if (slt == 1) {
				bg.cnt[slt-1]+=1;
				bg.total+=bg.price[slt-1];
			}
			if (slt == 2) {
				bg.cnt[slt-1]+=1;
				bg.total+=bg.price[slt-1];
			}
			if (slt == 3) {
				bg.cnt[slt-1]+=1;
				bg.total+=bg.price[slt-1];
			}
			if (slt == 4) {
				bg.cnt[slt-1]+=1;
				bg.total+=bg.price[slt-1];
			}
		}
	}
}
