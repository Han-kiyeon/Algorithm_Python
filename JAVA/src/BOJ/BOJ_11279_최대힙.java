package BOJ;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_11279_√÷¥Î»¸ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		for (int i = 0; i < N; i++) {
			int input = sc.nextInt();
			if (input == 0)
				System.out.println(pq.isEmpty() ? 0 : pq.poll());
			else
				pq.add(input);
		}
	}
}