//52장의 카드에서 만들 수 있는 페어가
//정확히 하나만 있는 5장 조합을 모두 출력하는 프로그램을 작성하라
//출력이 너무 많으면 카드 수를 줄일 수 있다

#include <iostream>
#include <map>
#pragma warning(disable:4996)

#define endl "\n"
#define MAX 53

using namespace std;
map <int, int> card;

bool visit[MAX];

void solve(int index, int cnt, int view[], bool make) {
	if (make && visit[index]) return;
	if (cnt > 5) {
		for (int i = 0; i < 5; i++)
			printf("%2d", view[i]);
		cout << endl;
		return;
	}

	for (int i = 1; i <= 6; i++) {
		if (make) {
			if (!visit[i]) {
				visit[i] = true;
				card[i]++;
				view[cnt] = i;
				solve(i, cnt + 1, view, make);
				visit[i] = false;
				card[i]--;
			}
		}
		else {//매칭이 안되었을때
			if (card[i] < 2) {
				if (card[i]==0) {
					visit[i] = true;
					card[i]++;
					view[cnt] = i;
					solve(i, cnt + 1, view, make);
					visit[i] = false;
					card[i]--;
				}
				else {
					make = true;
					card[i]++;
					view[cnt] = i;
					solve(i, cnt + 1, view, make);
					make = false;
					card[i]--;
				}
			}
		}
	}
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	for (int i = 1; i <= 6; i++) {
		card[i]++;
		int temp[5] = { 0, };
		temp[0] = i;
		solve(1, 1, temp, false);
	}
}