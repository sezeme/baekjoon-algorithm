#include <iostream>
using namespace std;

int main() {
	char a[101];
	cin >> a;
	int count = 0;
	for (int i = 0; i < 101; i++) {
		if (a[i] == '\0') {
			cout << count;
			break;
		}
		count++;
	}

	return 0;
}