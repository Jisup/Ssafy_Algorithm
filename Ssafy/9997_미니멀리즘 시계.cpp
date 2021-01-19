
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
		int theta;
		cin >> theta;
		theta *= 2;
		int hour = 0, minute = 0;
		hour = theta / 60;
		minute = theta % 60;
		cout << "#" << t << " " << hour << " " << minute << endl;
	}
}
