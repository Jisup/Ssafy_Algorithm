
import java.io.*;
import java.util.*;

public class _5604_구간합 {
	static int f[] = new int[10];
	static long start, end;
	static int init(int index) {
		if (index == 0) return f[0]=0;
		return f[index] = index+init(index-1);
	}
	static Map<Long, Long> key = new HashMap<>();
	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine().trim());
		init(9);
		for (int t = 1; t <= test; t++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			start = Long.parseLong(st.nextToken());
			end = Long.parseLong(st.nextToken());
			System.out.println("#"+t+" "+(fn(end)-fn(start-1)));
		}
	}
	static long fn(long n) {
		if (n<0)return 0;
		if (n/10 == 0) return f[(int) n];
		long v = len(n);
		if (!key.containsKey(n-1-n%v)) {
			key.put(n-1-n%v, fn(n-1-n%v));
		}
		long value = key.get(n-1-n%v);
		return value+g(n, v);
	}
	static long g(long n, long v) {
		if (!key.containsKey(n%v))
			key.put(n%v, fn(n%v));
		long value = key.get(n%v);
		return n/v*(n%v+1)+value;
	}
	static long len(long n) {
		long cnt = 1;
		while(n!=0) {
			n /= 10;
			cnt*=10;
		}
		return cnt/10;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
	}
}