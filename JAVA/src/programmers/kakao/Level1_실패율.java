package programmers.kakao;

import java.util.Arrays;

class Node implements Comparable<Node> {
	int num;
	double ratio;

	public Node(int num, double ratio) {
		this.num = num;
		this.ratio = ratio;
	}

	@Override
	public int compareTo(Node o) {
		int res = new Double(o.ratio).compareTo(this.ratio);
		return res == 0 ? this.num - o.num : res;
	}

}

class Level1_실패율 {
	public static void main(String[] args) {
		int[] ans = solution(5, new int[] { 2, 1, 2, 6, 2, 4, 3, 3 });
		System.out.println(Arrays.toString(ans)); // 3,4,2,1,5
		ans = solution(4, new int[] { 4, 4, 4, 4, 4 });
		System.out.println(Arrays.toString(ans)); // 4,1,2,3
	}

	static int[] solution(int N, int[] stages) {
		// 카운트
		int[] cnt = new int[N + 1];
		for (int i = 0; i < stages.length; i++) {
			cnt[stages[i] - 1]++;
		}

		// 누적합
		int[] sum = cnt.clone();
		for (int i = N - 1; i >= 0; i--) {
			sum[i] += sum[i + 1];
		}

		// 계산
		Node[] stage = new Node[N];
		for (int i = 0; i < stage.length; i++) {
			stage[i] = new Node(i + 1, sum[i] == 0 ? 0 : cnt[i] / (double) sum[i]);
		}

		// 정렬
		Arrays.sort(stage);

		// 결과
		int[] result = new int[N];
		for (int i = 0; i < stage.length; i++) {
			result[i] = stage[i].num;
		}

		return result;
	}
}