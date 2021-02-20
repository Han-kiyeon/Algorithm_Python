package programmers.kakao;

class Level1_다트게임 {
	public static void main(String[] args) {
		System.out.println(solution("1S2D*3T"));// 37
		System.out.println(solution("1D2S#10S"));// 9
		System.out.println(solution("1D2S0T"));// 3
		System.out.println(solution("1S*2T*3S"));// 23
		System.out.println(solution("1D#2S*3S"));// 5
		System.out.println(solution("1T2D3D#"));// -23
		System.out.println(solution("1D2S3T*"));// 59
	}

	public static int solution(String dartResult) {
		int[] score = new int[3];
		char[] bonus = new char[3];
		char[] option = new char[3];

		int i = 0;
		for (int k = 0; k < 3; k++) {
			// 각 기회마다 얻을 수 있는 점수는 0~10
			score[k] = dartResult.charAt(i++) - '0';
			if (dartResult.charAt(i) == '0') {
				score[k] = 10;
				i++;
			}

			// 보너스는 SDT 중 하나
			bonus[k] = dartResult.charAt(i++);

			// 옵선은 *이나 # 중 하나이며, 없을 수도 있다.
			if (i < dartResult.length() && (dartResult.charAt(i) == '*' || dartResult.charAt(i) == '#')) {
				option[k] = dartResult.charAt(i++);
			}
		}

		for (int k = 0; k < 3; k++) {
			if (bonus[k] == 'D')
				score[k] = score[k] * score[k];
			else if (bonus[k] == 'T')
				score[k] = score[k] * score[k] * score[k];

			if (option[k] == '*') {
				score[k] *= 2;
				if (k > 0)
					score[k - 1] *= 2;
			} else if (option[k] == '#') {
				score[k] *= -1;
			}
		}
		return score[0] + score[1] + score[2];
	}
}