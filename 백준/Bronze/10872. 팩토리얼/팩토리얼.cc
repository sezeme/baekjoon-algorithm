#include <iostream>
using namespace std;

int main(){
    int n;
    int pac = 1;
    cin >> n;
    
    for(int i = 1; i<=n;i++){
        pac *= i;
    }
    cout << pac;
    
    return 0;
}