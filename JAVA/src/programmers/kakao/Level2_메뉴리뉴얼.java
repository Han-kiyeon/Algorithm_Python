package programmers.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Level2_메뉴리뉴얼 {
	static Map<String, Integer> map;
	static int max;

	public static void main(String[] args) {
		System.out.println(Arrays.toString(
				solution(new String[] { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" }, new int[] { 2, 3, 4 })));//
		System.out.println(Arrays.toString(
				solution(new String[] { "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD" }, new int[] { 2, 3, 5 })));//
		System.out.println(Arrays.toString(solution(new String[] { "XYZ", "XWY", "WXA" }, new int[] { 2, 3, 4 })));//
	}

	public static String[] solution(String[] orders, int[] course) {
		ArrayList<String> list = new ArrayList<>();
		for (int c : course) {
			map = new HashMap<>();
			max = 0;
			for (String o : orders) {
				char[] menu = o.toCharArray();
				Arrays.sort(menu);
				combi(menu, c, 0, 0, "");
			}

			if (max >= 2) {
				for (String key : map.keySet()) {
					if (map.get(key) == max)
						list.add(key);
				}
			}
		}

		Collections.sort(list);

		String[] answer = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

	private static void combi(char[] o, int c, int start, int depth, String ret) {
		if (depth == c) {
			if (map.containsKey(ret)) {
				max = Math.max(max, map.get(ret) + 1);
				map.replace(ret, map.get(ret) + 1);
			} else {
				map.put(ret, 1);
			}
			return;
		}
		for (int i = start; i < o.length; i++) {
			combi(o, c, i + 1, depth + 1, ret + o[i]);
		}
	}

}