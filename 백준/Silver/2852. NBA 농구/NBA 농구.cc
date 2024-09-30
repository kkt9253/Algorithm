#include <bits/stdc++.h>
using namespace std;
#define INF 1e9

int n, team, f, s, ret1, ret2;
string st;
pair<int, int> win;

string convert(int i) {
	string a = to_string(i / 60);
	string b = to_string(i % 60);
	if (a.size() == 1) a.insert(0, "0");
	if (b.size() == 1) b.insert(0, "0");
	string ret = a + ":" + b;
	return ret;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    cin >> n;
    while (n--) {
    	cin >> team >> st;
    	(team == 1) ? f++ : s++;
    	string mm = st.substr(0, 2);
    	string ss = st.substr(3, 2);
		int goalT = atoi(mm.c_str()) * 60 + atoi(ss.c_str());
		
		if (win.first == 1) {
			ret1 += goalT - win.second;
		}
		else if (win.first == 2) {
			ret2 += goalT - win.second;
		}
    	
    	win.second = goalT;
    	if (f > s) {
    		win.first = 1;
		}
		else if (f < s) {
    		win.first = 2;
		}
		else {
			win.first = 0;
		}
	}
	
	if (win.first == 1) {
			ret1 += 2880 - win.second;
		}
		else if (win.first == 2) {
			ret2 += 2880 - win.second;
		}
    
    cout << convert(ret1) << "\n" << convert(ret2);
    
    return 0;
}
