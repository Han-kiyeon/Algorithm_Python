package programmers.kakao;

import java.util.ArrayList;

class Level2_문자열압축 {
	public static void main(String[] args) {
		System.out.println(solution("aabbaccc"));// 7
		System.out.println(solution("ababcdcdababcdcd"));// 9
		System.out.println(solution("abcabcdede"));// 8
		System.out.println(solution("abcabcabcabcdededededede"));// 14
		System.out.println(solution("xababcdcdababcdcd"));// 17
	}

	public static int solution(String s) {
		int n = s.length() >> 1;
		int answer = s.length();
		for (int k = 1; k <= n; k++) { // k: 비교 길이
			ArrayList<String> list = new ArrayList();
			for (int i = 0; i < s.length(); i += k) {
				list.add(i + k < s.length() ? s.substring(i, i + k) : s.substring(i, s.length()));
			}

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < list.size(); i++) {
				int count = 1;
				while (true) {
					if (i + 1 < list.size() && list.get(i).equals(list.get(i + 1))) {
						count++;
						i++;
					} else {
						break;
					}
				}
				sb.append(count == 1 ? list.get(i) : count + list.get(i));
			}
			answer = Math.min(answer, sb.toString().length());
		}

		return answer;
	}
}