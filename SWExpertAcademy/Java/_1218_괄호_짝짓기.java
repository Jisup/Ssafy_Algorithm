
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1218_괄호_짝짓기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int len = Integer.parseInt(br.readLine());
			String temp = br.readLine();
			Stack<String> s = new Stack<String>();
			boolean flag = true;
			for (int i = 0; i < len; i++) {
				if (!flag)
					break;
				if (temp.charAt(i) == '(' || temp.charAt(i) == '[' || temp.charAt(i) == '{' || temp.charAt(i) == '<') {
					s.push(temp.charAt(i) + "");
				} else {
					if (s.empty()) {
						flag = false;
						break;
					}
					String out = s.peek();
					switch (temp.charAt(i)) {
					case ')':
						if (out.equals("("))
							s.pop();
						break;
					case '}':
						if (out.equals("{"))
							s.pop();
						break;
					case ']':
						if (out.equals("["))
							s.pop();
						break;
					case '>':
						if (out.equals("<"))
							s.pop();
						break;
					}
				}
			}
			if (flag)
				flag = s.empty() ? true : false;
			System.out.println("#" + t + " " + (flag ? 1 : 0));
		}
	}
}
