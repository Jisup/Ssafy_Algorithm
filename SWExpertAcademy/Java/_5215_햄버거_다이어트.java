import java.util.Scanner;

class Data_5215 {
	int sf;
	int cal;
	Data_5215(int sf, int cal) {
		this.sf=sf;
		this.cal=cal;
	}
}
public class _5215_햄버거_다이어트 {
	static final int MAX = 21;
	static int N, max_cal;
	static Data_5215 food[] = new Data_5215[MAX];
	
	static void init() {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			N = sc.nextInt();
			max_cal = sc.nextInt();
			
			for(int i=0;i<N;i++)
				food[i] = new Data_5215(sc.nextInt(), sc.nextInt());
			
			System.out.print("#"+t+" ");
			solve(1<<N);
		}
	}
	static void solve(int idx) {
		int result=0;
		for(int index=0;index<idx;index++) {
			int sum_sf=0;
			int sum_cal=0;
			for(int i=0;i<N;i++) {
				int value = 1<<i;
//				System.out.println(value+" "+index+" "+(index&value));
				 if ((index & value) != 0) {
					sum_sf += food[i].sf;
					sum_cal += food[i].cal;
				 }
			}
			if (sum_cal > max_cal) continue;
			result = result > sum_sf ? result:sum_sf;
		}
		System.out.println(result);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
	}
}