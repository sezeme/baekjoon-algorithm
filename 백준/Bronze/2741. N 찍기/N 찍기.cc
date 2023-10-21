#include <iostream>
#include <string>
using namespace std;
int main()
{
	int cnt;
	cin >> cnt;
	string str="";

	for (int i = 0; i < cnt; i++)		
		str += to_string(i+1)+"\n";

	cout << str;
}