#include <iostream>
#include <queue>
#include <string>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int N;
	string str;
	queue<int> Q;

	cin >> N;

	while (N--) {
		cin >> str;

		if (str == "push")
		{
			int num;
			cin >> num;
			Q.push(num);
		}
		else if (str == "pop")
		{
			if (!Q.empty())
			{
				cout << Q.front() << "\n";
				Q.pop();
			}
			else
				cout << "-1\n";
		}
		else if (str == "size")
			cout << Q.size() << "\n";
		else if (str == "empty")
		{
			if (Q.empty()) cout << "1\n";
			else cout << "0\n";
		}
		else if (str == "front")
		{
			if (!Q.empty()) cout << Q.front() << "\n";
			else cout << "-1\n";
		}
		else if (str == "back")
		{
			if (!Q.empty()) cout << Q.back() << "\n";
			else cout << "-1\n";
		}
	}
	return 0;
}
