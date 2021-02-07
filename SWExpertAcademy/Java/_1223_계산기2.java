

import java.util.Scanner;
import java.util.Stack;

public class _1223_계산기2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int len = sc.nextInt();
			String temp = sc.next();
			Stack<Integer> s = new Stack<Integer>();
			s.push(Integer.parseInt(temp.charAt(0)+""));
			for (int i = 1; i < len-1; i += 2) {
				if (temp.charAt(i) == '+')
					s.push(Integer.parseInt(temp.charAt(i + 1)+""));
				else
					s.push(s.pop() * Integer.parseInt(temp.charAt(i + 1)+""));
			}
			int result = 0;
			while (!s.isEmpty()) {
				result += s.pop();
			}
			System.out.println("#" + t+" " + result);
		}
	}

}
