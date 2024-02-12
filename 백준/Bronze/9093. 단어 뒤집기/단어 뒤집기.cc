#include <iostream>
#include <stack>
#include <string>

using namespace std;

int main() {
	int N;
	cin >> N;
	cin.ignore();

	while (N--) {
		string s = "";
		getline(cin, s);
		s += ' ';
		stack<char> stk;

		for (int i = 0; i < s.size(); i++) {
			if (s[i] == ' ') {
				while (!stk.empty()) {
					cout << stk.top();
					stk.pop();
				}
				cout << s[i];
			}
			else stk.push(s[i]);
		}

	}
}