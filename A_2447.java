import java.util.Scanner;
 
public class A_2447 {

    // '*' 혹은 공백이 들어갈 2차원 배열을 선언한다.
	static char[][] starCode;
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
 
		starCode = new char[N][N];
        
        // 재귀함수 시작은 0,0에서 부터 시작한다.
		recur(0, 0, N, false);
 

        // 백준 코드에서는 시간초과 문제로 StringBuilder를 사용한다.
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(starCode[i][j]);
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
 
	static void recur(int x, int y, int N, boolean blank) {
 
		// (0,0)(0,1)(0,2)(1,0) 후 5번째는 반드시 공백이다.
		if (blank) {
			for (int i = x; i < x + N; i++) {
				for (int j = y; j < y + N; j++) {
					starCode[i][j] = ' ';
				}
			}
			return;
		}
 
        /*
		재귀 탈출 조건을 만들어준다.
        3의 제곱으로 입력받은 수를 계속 쪼개서 1이 되는 조건을 만든다.
         */
		if (N == 1) {
			starCode[x][y] = '*';
			return;
		}
 
        /*
            blockSize는 3으로 쪼개면서 1이 될때 까지 반복한다.
            재귀함수가 돌면서 count를 세고, 카운트가 5가 될 때마다 공백을 처리한다.
        */
		int blockSize = N/3;
		int count = 0;
		for (int i = x; i<x+N; i+= blockSize) {
			for (int j = y; j<y+N; j+= blockSize) {
				count++;
				if (count == 5){ 
					recur(i, j, blockSize, true);
				} else {
					recur(i, j, blockSize, false);
				}
			}
		}
	}
}