#include <iostream>
using namespace std;
int binarySearch(int *arr, int first, int end, int key)
{
	int f, mid;
	mid = (first + end) / 2;
	if (first > end)
		f = -1;
	else if (arr[mid] == key)
		f = mid;
	else if (arr[mid] > key)
		f = binarySearch(arr, first, end - 1, key);
	else
		f = binarySearch(arr, first + 1, end, key);
	return f;
}
int main()
{
	int a[10] = { 11,13,18,22,35,44,56,79,82,103 };
	int p, k;
	cout << "input k:";
	cin >> k;
	p = binarySearch(a, 0, 6, k);
	if (p >= 0)
		cout << "found:" << k << "=a[" << p + 1 << "]" << endl;
	else
		cout << "no found:" << k << endl;
	return 0;
}