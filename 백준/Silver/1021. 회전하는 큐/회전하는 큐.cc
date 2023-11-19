//덱을 이용해 문제 풀이
//while문을 이용할 때 후위연산자 사용하는 방법을 배웠다.
//dq가 vector과 유사하다는 것을 알았고 그로인해 index를 매길 수 있다는 것을 알았다.
//dq의 멤버함수 size, pop front, pop back 등의 사용법을 숙지할 수 있었다.
#include <iostream>
#include <deque>
#include <queue>
using namespace std;

int main() {
	int N, M;
	cin >> N >> M;//덱의 크기, 뽑아내려는 수의 개수

	deque<int> dq;
	for (int i = 1; i <= N; i++) {
		dq.push_back(i);
	}
	
	int offset;
	int idx = 0;
	int count = 0;
	while (M--) {
		cin >> offset;

		for (int i = 0; i < dq.size(); i++) {
			if (dq[i] == offset)
				idx = i;
		}

		if (idx <= (dq.size() - idx)) {
			while (true) {
				if (dq.front() == offset) {
					dq.pop_front();
					break;
				}
				count++;
				dq.push_back(dq.front());
				dq.pop_front();
			}
		}
		else {
			while (true) {
				if (dq.front() == offset) {
					dq.pop_front();
					break;
				}
				count++;
				dq.push_front(dq.back());
				dq.pop_back();
			}
		}

	}
	cout << count;
	return 0;
}