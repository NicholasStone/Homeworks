#include<iostream>
const int MAX_VERTEX_NUM = 7;
typedef char VertexType;
typedef int unsigned VRType;

typedef struct
{
	VertexType vexs[MAX_VERTEX_NUM];
	VRType arcs[MAX_VERTEX_NUM][MAX_VERTEX_NUM];
	int vexnum, arcnum;
} MGraph;
using namespace std;

int LocateVex(MGraph const &map, VertexType const u)
{
	for (int i = 0; i < MAX_VERTEX_NUM; i++)
	{
		if (map.vexs[i] == u)
		{
			return i;
		}
	}

	return -1;
}


void Prim(MGraph const &map, VertexType const u)
{
	struct
	{
		VertexType adjvex;
		VRType lowcost;
	}closeedge[MAX_VERTEX_NUM];
	int k = LocateVex(map, u);

	for (int i = 0; i < map.vexnum; i++)
	{
		if (i != k)
		{
			closeedge[i] = { u, map.arcs[k][i] };
		}
	}
	closeedge[k].lowcost = 0;
	for (int i = 1; i < map.vexnum; i++)
	{
		//k = minimum(closeedge);
		int minimun = MAX_VERTEX_NUM;
		for (int i = 0; i < MAX_VERTEX_NUM; i++)
		{
			if (closeedge[i].lowcost > 0 && i != k)
			{
				if (closeedge[i].lowcost < closeedge[minimun].lowcost)
				{
					minimun = i;
				}
			}
		}
		k = minimun;
		//
		cout << closeedge[k].adjvex << "," << map.vexs[k] << endl;
		closeedge[k].lowcost = 0;
		for (int i = 0; i < map.vexnum; i++)
		{
			if (map.arcs[k][i] < closeedge[i].lowcost)
			{
				closeedge[i] = { map.vexs[k], map.arcs[k][i] };
			}
		}
	}
}


int main()
{
	int result[10] = { 0 };
	VRType matrix[MAX_VERTEX_NUM][MAX_VERTEX_NUM] = {
		{ 0, 7,-1, 5,-1,-1,-1},
		{ 7, 0, 8, 9, 7,-1,-1},
		{-1, 8, 0,-1, 5,-1,-1},
		{ 5, 9,-1, 0,15, 6,-1},
		{-1, 7, 5,15, 0, 8, 9},
		{-1,-1,-1, 6, 8, 0,11},
		{-1,-1,-1,-1, 9,11, 0}
	};

	MGraph map;
	map.vexnum = 7;
	map.arcnum = 11;
	for (int i = 0, j = 0x41; i < MAX_VERTEX_NUM; i++, j++)
	{
		map.vexs[i] = j;
	}
	for (int i = 0; i < MAX_VERTEX_NUM; i++)
	{
		for (int j = 0; j < MAX_VERTEX_NUM; j++)
		{
			map.arcs[i][j] = matrix[i][j];
		}
	}

	Prim(map, 'D');

	return 0;
}