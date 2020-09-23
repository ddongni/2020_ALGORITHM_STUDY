package sort07_병합정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int[] arr;
	static int n;
	
	static int[] sorted; //정렬된 값 넣어주는 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		sorted = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		divide(0,n-1);
		for (int x : arr) {
			bw.write(x + "\n");
		}
		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close();
	}
	//반으로 분할하기
	static void divide(int m, int n) {
		if(m<n) {
			int mid = (m+n)/2;
			divide(m,mid);
			divide(mid+1,n);
			mergesort(m,mid,n);
		}
	}
	static void mergesort(int m, int mid, int n) {//m:시작점, mid:중간점, n:끝점
		int i =m;
		int j= mid+1;
		int k =m;
		while(i<=mid && j<=n) {
			if(arr[i]<=arr[j]) {//i가 작을 경우 정렬 배열 arr에 넣기
				sorted[k] = arr[i];
				i++;
			}else {//j가 작을 경우
				sorted[k] = arr[j];
				j++;
			}
			k++; //k에 작은 값을 넣었기 때문에 다음 인덱스로 이동
		}
		//남은 데이터 삽입
		if(i>mid) { //i가 먼저 끝났을 때, 정렬 배열 arr에 남은 j값을 넣어줌
			for(int t=j;t<=n;t++) {
				sorted[k] = arr[t];
				k++;
			}
		}else { //j가 먼저 끝났을 때, 정렬 배열 arr에 남은 i값을 넣어줌
			for(int t=i;t<=mid;t++) {
				sorted[k] = arr[t];
				k++;
			}
		}
		//정렬된 배열을 삽입
		for(int t=m;t<=n;t++) {
			arr[t] = sorted[t];
		}
	}
}
