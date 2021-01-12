package algospot;

import java.util.Scanner;

public class QUADTREE {
	static String str;
	static int pointer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		for (int tc = 0; tc < C; tc++) {
			str = sc.next();
			pointer = 0;
			System.out.println(reverse());
		}
	}

	private static String reverse() {
		if (str.charAt(pointer) != 'x') {
			return "" + str.charAt(pointer++);
		}
		pointer++;
		String one = reverse();
		String two = reverse();
		String three = reverse();
		String four = reverse();
		return 'x' + three + four + one + two;
	}
}