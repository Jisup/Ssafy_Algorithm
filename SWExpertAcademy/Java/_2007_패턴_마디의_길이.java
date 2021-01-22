import java.util.Scanner;

public class _2007_패턴_마디의_길이 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			int len = 0;
			boolean alpha[] = new boolean [125];
			String pattern="";
		
			String input = sc.next();
			for(int i=0;i<input.length();i++) {
				if (!alpha[(int)input.charAt(i)]) {
					alpha[(int)input.charAt(i)] = true;
					pattern+=input.charAt(i);
				}
				else {
					String competition="";
					len = pattern.length();
					for(int k=len;k<len*2;k++)
						competition+=input.charAt(k);
//					System.out.println(pattern+"\t"+competition);
					if (pattern.equals(competition)) {
						break;
					}
					else {
						pattern+=input.charAt(i);
					}
				}
			}
			System.out.println("#"+t+" "+len);
		}
		sc.close();
	}
}
