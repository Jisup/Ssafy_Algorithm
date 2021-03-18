import java.util.Scanner;

public class _3298_서로소집합 {
	static int N;
	static int parents[];
	
	static void make() {
		for(int i=0;i<N;i++)
			parents[i]=i;
	}
	static int findSet(int value) {
		 if(parents[value] == value) return value;
		 return parents[value] = findSet(parents[value]);
	}
	static boolean unionSet(int fs, int se) {
		int fs_root = findSet(fs);
		int se_root = findSet(se);
		if (fs_root == se_root) return false;
		parents[se_root] = fs_root;
		return true;
	}
	static void init() {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			N = sc.nextInt();
			parents = new int[N+1];
			make();
			StringBuffer sb = new StringBuffer();
			int M = sc.nextInt();
			for(int i=0;i<M;i++) {
				int type = sc.nextInt();
				int fs = sc.nextInt();
				int se = sc.nextInt();
				if(type == 1) 
					sb.append(findSet(fs) == findSet(se) ? 1 : 0);
				else 
					unionSet(fs, se);
			}
			System.out.println("#"+t+" "+sb);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
	}

}
