package programmers.kakao;

import java.awt.Point;

class Level1_키패드누르기 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 }, "right")); // LRLLLRLLRRL
		System.out.println(solution(new int[] { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 }, "left")); // LRLLRRLLLRR
		System.out.println(solution(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }, "right")); // LLRLLRLLRL
	}

	public static String solution(int[] numbers, String hand) {
		Point[] keypad = new Point[10];
		keypad[0] = new Point(3, 1);
		keypad[1] = new Point(0, 0);
		keypad[2] = new Point(0, 1);
		keypad[3] = new Point(0, 2);
		keypad[4] = new Point(1, 0);
		keypad[5] = new Point(1, 1);
		keypad[6] = new Point(1, 2);
		keypad[7] = new Point(2, 0);
		keypad[8] = new Point(2, 1);
		keypad[9] = new Point(2, 2);
		
		Point L = new Point(3, 0);
		Point R = new Point(3, 2);

		StringBuilder sb = new StringBuilder();
		for (int num : numbers) {
			if (num == 1 || num == 4 || num == 7) {
				L.x = keypad[num].x;
				L.y = keypad[num].y;
				sb.append("L");
			} else if (num == 3 || num == 6 || num == 9) {
				R.x = keypad[num].x;
				R.y = keypad[num].y;
				sb.append("R");
			} else {
				int disL = Math.abs(L.x - keypad[num].x) + Math.abs(L.y - keypad[num].y);
				int disR = Math.abs(R.x - keypad[num].x) + Math.abs(R.y - keypad[num].y);
				if (disL == disR) {
					if (hand.equals("right")) {
						R.x = keypad[num].x;
						R.y = keypad[num].y;
						sb.append("R");
					} else {
						L.x = keypad[num].x;
						L.y = keypad[num].y;
						sb.append("L");
					}
				} else {
					if (disR < disL) {
						R.x = keypad[num].x;
						R.y = keypad[num].y;
						sb.append("R");
					} else {
						L.x = keypad[num].x;
						L.y = keypad[num].y;
						sb.append("L");
					}
				}
			}
		}
		return sb.toString();
	}
}