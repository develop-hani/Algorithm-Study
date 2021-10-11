#include <iostream>
#include <deque>
#include <string>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int N;
	string str;
	deque<int> D;

	cin >> N;

	while (N--) {
		cin >> str;

		if (str == "push_front")
		{
			int num;
			cin >> num;
			D.push_front(num);
		}
		else if(str == "push_back")
		{
			int num;
			cin >> num;
			D.push_back(num);
		}
		else if (str == "pop_front")
		{
			if (!D.empty())
			{
				cout << D.front() << "\n";
				D.pop_front();
			}
			else
				cout << "-1\n";
		}
		else if (str == "pop_back")
		{
			if (!D.empty())
			{
				cout << D.back() << "\n";
				D.pop_back();
			}
			else
				cout << "-1\n";
		}
		else if (str == "size")
			cout << D.size() << "\n";
		else if (str == "empty")
		{
			if (D.empty()) cout << "1\n";
			else cout << "0\n";
		}
		else if (str == "front")
		{
			if (!D.empty()) cout << D.front() << "\n";
			else cout << "-1\n";
		}
		else if (str == "back")
		{
			if (!D.empty()) cout << D.back() << "\n";
			else cout << "-1\n";
		}
	}
	return 0;
}
