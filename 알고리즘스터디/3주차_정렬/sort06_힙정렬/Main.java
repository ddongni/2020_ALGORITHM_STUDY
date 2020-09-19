package sort06_힙정렬;

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
		heapsort();
		for (int x : arr) {
			bw.write(x + "\n");
		}
		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close();
	}

	static void heapsort() {
		// 최대 힙 만들기
		for (int i = 1; i < n; i++) {
			int child = i;
			while (child != 0) {
				int root = (child - 1) / 2;
				if (arr[root] < arr[child]) {
					int temp = arr[root];
					arr[root] = arr[child];
					arr[child] = temp;
				}
				child = root;
			}
		}
		// root를 맨 뒤로 보내고, 이를 제외한 다른 노드들로 다시 힙 구성. 그리고 이를 반복
		for (int i = n - 1; i >= 0; i--) {
			// root 맨 뒤로 보내기
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			// 최대 힙 만들기
			int root = 0;
			int child = 1;
			while (child < i) {
				child = 2 * root + 1; //왼쪽 자식 (child+1을 하면 오른쪽 자식)
				//자식 중에 더 큰 값 찾기 (오른쪽 자식이 더 크다면 오른쪽 자식으로 인덱스를 맞춰주기 위해 ++)
				if(child<i-1 && arr[child]<arr[child+1]) {
					child++;
				}
				//root보다 자식이 크면 교환
				if(child<i && arr[root]<arr[child]) {
					temp = arr[root];
					arr[root] = arr[child];
					arr[child] = temp;
				}
				root = child;
			}
		}
	}
}
