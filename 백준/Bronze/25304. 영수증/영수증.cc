#include <iostream>

using namespace std;

int main() {
	int X,N;
	cin >> X;
	cin >> N;

	int price, count;
	for (int i = 0; i < N; i++) {
		cin >> price >> count;
		X -= price * count;
	}

	if (X == 0) {
		cout << "Yes";
	}
	else {
		cout << "No";
	}
	return 0;
}