package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15591_MooTube_silver {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		List<int[]>[] adj = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++)
			adj[i] = new ArrayList<>();

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			adj[p].add(new int[] { q, r });
			adj[q].add(new int[] { p, r });
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			boolean[] visit = new boolean[N + 1];
			visit[v] = true;
			Queue<Integer> que = new LinkedList<>();
			que.add(v);

			int ans = 0;
			while (!que.isEmpty()) {
				int cur = que.poll();

				for (int[] a : adj[cur]) {
					if (!visit[a[0]] && a[1] >= k) {
						que.add(a[0]);
						visit[a[0]] = true;
						ans++;
					}
				}
			}
			sb.append(ans).append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}