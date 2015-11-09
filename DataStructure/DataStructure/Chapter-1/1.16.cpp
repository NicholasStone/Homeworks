#include<iostream>
#define LENGHT 3
using namespace std;
void sort(int x[]);
typedef int num_type;
int main(int argc, char const *argv[])
{
	num_type num[LENGHT];
	for (int i = 0; i < LENGHT; i++)
	{
		cin >> num[i];
	}
	sort(num);
	for (int i = 0; i < LENGHT; i++)
	{
		cout << num[i] << endl;
	}
	return 0;
}

void sort(int x[])
{
	num_type tmp = 0;

	for (int i = 0; i < LENGHT; i++)
	{
		for (int j = i; j >= i; j--)
		{
			if (x[j] < x[j + 1])
			{
				tmp = x[j];
				x[j] = x[j + 1];
				x[j + 1] = tmp;
			}
		}
	}
}