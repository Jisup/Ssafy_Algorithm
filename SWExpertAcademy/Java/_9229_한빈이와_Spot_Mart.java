import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _9229_한빈이와_Spot_Mart {
	static final int MAX = 1001;
	
	static int ea, weight;
	static int snak[] = new int[MAX];
	static boolean visit[] = new boolean[MAX];
	static int result;
	
	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());
		for(int t=1;t<=tc;t++) {
			st = new StringTokenizer(br.readLine());
			ea = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<ea;i++)
				snak[i] = Integer.parseInt(st.nextToken());
			
			result = -1;
			Arrays.fill(visit, false);
			solve(0, 0, 0);
			System.out.println("#"+t+" "+result);
		}
	}
	static void solve(int index, int value, int cnt) {
		if (cnt == 2) {
			if (value <= weight)
				result = result > value ? result:value;
			return;
		}
		for(int i=index;i<ea;i++) {
			if (!visit[i]) {
				visit[i] = true;
				solve(index+1, value+snak[i], cnt+1);
				visit[i] = false;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		init();
	}
}
