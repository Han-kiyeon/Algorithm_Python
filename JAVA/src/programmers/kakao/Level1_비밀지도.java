package programmers.kakao;

import java.util.Arrays;

class Level1_비밀지도 {
	public static void main(String[] args) {
		String[] ans = solution(5, new int[] { 9, 20, 28, 18, 11 }, new int[] { 30, 1, 2, 1, 17, 28 });
		System.out.println(Arrays.toString(ans)); // "#####","# # #", "### #", "# ##", "#####"
		ans = solution(6, new int[] { 46, 33, 33, 22, 31, 50 }, new int[] { 27, 56, 19, 14, 14, 10 });
		System.out.println(Arrays.toString(ans)); // "######", "### #", "## ##", " #### ", " #####", "### # "
	}

	static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] result = new String[n];
		for (int i = 0; i < n; i++) {
			result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
		}

		for (int i = 0; i < n; i++) {
			result[i] = String.format("%" + n + "s", result[i]);
			result[i] = result[i].replaceAll("1", "#");
			result[i] = result[i].replaceAll("0", " ");
		}

		return result;
	}
}