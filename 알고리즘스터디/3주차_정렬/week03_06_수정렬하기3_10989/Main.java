package week03_06_수정렬하기3_10989;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int[] arr;
	static int[] sorted;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		sorted = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		divide(0, n - 1);
		for (int x : sorted) {
			bw.write(x+"\n");
		}
		bw.flush();
		bw.close();
	}

	static void divide(int m, int n) {
		if (m < n) {
			int mid = (m + n) / 2;
			divide(m, mid);
			divide(mid + 1, n);
			mergesort(m, mid, n);
		}
	}

	static void mergesort(int m, int mid, int n) {
		int i = m;
		int j = mid + 1;
		int k = m;
		while (i <= mid && j <= n) {
			if (arr[i] <= arr[j]) {
				sorted[k] = arr[i];
				i++;
			} else {
				sorted[k] = arr[j];
				j++;
			}
			k++;
		}
		if (i > mid) {
			for (int t = j; t <= n; t++) {
				sorted[k] = arr[t];
				k++;
			}
		} else {
			for (int t = i; t <= mid; t++) {
				sorted[k] = arr[t];
				k++;
			}
		}
		for (int t = m; t <= n; t++) {
			arr[t] = sorted[t];
		}
	}
}
