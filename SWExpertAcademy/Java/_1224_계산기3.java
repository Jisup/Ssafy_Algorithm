

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class _1224_계산기3 {
	static int len;
	static String input;

	static void init() {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			len = sc.nextInt();
			input = sc.next();
			System.out.print("#" + t + " ");
			solve();
		}
	}

	static void solve() {
		/*
		 * 숫자는 list에 담기
		 * 연산자는 stack에 담기
		 * stack.top() 가중치 >= new stack.push() 라면 top을 list에 담는다
		 * ( 는 stack에 담고
		 * ) 나오는순간 모든연산자를 list에넣고 (를 없앤다
		 */
		String output = "";
		String priority = "";
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < len; i++) {
			char index = input.charAt(i);
			if (index == '(') 
				stack.push(index);
			else if (index >= '0' && index <= '9')
				output += index;
			else if (index == '*' || index == '+') {
				if (index=='+' && (stack.peek() == '*' || stack.peek()=='+'))
					output += stack.pop();
				if (index=='*' && stack.peek() == '*')
					output += stack.pop();
				stack.push(index);
			}
			else if (index == ')') {
				while(true) {
					char temp = stack.pop();
					if (temp == '(') break;
					output += temp;
				}
			}
		}
		while (!stack.isEmpty())
			output += stack.pop();
//		System.out.println(output);
		calc(output);
	}

	static void calc(String input) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int index = 0; index < input.length(); index++) {
			char value = input.charAt(index);
			if (value == '*')
				stack.push(stack.pop() * stack.pop());
			else if (value == '+')
				stack.push(stack.pop() + stack.pop());
			else
				stack.push(Integer.parseInt(value+""));
		}
		System.out.println(stack.pop());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
	}

}