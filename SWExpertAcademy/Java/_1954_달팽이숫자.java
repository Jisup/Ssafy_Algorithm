import java.util.Arrays;
import java.util.Scanner;

public class _1954_달팽이숫자 {
	static int N;
	static int ary[][];
	static void init() {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			N = sc.nextInt();
			System.out.println("#"+tc);
			solve();
			view();
		}
	}
	static int ay[] = {0,1,0,-1};
	static int ax[] = {1,0,-1,0};
	static void solve() {
		int cnt=1;
		ary = new int [N][N];
		for(int item[] : ary)
			Arrays.fill(item, 0);
		
		int y=0, x=0, dir=0;
		for(int i=0;i<N*N;i++) {
//			System.out.println(y+" "+x+" "+cnt);
			ary[y][x] = cnt++;
			if (range(y+ay[dir],x+ax[dir])) dir = dir+1>3 ? 0:dir+1;
			y+=ay[dir];
			x+=ax[dir];
		}
	}
	static boolean range(int y, int x) {
		return y<0||x<0||y>N-1||x>N-1||ary[y][x] != 0;
	}
	static void view() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++)
				System.out.print(ary[i][j]+" ");
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
	}
}
