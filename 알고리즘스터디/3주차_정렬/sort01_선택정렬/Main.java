package sort01_선택정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int[] arr;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		selectionsort();
		for (int x : arr) {
			bw.write(x + "\n");
		}
		bw.flush();
		bw.close();
	}
	static void selectionsort() {
		int index = 0;
		for(int i=0;i<n;i++) {
			int min = Integer.MAX_VALUE;
			for(int j=i;j<n;j++) {
				if(min>arr[j]) {
					min=arr[j];
					index = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;
		}
	}
}
