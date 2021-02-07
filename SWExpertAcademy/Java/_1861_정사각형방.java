import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class pair {
	int idx;
	int cnt;

	pair(int idx, int cnt) {
		this.idx = idx;
		this.cnt = cnt;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}

class xy_1861 {
	int y;
	int x;

	xy_1861(int y, int x) {
		this.y = y;
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
}

class cost extends xy_1861 {
	int cnt;

	cost(int y, int x, int cnt) {
		super(y, x);
		this.cnt = cnt;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}

public class _1861_정사각형방 {
	static final int MAX = 1001;
	static int H;

	static int ay[] = { -1, 1, 0, 0 };
	static int ax[] = { 0, 0, -1, 1 };

	static int map[][] = new int[MAX][MAX];
	static boolean visit[][] = new boolean[MAX][MAX];
	static xy_1861 index[];
	static pair result;

	static void init() throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			H = sc.nextInt();
			index = new xy_1861[H * H + 1];

			for (int i = 0; i < H; i++)
				for (int j = 0; j < H; j++) {
					map[i][j] = sc.nextInt();
					index[map[i][j]] = new xy_1861(i, j);
				}

			for (boolean item[] : visit)
				Arrays.fill(item, false);
			
			result = new pair(H * H + 1, 0);

			for (int i = H * H; i > 0; i--) {
				int y = index[i].getY();
				int x = index[i].getX();
				if (!visit[y][x]) {
					solve(y, x);
				}
			}
			System.out.println("#"+t+" "+result.getIdx()+" "+result.getCnt());
		}
	}

	static void solve(int st_y, int st_x) {
		Queue<cost> q = new LinkedList<cost>();
		q.add(new cost(st_y, st_x, 1)); // 자기자신을 포함한다?
		visit[st_y][st_x] = true;

		while (!q.isEmpty()) {
			cost out = q.poll();
			int y = out.getY();
			int x = out.getX();
			int cnt = out.getCnt();

			int flag = 0;
			for (int i = 0; i < 4; i++) {
				int ny = y + ay[i];
				int nx = x + ax[i];
				if (!range(ny, nx) && map[y][x] - map[ny][nx] == 1) {
					visit[y][x] = true;
					q.add(new cost(ny, nx, cnt + 1));
					break;
				}
				flag++;
			}
			if (flag == 4) {	// q.isEmpty()로도 확인가능 (경로가 남아있다면 무조건 1개가 들어가기때문에)
				if (result.getCnt() < cnt) {
					result = new pair(map[y][x], cnt);
				} else if (result.getCnt() == cnt) {
					if (result.getIdx() > map[y][x])
						result.setIdx(map[y][x]);
				}
			}
		}
	}

	static boolean range(int y, int x) {
		return y < 0 || x < 0 || y > H - 1 || x > H - 1 || visit[y][x];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		// 문제를 못푼이유!! ::
		// 1) 배열 0,0~x,x까지 순차적으로 진행하려했음 -> 결론 시간초과
		// 2) 순차적으로진행하면서 dp를 치려했음 -> 어찌됐건 시간초과
		// 3) 역순으로진행하고자함 :: 이유
		//		역순으로진행할시, 연결된다면 낮은순번호까지 갈테고, 최대치범위또한 알 수 있음
		//		방문한곳에대해서 재방문을 하지 않아도됨
		init();
	}
}
