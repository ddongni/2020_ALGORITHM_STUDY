package week08_04_이진트리_13325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int nodes = (int) Math.pow(2, k) - 1;
		long[][] arr = new long[nodes][2];
		int[][] arr_node = new int[nodes][2];
		int index = 1;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < nodes; i++) {
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr_node[i][0] = index++;
			arr_node[i][1] = index++;

		}
		long[] sum = new long[(int) Math.pow(2, k + 1) - 1];
		for (int i = k; i > 0; i--) {
			int min = (int) Math.pow(2, i - 1) - 1;
			int max = (int) Math.pow(2, i) - 1;
			for (int j = min; j < max; j++) {
				long left = sum[arr_node[j][0]] + arr[j][0];
				long right = sum[arr_node[j][1]] + arr[j][1];

				if (left >= right) { // 둘 중 큰 수로 바꿔주기
					arr[j][1] += left - right;
					sum[j] = left; //큰 수 저장
				} else {
					arr[j][0] += right - left;
					sum[j] = right;
				}
			}
		}
		long answer = 0;
		for (int i = 0; i < nodes; i++) {
			answer += arr[i][0];
			answer += arr[i][1];
		}
		System.out.println(answer);
	}
}