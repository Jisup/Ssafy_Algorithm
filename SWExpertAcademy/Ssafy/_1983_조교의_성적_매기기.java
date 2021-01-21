import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class student {
	double score;
	int index;

	student(double score, int index) {
		this.score = score;
		this.index = index;
	}
}

public class _1983_조교의_성적_매기기 {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		String result[] = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};

		for (int t = 1; t <= tc; t++) {
			int CLASS = sc.nextInt();
			int semi_class = CLASS/10;
			int index = sc.nextInt()-1;
			
			student st[] = new student[CLASS];
			
			for (int i = 0; i < CLASS; i++) {
				double MID = sc.nextDouble() / 100 * 35;
				double FINAL = sc.nextDouble() / 100 * 45;
				double TASK = sc.nextDouble() / 100 * 20;
				st[i] = new student(MID + FINAL + TASK, i);
			}
			Arrays.sort(st, new Comparator<student>() {
				public int compare(student o1, student o2) {
					return o1.score > o2.score ? -1 : (o1.index >= o2.index ? 0 : 1);
				}
			});
			for(int i=0;i<CLASS;i++) {
				if (st[i].index == index) {
					System.out.println("#"+t+" "+result[i/semi_class]);
					break;
				}
			}
		}
	}
}
