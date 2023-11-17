#include <iostream>
#include <stack>
using namespace std;

int main() {
	int K;
	cin >> K;

	stack<int> stk;
	for(int i = 0; i < K; i++) {
		int j;
		cin >> j;
		
		if (j == 0)
			stk.pop();
		else
			stk.push(j);
	}

	int sum = 0;
	int size = stk.size();
	for (int i = 0; i < size; i++) {
		sum += stk.top();
		stk.pop();
	}
	cout << sum;

	return 0;
}