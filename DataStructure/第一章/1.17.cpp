/**
* 算法解释：
* 常见的斐波那契数列2阶 k阶则为前  k项之和
* 故m不能小于k
*/
#include<iostream>

using namespace std;

int getResult(int k, int m);

int main(int argc, char const *argv[])
{
	int k, m;
	cout << "k(m>k):";
	cout << endl;
	cin >> k;
	cout << "m(m>k)";
	cout << endl;
	cin >> m;
	if (m < k) {
		cerr << "输入m值不能小于k";
		return -1;
	}

	cout << "result:" << getResult(k, m) << endl;
	return 0;
}
/**
 * 得到结果
 * @param  k 阶数
 * @param  m 项数
 * @return   对应结果
 */
int getResult(int const k, int const m)
{
	//求第m项值则前m项为必须
	int *array = new int[k];

	//初始化数组 使前 k-2项为0 k-1项为1
	for (int i = 0; i < k - 1; i++)
	{
		array[i] = 0;
	}
	array[k - 1] = 1;

	//开始计算所有数组中对应项，计算结果从第0位开始保存
	int last_index = 0;			//计算出的最后一位
	int tmp_sum = 0;			//临时保存全部数组相加结果
	//执行m次以求得第m项
	for (int i = 0; i < m - 1; i++)
	{
		//将数组中所有的数组全部相加 求得Fk
		for (int j = 0; j < k; j++)
		{
			tmp_sum += array[j];
		}
		//将Fk放到 n 位置
		array[last_index] = tmp_sum;
		//临时变量归零
		tmp_sum = 0;
		//若最后一位项数等于数组上限 则将last_index归零
		//若未超过则加一
		if (last_index == k - 1)
		{
			last_index = 0;
		}
		else
		{
			last_index++;
		}
		
	}
	//返回所求值
	tmp_sum = array[last_index];
	delete[] array;
	return tmp_sum;
}
