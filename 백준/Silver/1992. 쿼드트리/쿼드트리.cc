#include <bits/stdc++.h>
using namespace std;
#define INF 1e9
typedef long long ll;

int dy[4] = {1, 0, -1, 0};
int dx[4] = {0, 1, 0, -1};

int n, ar[70][70];
string s;

string check(int sy, int sx, int siz) {
    int ret = 0;
    
    for (int i = sy; i < sy + siz; i++) {
        for (int j = sx; j < sx + siz; j++) {
            ret += ar[i][j];
        }
    }
    
    if (ret == 0) return "0";
    else if (ret == siz * siz) return "1";
    return "err";
}

string quad(int sy, int sx, int siz) {
	
    if (siz == 1) {
        return to_string(ar[sy][sx]);
    }

    string s1 = check(sy, sx, siz / 2);
    string s2 = check(sy, sx + siz / 2, siz / 2);
    string s3 = check(sy + siz / 2, sx, siz / 2);
    string s4 = check(sy + siz / 2, sx + siz / 2, siz / 2);

    if (s1 == "err") s1 = quad(sy, sx, siz / 2);
    if (s2 == "err") s2 = quad(sy, sx + siz / 2, siz / 2);
    if (s3 == "err") s3 = quad(sy + siz / 2, sx, siz / 2);
    if (s4 == "err") s4 = quad(sy + siz / 2, sx + siz / 2, siz / 2);
    
    return "(" + s1 + s2 + s3 + s4 + ")";
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
    
    string ret = check(0, 0, n);
    if (ret == "err") {
        ret = quad(0, 0, n);
    }

    cout << ret;
    
    return 0;
}
