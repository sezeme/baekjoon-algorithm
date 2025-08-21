import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int max = Integer.MIN_VALUE;
	static int[][] arr;
	static boolean[][] visit;
	static int n;
	static int m;

	// 상하좌우
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visit = new boolean[n][m];

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				visit[i][j] = true;
				calculate(i,j,arr[i][j],1);
				visit[i][j] = false;
			}
		}

		System.out.println(max);
	}

	static void calculate(int row, int col, int sum, int count) {
		if(count == 4) {
			max = Math.max(max, sum);
			return;
		}

		for(int i = 0; i < 4; i++) {
			int curRow = row + dx[i];
			int curCol = col + dy[i];

			if(curRow < 0 || curRow >= n || curCol < 0 || curCol >= m) {
				continue;
			}

			if(!visit[curRow][curCol]) {
				if(count == 2) {
					visit[curRow][curCol] = true;
					calculate(row, col, sum + arr[curRow][curCol], count + 1);
					visit[curRow][curCol] = false;
				}

				visit[curRow][curCol] = true;
				calculate(curRow, curCol, sum + arr[curRow][curCol], count + 1);
				visit[curRow][curCol] = false;
			}
		}
	}
}