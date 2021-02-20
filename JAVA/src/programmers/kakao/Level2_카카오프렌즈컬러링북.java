package programmers.kakao;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Level2_Ä«Ä«¿ÀÇÁ·»ÁîÄÃ·¯¸µºÏ {
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		int[] ans = solution(6, 4, new int[][] { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 },
				{ 0, 0, 0, 3 }, { 0, 0, 0, 3 } });
		System.out.println(Arrays.toString(ans));
	}

	public static int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		boolean[][] visit = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit[i][j] && picture[i][j] != 0) {
					numberOfArea++;

					Queue<int[]> q = new LinkedList<>();
					visit[i][j] = true;
					q.add(new int[] { i, j });
					int count = 1;

					while (!q.isEmpty()) {
						int[] now = q.poll();
						for (int k = 0; k < dr.length; k++) {
							int nr = now[0] + dr[k];
							int nc = now[1] + dc[k];
							if (0 <= nr && nr < m && 0 <= nc && nc < n) {
								if (!visit[nr][nc] && picture[nr][nc] == picture[i][j]) {
									visit[nr][nc] = true;
									count++;
									q.add(new int[] { nr, nc, picture[i][j] });
								}
							}
						}
					}
					maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
				}
			}
		}

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}
}