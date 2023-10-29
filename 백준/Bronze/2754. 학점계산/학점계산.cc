#include <iostream>
using namespace std;

int main() {
	string str;
	cin >> str;
	double res = 0;
	cout << fixed;
	cout.precision(1); // 소수점 1자리 표시를 위한 설정!

	switch (str[0])
	{
	case 'A':
		res += 4.0;
		break;
	case 'B':
		res += 3.0;
		break;
	case 'C':
		res += 2.0;
		break;
	case 'D':
		res += 1.0;
		break;
	}
	switch (str[1])
	{
	case '+':
		res += 0.3;
		break;
	case '-':
		res -= 0.3;
		break;
	}
	cout << res;


	return 0;
}