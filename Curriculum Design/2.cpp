#include <iostream>
#include <map>
using namespace std;

int main()
{
	map<int, int> collect;
	int operatNum = 0, number;
	cin >> operatNum;

	for (int i = 0; i < operatNum; i++)
	{
		cin >> number;
		collect[number]++;
	}
	cout << endl;
	for (map<int,int>::iterator item = collect.begin(); item != collect.end(); item++)
	{
		cout << item->first << " " << item->second << endl;
 	}

	return 0;
}