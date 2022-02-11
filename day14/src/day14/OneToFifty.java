package day14;

import java.util.Scanner;
import java.util.Random;

class OTF {
	final int size = 9;
	int[] front = new int[size];
	int[] back = new int[size];
	int cnt = 1;
}

public class OneToFifty {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		OTF of = new OTF();

		for (int i = 0; i < of.size; i++) {
			of.front[i] = ran.nextInt(9) + 1;
			of.back[i] = ran.nextInt(9) + 10;
			for (int j = 0; j < i; j++) {
				if ((of.front[i] == of.front[j]) || (of.back[i] == of.back[j])) {
					i--;
					break;
				}
			}
		}
		while (of.cnt < 19) {
			for (int i = 0; i < of.size; i++) {
				if ((i >= 1) && (i % 3 == 0)) {
					System.out.println();
					System.out.println();
				}
				System.out.print(of.front[i] + "\t");
			}
			System.out.println();
			System.out.print("�ε��� �Է� : ");
			int idx = sc.nextInt();
			System.out.println();
			
			if (of.front[idx] == of.cnt) {
				if (of.cnt < 10) {
					of.front[idx] = of.back[idx];
					of.cnt++;
				} else {
					of.front[idx] = 0;
					of.cnt++;
				}
			}
		}
		System.out.println("���� ��");
	}
}
