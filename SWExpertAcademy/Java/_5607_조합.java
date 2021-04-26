import java.io.*;
import java.util.*;

public class _5607_조합 {
	static final int MOD = 1234567891, MAX = 1000001;
	static long factorial[] = new long[MAX];
	
	static void init() {
		factorial[0] = 1;
		for(int i=1;i<MAX;i++)
			factorial[i] = (factorial[i-1]*i)%MOD;
	}
	
	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			//nCr % 1234567891
			System.out.println("#"+t+" "+solve(N, R));
		}
	}
	
	static long solve(int N, int R) {
		long top = 1, bottom = 1;
		top = factorial[N];
		bottom = (factorial[N-R]*factorial[R])%MOD;
		bottom = pow(bottom, MOD-2);
		return (top*bottom)%MOD;
	}
	
	static long pow(long value, long index) {
		if (index == 0) return 1;
		//1일때 밑 반환
		else if (index == 1) return value;
		//지수가 짝수면 지수/2값 2배
		if (index%2==0) {
			long temp = pow(value, index/2);
			return (temp*temp)%MOD;
		}
		//지수가 홀수면 지수-1값*value
		else {
			long temp = pow(value, index-1)%MOD;
			return (temp*value)%MOD;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		init();
		input();
	}
}
