#include <bits/stdc++.h>
using namespace std;
#define INF 1e9
typedef long long ll;

int adj[30], cnt, ret = -1;
string s;
bool flag;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    cin >> s;
    
    for (int i = 0; i < s.size(); i++) {
    	char c = toupper(s[i]);
    	if ('A' <= c && c <= 'Z') adj[c - 'A']++;
	}
    
    for (int i = 0; i < 26; i++) {
    	if (cnt < adj[i]) {
    		cnt = adj[i];
    		ret = i;
    		flag = 0;
		}
    	else if (cnt == adj[i]) flag = 1;
	}
	
	if (flag) cout << "?";
    else cout << char(ret + 'A');
    
    return 0;
}
