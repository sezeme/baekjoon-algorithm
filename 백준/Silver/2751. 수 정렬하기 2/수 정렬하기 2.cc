#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int N;
	cin >> N;

	int* p = new int[N];
	for (int i = 0; i < N; i++) {
		cin >> p[i];
	}

	sort(p, p + N);

	for (int i = 0; i < N; i++)
		cout << p[i] << '\n';

	delete[]p;
	return 0;
}