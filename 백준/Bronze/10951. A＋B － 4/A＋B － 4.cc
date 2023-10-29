#include <iostream>
using namespace std;

int main() {
	int A, B;
	
	while (true) {
		cin >> A >> B;
		if (cin.eof() == true) {
			break;
		}
		cout << A + B << '\n';
	}

	return 0;
}