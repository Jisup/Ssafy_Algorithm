import java.util.Arrays;
import java.util.Scanner;

public class _6808_규영이와_인영이의_카드게임 {
	static final int MAX = 9;
	static int win, lose;
	static int Kyu[] = new int[MAX];
	static int In[] = new int[MAX];
	static int ary[] = new int[MAX];

	static boolean card[] = new boolean[19];
	static boolean visit[] = new boolean[MAX];

	static void init() {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			win = 0;
			lose = 0;
			Arrays.fill(card, false);
			Arrays.fill(visit, false);

			for (int i = 0; i < MAX; i++) {
				Kyu[i] = sc.nextInt();
				card[Kyu[i]] = true;
			}

			int index = 0;
			for (int i = 1; i <= 18; i++) {
				if (!card[i])
					In[index++] = i;
			}
			for (int i = 0; i < MAX; i++) {
				visit[i] = true;
				ary[0] = In[i];
				solve(1);
				visit[i] = false;
			}
			System.out.println("#" + t + " " + win + " " + lose);
		}
	}

	static void solve(int cnt) {
		if (cnt == MAX) {
			calc();
			return;
		}
		for (int i = 0; i < MAX; i++) {
			if (!visit[i]) {
				visit[i] = true;
				ary[cnt] = In[i];
				solve(cnt + 1);
				visit[i] = false;
			}
		}
	}

	static void calc() {
		int fs = 0, se = 0;
		for (int i = 0; i < MAX; i++) {
			if (Kyu[i] > ary[i])
				fs += Kyu[i] + ary[i];
			else if (Kyu[i] < ary[i])
				se += Kyu[i] + ary[i];
		}
		if (fs > se)
			win++;
		else if (fs < se)
			lose++;
	}

	public static void main(String[] args) {
		init();
	}
}
