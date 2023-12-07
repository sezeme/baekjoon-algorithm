#include <iostream>
#include <vector>
using namespace std;

int n, m;
int visited[9];
int arr[9];

void print() {
	for (int i = 0; i < m; i++) {
		cout << arr[i] << ' ';
	}
    cout << '\n';
}

void select(int pos, int depth) {
	if (depth == m) {
        print();
		return;
	}

	for (int i = pos+1; i <= n; i++) {		
        visited[i] = 1;
		arr[depth] = i;
		select(i, depth + 1);
		visited[i] = 0;
	}
}

int main() {
	cin >> n >> m;
	select(0, 0);	
}