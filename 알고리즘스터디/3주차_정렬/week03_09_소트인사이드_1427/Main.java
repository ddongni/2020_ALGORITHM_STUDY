package week03_09_소트인사이드_1427;

import java.util.Scanner;

public class Main {
	static int[] arr, sorted;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		arr = new int[str.length()];
		sorted = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i)-'0';
		}
		divide(0, str.length() - 1);
		for (int i = 0; i < str.length(); i++) {
			System.out.print(arr[i]);
		}
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
			if(arr[i] >= arr[j]) {
				sorted[k] = arr[i];
				i++;
			}else if(arr[j] > arr[i]) {
				sorted[k] = arr[j];
				j++;
			}
			k++;
		}
		if(i>mid) {
			for(int t=j;t<=n;t++) {
				sorted[k]=arr[t];
				k++;
			}
		}else {
			for(int t=i;t<=mid;t++) {
				sorted[k]=arr[t];
				k++;
			}
		}
		for(int t=m;t<=n;t++) {
			arr[t] = sorted[t];
		}
	}
}
