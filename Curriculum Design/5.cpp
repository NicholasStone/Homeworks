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
			G[u][v] -= 1;//������ɽ�·��ɾ��
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
	vector<int> degree(ArcNum + 1, 0);//������¼��Ķ�
	for (int i = 0; i != VerNum; i++)
	{
		cin >> u >> v;
		G[u][v] += 1;
		G[v][u] += 1;
		degree[u] ^= 1;
		degree[v] ^= 1;
	}
	for (int i = 1; i <= ArcNum; i++)//��¼���������ȵĵ�ĸ���
	{
		if (degree[i])
		{
			oddDegree++;
		}
	}
	if (oddDegree == 0 || oddDegree == 2)//����ŷ��ͨ·������������ĸ���Ϊ0��2ʱ��ͼ���Բ���ŷ��·��
	{
		for (u = 1; u <= ArcNum; u++)
		{
			if (degree[u]) break;//�ҵ���һ����Ϊ�����ĵ�
		}
		if (u == ArcNum + 1)
		{
			dfs(1);//��û����ӵ�һ���㿪ʼ�������
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