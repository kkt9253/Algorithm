#include <bits/stdc++.h>
using namespace std;
#define INF 1e9
typedef long long ll;

int dy[4] = {1, 0, -1, 0};
int dx[4] = {0, 1, 0, -1};

int n, ar[70][70];
string s, s1, s2, s3 ,s4;

string quad(int sy, int sx, int siz) {
	char chk = ar[sy][sx] + '0';
	if (siz == 1) return string(1, chk);
	
	string ret = "";
    
    for (int i = sy; i < sy + siz; i++) {
    	for (int j = sx; j < sx + siz; j++) {
    		if (chk != ar[i][j] + '0') {
    			ret += "(";
    			ret += quad(sy, sx, siz / 2);
  				ret += quad(sy, sx + siz / 2, siz / 2);
    			ret += quad(sy + siz / 2, sx, siz / 2);
    			ret += quad(sy + siz / 2, sx + siz / 2, siz / 2);
    			ret += ")";
    			return ret;
			}
		}
	}
    
    return string(1, chk);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    cin >> n;
    
    for (int i = 0; i < n; i++) {
    	cin >> s;
        for (int j = 0; j < n; j++) {
            ar[i][j] = s[j] - '0';
        }
    }
    
    string ret = quad(0, 0, n);

    cout << ret;
    
    return 0;
}
