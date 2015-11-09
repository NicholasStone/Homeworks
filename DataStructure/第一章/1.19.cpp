#include<stdexcept>
#include<iostream>
using namespace std;

int count(int);

int main(int argc, char const *argv[])
{
	const int ARRSIZE = 11;
	int array[ARRSIZE] = { 0 };
	for (int i = 0; i < ARRSIZE; i++)
	{
		try
		{
			if (i < 0)
			{
				throw range_error("数组下标溢出");
			}
			array[i] = count(i);
			cout << array[i] << endl;
		}
		catch (const std::exception& e)
		{
			cerr << e.what() << endl;
			return -1;
		}
	}
	return 0;
}

int count(int k)
{
	//k!
	int factorial = 1;
	for (int i = 1; i <= k; i++)
	{
		factorial *= i;
		if (factorial < 0)
		{
			throw range_error("数组成员溢出");
		}
	}

	//2^k
	int index = 1;
	index <<= k;
	if (index < 0)
	{
		throw range_error("数组成员溢出");
	}
	
	//k!*2^k
	int result = factorial*index;
	if (result < 0)
	{
		throw range_error("数组成员溢出");
	}
	
	return result;
}