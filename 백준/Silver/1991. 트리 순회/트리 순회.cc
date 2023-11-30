#include <iostream>
#include <map>
using namespace std;

int N;
char node, var2, var3;
map<char, pair<char, char>> tree;

void preorder(char node) {
	cout << node;
	if (tree[node].first != '.') {
		preorder(tree[node].first);
	}
	if (tree[node].second != '.') {
		preorder(tree[node].second);
	}
}

void inorder(char node) {
	if (tree[node].first != '.') {
		inorder(tree[node].first);
	}
	cout << node;
	if (tree[node].second != '.') {
		inorder(tree[node].second);
	}
}

void postorder(char node) {
	if (tree[node].first != '.') {
		postorder(tree[node].first);
	}
	if (tree[node].second != '.') {
		postorder(tree[node].second);
	}
	cout << node;
}

int main() {	
	cin >> N;
	for (int i = 0; i < N; i++) {		
		cin >> node >> var2 >> var3;
		tree[node] = make_pair(var2, var3);
	}

	preorder('A');
	cout << "\n";
	inorder('A');
	cout << "\n";
	postorder('A');
}