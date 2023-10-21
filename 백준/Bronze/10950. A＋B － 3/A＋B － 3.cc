#include <iostream>
using namespace std;

int main(){
    int cnt;
    cin >> cnt;
    
    int a, b;
    for(int i = 0; i<cnt; i++){
        
        cin >> a >> b;
        cout << (a+b) << "\n";
    }
    
    return 0;
}