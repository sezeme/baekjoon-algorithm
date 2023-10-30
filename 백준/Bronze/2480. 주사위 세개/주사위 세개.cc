#include <iostream>
using namespace std;

int main() {
	int A, B, C;
	cin >> A >> B >> C;
	int price = 0;
	int max = A;
	if (max < B)
		max = B;
	if (max < C)
		max = C;

	if (A == B && B == C) {
		price = 10000 + A * 1000;
	}
	else if (A == B || B == C) {
		price = 1000 + B * 100;
	}
	else if(A == C){
		price = 1000 + A * 100;
	}
	else {
		price = max * 100;
	}
	cout << price;

	return 0;
}