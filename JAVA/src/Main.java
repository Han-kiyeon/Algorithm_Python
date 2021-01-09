import java.util.Scanner;

public class Main {
	static int INF = Integer.MAX_VALUE >> 1, SWITCH = 10, CLOCK = 16;
	static int[][] switches = { { 0, 1, 2 }, { 3, 7, 9, 11 }, { 4, 10, 14, 15 }, { 0, 4, 5, 6, 7 }, { 6, 7, 8, 10, 12 },
			{ 0, 2, 14, 15 }, { 3, 14, 15 }, { 4, 5, 7, 14, 15 }, { 1, 2, 3, 4, 5 }, { 3, 4, 5, 9, 13 } };
	static int[] clocks;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		for (int tc = 0; tc < C; tc++) {
			clocks = new int[CLOCK];
			for (int clock = 0; clock < CLOCK; clock++)
				clocks[clock] = (sc.nextInt() / 3) % 4;

			int ret = solve(0);
			System.out.println(ret != INF ? ret : -1);
		}
	}

	private static boolean check() {
		for (int i : clocks)
			if (i != 0)
				return false;
		return true;
	}

	private static void push(int depth) {
		for (int i : switches[depth]) {
			clocks[i]++;
			clocks[i] %= 4;
		}
	}

	private static int solve(int depth) {
		if (depth == SWITCH) {
			return check() ? 0 : INF;
		}

		int ret = INF;
		for (int cnt = 0; cnt < 4; cnt++) {
			ret = Math.min(ret, cnt + solve(depth + 1));
			push(depth);
		}
		return ret;
	}
}