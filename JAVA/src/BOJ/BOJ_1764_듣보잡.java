package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1764_µË∫∏¿‚ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Set<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}

		List<String> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			if (set.contains(name)) {
				list.add(name);
			}
		}

		Collections.sort(list);

		System.out.println(list.size());
		for (String name : list) {
			System.out.println(name);
		}
	}
}