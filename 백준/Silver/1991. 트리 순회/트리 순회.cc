#include <iostream>
#include <map>
using namespace std;

int n;
char leftChild, node, rightChild;
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
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> node >> leftChild >> rightChild;
		tree[node] = make_pair(leftChild, rightChild);
	}
	preorder('A');
	cout << '\n';
	inorder('A');
	cout << '\n';
	postorder('A');
}