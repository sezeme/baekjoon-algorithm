#include <iostream>
using namespace std;

long long calc(long long a, long long b) {
	return (a + b) * (a - b);
}

int main() {
	long long A, B;
	cin >> A >> B;
	cout << calc(A, B);

	return 0;
}