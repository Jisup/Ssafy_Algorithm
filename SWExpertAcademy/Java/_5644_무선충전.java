import java.io.*;
import java.util.*;


public class _5644_무선충전 {
	static final int MAX = 11;
	static int M, A, answer;
	static int ay[] = {0,-1,0,1,0};
	static int ax[] = {0,0,1,0,-1};
	
	static class AP implements Comparable<AP>{
		int y, x, range, power, index;
		AP(int y, int x, int range, int power, int index) {
			this.y=y;
			this.x=x;
			this.range=range;
			this.power=power;
			this.index=index;
		}
		@Override
		public int compareTo(_5644_무선충전.AP o) {
			return o.power-this.power;
		}
	}
	static ArrayList<AP>ap = new ArrayList<>();
	
	static int fs_move[] = new int[101];
	static int se_move[] = new int[101];
	static void init() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			
			ap.clear();
			answer = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++)
				fs_move[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++)
				se_move[i] = Integer.parseInt(st.nextToken());
			for(int i=0;i<A;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int range = Integer.parseInt(st.nextToken());
				int power = Integer.parseInt(st.nextToken());
				ap.add(new AP(y, x, range, power, i));
			}
			Collections.sort(ap);
			solve();
			
			System.out.println("#"+t+" "+answer);
		}
	}
	static class xy {
		int y, x;
		xy(int y, int x) {
			this.y=y;
			this.x=x;
		}
	}
	static xy fs, se;
	static void solve() {
		fs = new xy(1,1);
		se = new xy(10,10);
		getBattery();
		for(int i=0;i<M;i++) {
//			System.out.println("type: "+i);
			fs.y += ay[fs_move[i]];
			fs.x += ax[fs_move[i]];
			se.y += ay[se_move[i]];
			se.x += ax[se_move[i]];
			getBattery();
		}
	}
	static void getBattery() {
		//현재 위치에서 접속 가능한 AP에 대해서 탐색을한다
		//fs가 접속가능한 aplist를 순차탐색하며
		//se가 접속가능한 aplist와 대조하여
		//최대값을 찾아낸다, 만약 aplist의 index가 같다면, battery값은 /2가 되고
		//같지안핟면 battery = fs`s ap + se`s ap 가된다
//		System.out.print("fs :"+fs.y+" "+fs.x+"\t"+"se :"+se.y+" "+se.x+" =");
		List<AP>fsap = new LinkedList<>();
		List<AP>seap = new LinkedList<>();
		for(int i=0;i<A;i++) {
			int y = ap.get(i).y;
			int x = ap.get(i).x;
			int range = ap.get(i).range;
			int power = ap.get(i).power;
			if (setBattery(fs.y, fs.x, y, x, range, power))
				fsap.add(ap.get(i));
			if (setBattery(se.y, se.x, y, x, range, power))
				seap.add(ap.get(i));
		}
		int maxbattery = 0;
		if (fsap.size() != 0 && seap.size() == 0) {
			maxbattery = fsap.get(0).power;
		}
		else if (fsap.size() == 0 && seap.size() != 0) {
			maxbattery = seap.get(0).power;
		}
		else if (fsap.size() != 0 && seap.size() != 0) {
			for(AP ap1 : fsap) {
				int highbattery = 0;
				for(AP ap2 : seap) {
					if (ap1.index == ap2.index) {
						highbattery = Math.max(highbattery, ap1.power);
					}
					else {
						highbattery = Math.max(highbattery, ap1.power+ap2.power);
					}
				}
				maxbattery = Math.max(highbattery, maxbattery);
			}
		}
//		System.out.println(maxbattery);
		answer+=maxbattery;
	}
	static boolean setBattery(int py, int px, int y, int x, int range, int power) {
		if (range >= Math.abs(py-y)+Math.abs(px-x))
			return true;
		return false;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		init();
	}
} 