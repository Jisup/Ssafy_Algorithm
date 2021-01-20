#include <iostream>
#include <string>

using namespace std;

#define endl "\n"

int main() {
#ifdef _CONSOLE
	freopen("input.txt", "r", stdin);
#endif
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	int tc;
	cin >> tc;
	for (int t = 1; t <= tc; t++) {
		string palindrome;
		cin >> palindrome;
		int Size = palindrome.length();
		string plaintext = "";
		for (int i = 0; i < Size / 2; i++)
			plaintext += palindrome[i];
		string reverse = "";
		if (Size % 2 == 0)Size--;
		for (int i = palindrome.length() - 1; i > Size / 2; i--)
			reverse += palindrome[i];
		cout << "#" << t << " ";
		plaintext == reverse ? cout << 1 << endl : cout << 0 << endl;
	}
}