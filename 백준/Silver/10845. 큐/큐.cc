#include <iostream>
#include <string>
#include <vector>
using namespace std;

int N, v_size;
vector<int> v;
void push(int x){
	v_size++;
	v.push_back(x);
}
void front();
void pop() {
	if (v_size == -1) {
		cout << v_size << '\n';
		return;
	}
	front();
	for (int i = 0; i < v_size; i++) {
		v[i] = v[i + 1];
	}
	v.pop_back();
	v_size--;
	
}
void size() { cout << v_size+1 << "\n"; }
void empty() { (v_size+1) ? cout << 0 << "\n" : cout << 1 << "\n"; }
void front() { 
	if (v_size == -1) {
		cout << v_size << '\n';
		return;
	}
	cout << v[0] << '\n'; 
}
void back() { 
	if (v_size == -1) {
		cout << v_size << '\n';
		return;
	}
	cout << v[v_size] << '\n'; 
}

void input() {
	cin >> N;
	//명령어 입력 받고 동시에 함수 실행
	for (int i = 0; i < N; i++) {
		string command;
		cin >> command;

		if (command == "push") {
			int i;
			cin >> i;
			push(i);
		}
		else if (command == "pop") pop();
		else if (command == "size") size();
		else if (command == "empty") empty();
		else if (command == "front") front();
		else if (command == "back") back();
	}


}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	v_size = -1;
	input();

	return 0;
}