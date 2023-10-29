#include <iostream>
using namespace std;

int main() {
	int N, v;
	cin >> N;
	int* A = new int[N];

	for (int i = 0; i < N; i++) {
		cin >> A[i];
	}

	cin >> v;
	int count = 0;
	for (int i = 0; i < N; i++) {
		if (A[i] == v)
			count += 1;
	}

	cout << count;

	return 0;
}