#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
//시간초과가 뜰 때 printf, scanf를 사용하면 더 빠르게 결과값 출력 가능
using namespace std;


int result[3]; // 전역변수는 0으로 초기화
int map[2200][2200];

bool check(int row, int col, int num) {

	int start = map[row][col];
	for (int i = row; i < row + num; i++) {
		for (int j = col; j < col + num; j++) {
			if (start != map[i][j])
				return false;
		}
	}
	return true;
}


void divide(int row, int col, int num) {

	if (check(row, col, num)) {
		result[map[row][col]]++;
	}
	else {
		int size = num / 3;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				divide(row + size * i, col + size * j, size);
			}
		}
	}
}


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int N;
	cin >> N;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {

			int input;
			cin >> input;
			input++; // -1,0,1 을 각각 0,1,2로 표현		
			map[i][j] = input;
		}
	}
	divide(0, 0, N);
	cout << result[0] << endl << result[1] << endl << result[2];

}