import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class xy {
	int y;
	int x;
	int dir;
	xy(int y, int x, int dir) {
		this.y=y;
		this.x=x;
		this.dir=dir;
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
	public int getDir() {
		return dir;
	}
	public void setDir(int dir) {
		this.dir = dir;
	}
}
public class _1873_상호의_배틀필드 {
	static final int MAX = 21;
	static int H, W;
	static int cml;		// CommandLine
	static String cmand;// Command
	
	static int ay[] = {-1,1,0,0};	//상 하 좌 우
	static int ax[] = {0,0,-1,1};
	static char tv[] = {'^', 'v', '<', '>'};
	static char map[][];
//	static boolean visit[][] = new boolean[MAX][MAX];
	
	static void init() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;t++) {
			String b[] = br.readLine().split(" ");
			H = Integer.parseInt(b[0]);
			W = Integer.parseInt(b[1]);
			map = new char[H][W];
			xy start = null;
			for(int i=0;i<H;i++) {
				map[i] = br.readLine().toCharArray();
				for(int j=0;j<W;j++) {
					if (map[i][j] == '>') {
						start = new xy(i,j,3);
					}
					else if(map[i][j] == '^') {
						start = new xy(i,j,0);
					}
					else if(map[i][j] == 'v') {
						start = new xy(i,j,1);
					}
					else if(map[i][j] == '<') {
						start = new xy(i,j,2);
					}
				}
			}
			cml = Integer.parseInt(br.readLine());
			cmand = br.readLine();
			System.out.print("#"+t+" ");
			solve(start);
		}
	}
	static void solve(xy tank) {
		if (tank==null) return;
		
		for(int i=0;i<cml;i++) {
			char type = cmand.charAt(i);
			switch(type) {
			case 'U':
				tank.setDir(0);
				move(tank);
				break;
			case 'D':
				tank.setDir(1);
				move(tank);
				break;
			case 'L':
				tank.setDir(2);
				move(tank);
				break;
			case 'R':
				tank.setDir(3);
				move(tank);
				break;
			case 'S':
				shoot(tank);
				break;
			}
		}
		view();
	}
	static void move(xy tank) {
		int dir = tank.getDir();
		int y = tank.getY();
		int x = tank.getX();
		int ny = y+ay[dir];
		int nx = x+ax[dir];
		map[y][x] = tv[dir];
		if (!range(ny, nx) && map[ny][nx] == '.') {
			tank.setY(ny);
			tank.setX(nx);
			map[y][x] = '.';
			map[ny][nx] = tv[dir];
		}
	}
	static void shoot(xy tank) {
		int dir = tank.getDir();
		int y = tank.getY();
		int x = tank.getX();
		while(true) {
			y+=ay[dir];
			x+=ax[dir];
			//맨첨에 런타임에러, 포탄이밖으로나갈경우 먼저 생각해줘야했는데 안함
			if (range(y, x) || map[y][x] == '#') break;
			if (map[y][x] == '*') {
				map[y][x] = '.';
				break;
			}
		}
	}
	static boolean range(int y, int x) {
		return y<0||x<0||y>H-1||x>W-1;
	}
	static void view() {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		//틀린이유, 테케사이에 빈줄이 없었어야함
		System.out.print(sb);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		init();
	}
}
