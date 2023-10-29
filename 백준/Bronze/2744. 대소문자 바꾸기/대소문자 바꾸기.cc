#include <iostream>
using namespace std;

int main() {
	char a[101];
	cin >> a;
	
	for (int i = 0; i < 101; i++) {
		if (a[i] >= 65 && a[i] <=90) {
			a[i] = a[i] + 32;
		}
		else if (a[i] >= 97 && a[i] <= 122) {
			a[i] = a[i] - 32;
		}
	}

	for (int i = 0; i < 101; i++) {
		if (a[i] == '\0')
			break;
		cout << a[i];
	}

	return 0;
}