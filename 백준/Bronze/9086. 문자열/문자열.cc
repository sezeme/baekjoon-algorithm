#include <iostream>
using namespace std;

int main() {
	int t;
	char S[1000];
	cin >> t;

	for (int i = 0; i < t; i++) {
		cin >> S;
		cout << S[0];
		for (int j = 0; j < 1000; j++) {
			if (S[j] == '\0') {
				cout << S[j - 1] << endl;
				break;
			}
				
		}
	}
	

	return 0;
}