#include <iostream>
#pragma warning(disable:4996)

using namespace std;

#define endl "\n"
#define tap "\t"
#define MAX 5

/*
* N극은 1, 아래로가는성질
* S극은 2, 위로가는성질
* 기존에 넣었을때 이미 교착상태라면 큐에넣지않음
* 1칸씩 이동하다가 움직이지못하면 큐에넣지않음
* 1칸씩 이동하다가 맵밖으로 이동하게되면 소멸 < 맵에서0 >
*/
int main() {
#ifdef _CONSOLE
	freopen("input.txt", "r", stdin);
#endif
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	int tc;
	cin >> tc;
	for (int t = 1; t <= tc; t++) {
		cout << endl;
	}
}
