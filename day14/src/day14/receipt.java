package day14;

import java.util.Scanner;

class Buger {
	String name = "";
	int[] price = { 2500, 3800, 1500, 1000 };
	String[] menu = { "ġ�����", "�������", "����Ƣ��", "��ī�ݶ�" };
	int[] cnt = new int[4];
	int total = 0;
}

public class receipt {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Buger bg = new Buger();

		bg.name = "������ġ";
		System.out.println("      " + bg.name);
		System.out.println("------------------");
		while (true) {
			System.out.println("      �޴�����");
			for (int i = 0; i < 4; i++) {
				System.out.println((i + 1) + ". " + bg.menu[i] + "--" + bg.price[i] + "��");
			}
			System.out.println("0. ������ ���");
			int slt = sc.nextInt();
			if (slt == 0) {
				System.out.println("------------------");
				System.out.println("ITEM   QTY   AMT");
				for (int i = 0; i < 4; i++) {
					System.out.println(bg.menu[i] + "   " +bg.cnt[i]+"   "+ bg.price[i]);
				}
				System.out.println("------------------");
				System.out.println("�հ�ݾ�        "+bg.total);
				System.out.print("�����ݾ�        ");
				int money=sc.nextInt();
				System.out.println("------------------");
				System.out.println("��   ��        "+(money-bg.total));
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
