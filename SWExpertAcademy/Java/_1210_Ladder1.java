import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class xy_1210 {
	int y;
	int x;

	xy_1210(int y, int x) {
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

public class _1210_Ladder1 {
	static void init() throws NumberFormatException, IOException {
		int ary[][] = new int[100][100];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int TC = Integer.parseInt(br.readLine());
			for (int i = 0; i < 100; i++) {
//			for(int i=0;i<10;i++) {
				String temp[] = br.readLine().split(" ");
				for (int k = 0; k < temp.length; k++)
					ary[i][k] = Integer.parseInt(temp[k]);
			}
			System.out.print("#"+TC+" ");
			solve(ary);
		}
	}

	static void solve(int ary[][]) {
		ArrayList<Integer> bridge = new ArrayList<Integer>();
		Queue<xy_1210> q = new LinkedList<xy_1210>();
		int nowidx = 0;
		for (int t = 0; t < 100; t++) {
//		for(int t=0;t<10;t++) {
			if (ary[99][t] == 1)
				bridge.add(t);
			if (ary[99][t] == 2) {
				nowidx = bridge.size();
				bridge.add(t);
			}
		}
		q.add(new xy_1210(99, bridge.get(nowidx)));
//		System.out.println(bridge.get(nowidx));
		while (!q.isEmpty()) {
			xy_1210 out = q.poll();
			int y = out.getY();
			int x = out.getX();
//			System.out.println(y + " " + x);
			if (y == 0) {
				System.out.println(x);
				break;
			}
			if (x - 1 > 0 && ary[y][x - 1] == 1) {
				nowidx -= 1;
				x = bridge.get(nowidx);
				q.add(new xy_1210(y - 1, x));
				continue;
			}
			if (x + 1 < 100 && ary[y][x + 1] == 1) {
				nowidx += 1;
				x = bridge.get(nowidx);
				q.add(new xy_1210(y - 1, x));
				continue;
			}

			q.add(new xy_1210(y - 1, x));
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		init();
	}
}