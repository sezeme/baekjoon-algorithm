#include <iostream>
#include <queue>
using namespace std;

int main() {
	int count = 0;
	int T;
	cin >> T;
	int N, M, prior; // 문서의 개수, 궁금한 문서 위치, 중요도
	for(int i = 0; i < T; i++) {
		count = 0;
		cin >> N >> M;
		queue<pair<int, int>> q;
		priority_queue<int> pq;

		for (int j= 0; j < N; j++) {
			cin >> prior;
			q.push({ j,prior });
			pq.push(prior);
		}

		while(!q.empty()) {
			int index = q.front().first;
			int value = q.front().second;
			q.pop();
			if (pq.top() == value) {
				pq.pop();
				++count;
				if (index == M) {
					std::cout << count << endl;
					break;
				}
			}
			else q.push({ index, value });
		}
	}
}