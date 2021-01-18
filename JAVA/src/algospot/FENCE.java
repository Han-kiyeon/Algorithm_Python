package algospot;

import java.util.Scanner;

public class FENCE {
	static int N;
	static int[] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		for (int tc = 0; tc < C; tc++) {
			N = sc.nextInt();
			map = new int[N];
			for (int i = 0; i < N; i++) {
				map[i] = sc.nextInt();
			}
			System.out.println(solve(0, N - 1));
		}
	}

	private static int solve(int start, int end) {
		if (start == end)
			return map[start];

		int mid = (start + end) >> 1;
		int ret = Math.max(solve(start, mid), solve(mid + 1, end));

		int lo = mid;
		int hi = mid + 1;
		int height = Math.min(map[lo], map[hi]);

		ret = Math.max(ret, height << 1);

		while (start < lo || hi < end) {
			if (hi < end && (lo == start || map[lo - 1] < map[hi + 1])) {
				hi++;
				height = Math.min(height, map[hi]);
			} else {
				lo--;
				height = Math.min(height, map[lo]);
			}
			ret = Math.max(ret, height * (hi - lo + 1));
		}

		return ret;
	}
}