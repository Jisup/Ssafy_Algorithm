//52���� ī�忡�� ���� �� �ִ� ��
//��Ȯ�� �ϳ��� �ִ� 5�� ������ ��� ����ϴ� ���α׷��� �ۼ��϶�
//����� �ʹ� ������ ī�� ���� ���� �� �ִ�

#include <iostream>
#include <map>
#pragma warning(disable:4996)

#define endl "\n"

using namespace std;

void xy() {
	for (int x = 1; x <= 100;x++) {
		for (int y = 1; y <= 100; y++) {
			int sum = x + y;
			if (sum < 100) {
				cout << x << " " << y << " " << 100 - sum << endl;
			}
		}
	}
}
void xz() {
	for (int x = 1; x <= 100; x++) {
		for (int z = 1; z <= 100; z++) {
			int sum = x + z;
			if (sum < 100) {
				cout << x << " " << 100-sum << " " << z << endl;
			}
		}
	}
}
void yz() {
	for (int y = 1; y <= 100; y++) {
		for (int z = 1; z <= 100; z++) {
			int sum = y + z;
			if (sum < 100) {
				cout << 100-sum << " " << y << " " << z << endl;
			}
		}
	}
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	xy();
	xz();
	yz();
}