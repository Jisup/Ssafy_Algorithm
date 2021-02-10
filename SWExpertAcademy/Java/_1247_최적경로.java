import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class xy_1247 {
	int y;
	int x;
	xy_1247(int x, int y) {
		this.y=y;
		this.x=x;
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
public class _1247_최적경로 {
	static final int MAX = 11;
	static int N;
	static int result;
	static xy_1247 company, home;
	static ArrayList<xy_1247>customer = new ArrayList<xy_1247>();
	
	static int v[];
	static boolean visit[] = new boolean[MAX];
	
	static void init() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++) {
			N = Integer.parseInt(br.readLine());
			v = new int[N];
			
			customer.clear();
			result = Integer.MAX_VALUE;
			Arrays.fill(v, 0);
			Arrays.fill(visit, false);
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			company = new xy_1247(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new xy_1247(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for(int i=0;i<N;i++)
				customer.add(new xy_1247(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));			
			
			solve(0);
			System.out.println("#"+t+" "+result);
		}
	}
	static void solve(int cnt) {
		if (cnt == N) {
			int ret = calc();
			result = result < ret ? result : ret;
			return;
		}
		for(int i=0;i<N;i++) {
			if (!visit[i]) {
				visit[i] = true;
				v[cnt] = i;
				solve(cnt+1);
				visit[i] = false;
			}
		}
	}
	static int calc() {
		int sum = 0;
		int y = company.getY();
		int x = company.getX();
		for(int i=0;i<N;i++) {
			xy_1247 item = customer.get(v[i]);
			int ny = item.getY();
			int nx = item.getX();
			sum += Math.abs(ny-y)+Math.abs(nx-x);
			y = ny;
			x = nx;
		}
		sum+= Math.abs(home.getY()-y)+Math.abs(home.getX()-x);
		return sum;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		init();
	}
}
