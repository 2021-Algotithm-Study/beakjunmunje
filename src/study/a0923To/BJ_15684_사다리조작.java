package study.a0923To;

import java.io.*;
import java.util.*;
//https://leveloper.tistory.com/96 참고
public class BJ_15684_사다리조작 {
		static int N, M, H, result;
		static int[][] arr;
		static boolean finish = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr= new int[H+1][N+1]; //?
		
		int row, col;
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			arr[row][col] = 1;
			arr[row][col+1] = 2;//??
		}
		for(int i = 0; i<= 3; i++) {
			result = i;
			dfs(1, 0);
			if(finish) break;
		}
		
		System.out.println((finish) ? result : -1);
		br.close();
	}
	private static void dfs(int start, int cnt) { //조합
		if(finish) return;
		if(result == cnt) {
			if(check()) finish = true;
			return;
		}
		for(int i = start; i<H+1;i++) {
			for(int j = 0; j<N; j++) {
				if(arr[i][j] == 0 && arr[i][j+1] == 0) {
					arr[i][j] = 1;
					arr[i][j+1] = 2;
					dfs(i, cnt + 1);
					arr[i][j] = arr[i][j+1] = 0;
 				}
			}
		}
	}
	private static boolean check() {
		for(int i = 1; i<=N; i++) {
			int row =1, col = i;
			for(int j = 0; j<H; j++) {
				if(arr[row][col] == 1) col++;
				else if(arr[row][col] == 2) col--;
				row++;
			}
			if(col != i) return false;
		}
		return true;
	}

}
