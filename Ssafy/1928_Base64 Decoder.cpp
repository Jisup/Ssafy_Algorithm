/*
#include <iostream>
#include <string>
#pragma warning(disable:4996)

using namespace std;

#define endl "\n"
#define tap "\t"
#define MAX 123

int decode[MAX];
void decoding() {
	int cnt = 0;
	for (int i = 'A'; i <= 'Z'; i++) {
		decode[i] = cnt++;
	}
	for (int i = 'a'; i <= 'z'; i++) {
		decode[i] = cnt++;
	}
	for (int i = '0'; i <= '9'; i++) {
		decode[i] = cnt++;
	}
	decode['+'] = cnt++;
	decode['/'] = cnt++;
}
int main() {
#ifdef _CONSOLE
	freopen("input.txt", "r", stdin);
#endif
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	decoding();
	int tc;
	cin >> tc;
	for (int t = 1; t <= tc; t++) {
		string temp, code="";
		cin >> temp;
		for (int i = 0; i < temp.length(); i++) {
			code += to_string(decode[temp[i]]);
		}
		cout << code << endl;
	}
}
*/