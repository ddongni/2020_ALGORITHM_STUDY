package sort02_버블정렬;

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
		bubblesort();
		for (int x : arr) {
			bw.write(x + "\n");
		}
		bw.flush();
		bw.close();
	}
	static void bubblesort() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-(i+1);j++) { //가장 큰값이 맨뒤로가면 이를 제외시킨 나머지를 비교하기 위해 j<n-(i+1)
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
}
