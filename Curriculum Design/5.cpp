#include <stack>
#include <iostream>
#include <string>
#include <vector>
const int MAX_VERTEX_NUM = 10;
using namespace std;

int G[MAX_VERTEX_NUM][MAX_VERTEX_NUM];
int ArcNum, VerNum;
stack<int> S;

void dfs(int u)
{
	for (int v = 1; v <= ArcNum; v++)
	{
		if (G[u][v])
		{
			G[u][v] -= 1;//搜索后可将路径删除
			G[v][u] -= 1;
			dfs(v);
		}
	}
	S.push(u);
}

int main()
{
	cin >> ArcNum >> VerNum;
	int u, v, oddDegree = 0;
	vector<int> degree(ArcNum + 1, 0);//用来记录点的度
	for (int i = 0; i != VerNum; i++)
	{
		cin >> u >> v;
		G[u][v] += 1;
		G[v][u] += 1;
		degree[u] ^= 1;
		degree[v] ^= 1;
	}
	for (int i = 1; i <= ArcNum; i++)//记录有奇数个度的点的个数
	{
		if (degree[i])
		{
			oddDegree++;
		}
	}
	if (oddDegree == 0 || oddDegree == 2)//根据欧拉通路定理，当奇数点的个数为0或2时此图可以产生欧拉路径
	{
		for (u = 1; u <= ArcNum; u++)
		{
			if (degree[u]) break;//找到第一个度为奇数的点
		}
		if (u == ArcNum + 1)
		{
			dfs(1);//若没有则从第一个点开始深度搜索
		}
		else
		{
			dfs(u);
		}
		while (!S.empty())
		{
			cout << S.top() << " ";
			S.pop();
		}
		cout << endl;
	}
	else
	{
		cout << "-1" << endl;
	}
	
	return 0;
}