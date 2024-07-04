#include <bits/stdc++.h>
using namespace std;

int idx, n, asize, bsize;
string pat, stra, strb, a, b;

vector<string> file;

int main() {
    cin >> n;
    cin >> pat;
    for (int i = 0; i < n; i++) {
        string s;
        cin >> s;
        file.push_back(s);
    }
    idx = pat.find("*");
    a = pat.substr(0, idx);
    b = pat.substr(idx + 1);
    asize = a.size();
    bsize = b.size();
    
    for (string str : file) {
    	if (str.size() < asize + bsize) {
    		cout << "NE\n";
    		continue;
		}
        stra = str.substr(0, asize);
        strb = str.substr(str.size() - bsize);
        if (stra == a && strb == b) cout << "DA\n";
        else cout << "NE\n";
    }
    
    return 0;
}