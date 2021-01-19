#include <iostream>
#pragma warning(disable:4996)

using namespace std;

#define endl "\n"
#define tap "\t"
#define MAX 5

int main() {
#ifdef _CONSOLE
	freopen("input.txt", "r", stdin);
#endif
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	
	int tc;
	cin >> tc;
	for (int t = 1; t <= tc; t++) {
		int temp;
		cin >> temp;
		if (temp % 2 == 0) {
			cout << "#" << t << " " << (temp / 2) * -1 << endl;
		}
		else {
			cout << "#" << t << " " << (temp / 2) * -1 + temp << endl;
		}
	}
}