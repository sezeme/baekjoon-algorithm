#include <iostream>
#include <string>
#include <stack>
using namespace std;

int main() {
	int T;
	cin >> T;

	while(T>0) {//T개의 문자열의 VPS 여부 판단
		T--;
		string s;
		cin >> s;
		stack<char> PS;

		string answer = "YES";
		for (int i = 0; i < s.length(); i++) {
			if (s[i] == '(')//(가 들어오면 넣기
				PS.push(s[i]);
			else if (!PS.empty() && PS.top() == '(' && s[i] == ')') {
				PS.pop();// pop이 가능한 유일한 조건
			}
			else { // 외의 나머지는 전부 no
				answer = "NO";
				break;
			}
		}
		if (!PS.empty()) //(를 전부 pop 못시켰을 경우 not VPS
			answer = "NO";

		cout << answer << endl;
	}
	return 0;
}