#include <iostream>
#include <string>
#include <stack>
using namespace std;

int main() {
	int T;
	cin >> T;

	string s;
	for (int i = 0; i < T; i++) {//T개의 문자열의 VPS 여부 판단
		cin >> s;
		stack<char> PS;

		for (int j = 0; j < s.length(); j++) {
			if (s[j] == '(')//(가 들어왔을 때
				PS.push(s[j]);
			else {//)가 들어왔을 때
				if (PS.empty())//top에 (가 있다면 빼내준다 -> empty를 만들기 위해
					PS.push(s[j]);
				else if (PS.top() == '(')
					PS.pop();
				else//top에 )가 있다면? VPS가 아니므로 break
					break;
			}
		}

		if (PS.empty())
			cout << "YES\n";
		else
			cout << "NO\n";
	}
	return 0;
}