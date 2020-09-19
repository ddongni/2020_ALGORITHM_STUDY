package sort05_퀵정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		quicksort(arr, 0,n-1);
		for (int x : arr) {
			bw.write(x + "\n");
		}
		bw.flush(); //남아있는 데이터를 모두 출력시킴
		bw.close();
	}

	static void quicksort(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		}
		int pivot = start;
		int i = start + 1;
		int j = end;

		while (i <= j) { // 엇갈릴 때까지 반복
			while (i <= end && arr[pivot] >= arr[i]) {
				i++;
			}
			while (j > start && arr[pivot] <= arr[j]) {
				j--;
			}
			if (i > j) { // 엇갈렸을 때 j,pivot 교환
				int temp = arr[j];
				arr[j] = arr[pivot];
				arr[pivot] = temp;

			} else { // 엇갈리지 않았을 때 i,j 교환
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		quicksort(arr, start, j - 1);
		quicksort(arr, j + 1, end);
	}
}
