#include<iostream>
using namespace std;

void drawline(char canvas[][100], const int m, const int n, const int x1, const int y1, const int x2, const int y2)
{
	if (x1 == x2)//Vertical
	{
		int max = y1 > y2 ? y1 : y2;
		int min = y1 < y2 ? y1 : y2;
		for (int i = min; i <= max; i++)
		{
			if (canvas[i][x1] == '-')
			{
				canvas[i][x1] = '+';
			}
			else
			{
				canvas[i][x1] = '|';
			}
		}
	}
	else
	{
		int max = x1 > x2 ? x1 : x2;
		int min = x1 < x2 ? x1 : x2;
		for (int i = min; i <= max; i++)
		{
			if (canvas[y1][i] == '|')
			{
				canvas[y1][i] = '+';
			}
			else
			{
				canvas[y1][i] = '-';
			}
		}
	}
}

void fillchar(char canvas[][100], const int m, const int n, const int x, const int y, const char b)
{
	if (x >= 0 && x <= n && y >= 0 && y <= m) // Canvas Edge
	{
		char tmp = canvas[y][x];
		if (tmp == '|' || tmp == '-' || tmp == '+')
		{
			return;
		}
		canvas[y][x] = b;
		if (canvas[y][x - 1] != b)
		{
			fillchar(canvas, m, n, x - 1, y, b);
		}
		if (canvas[y - 1][x] != b)
		{
			fillchar(canvas, m, n, x, y - 1, b);
		}
		fillchar(canvas, m, n, x + 1, y, b);
		fillchar(canvas, m, n, x, y + 1, b);
	}
}

void printcanvas(char canvas[][100], int n, int m)
{
	for (int i = m - 1; i >= 0; i--)
	{
		for (int j = 0; j < n; j++)
		{
			cout << canvas[i][j];
		}
		cout << endl;
	}
}

int main()
{
	int i, k, x1, y1, x2, y2;
	int n, m, q; //m �У� n ��
	char b;
	cin >> n >> m >> q;
	char canvas[100][100];
	//for (int i = 0; i < n; i++)
	//{
	//	memset(canvas[i], '.', m*sizeof(char));
	//}
	memset(canvas, '.', 100 * 100 * sizeof(char));
	for (i = 0;i < q;i++)
	{
		cin >> k;
		if (k == 0)
		{
			cin >> x1 >> y1 >> x2 >> y2;
			drawline(canvas, m, n, x1, y1, x2, y2);
		}
		else if (k == 1)
		{
			cin >> x1 >> y1 >> b;
			fillchar(canvas, m, n, x1, y1, b);
		}
	}
	printcanvas(canvas, n, m);
}