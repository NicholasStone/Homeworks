#pragma warning(disable:4996)
#include <stdio.h>
#include <stdlib.h>
#include "Graph.h"
#include "queue.h"
void CreateGraph(ALGraph *G)
{
	int i, j, k;
	char a;
	ArcNode *s;           //定义边表结点
	printf("Input VertexNum(n) and ArcNum(e): ");
	scanf("%d,%d", &G->vexnum, &G->arcnum);       //读入顶点数和边数
	scanf("%c", &a);
	printf("Input Vertex string:");
	for (i = 0;i < G->vexnum;i++)         //建立边表
	{
		scanf("%c", &a);
		G->vertices[i].data = a;       //读入顶点信息
		G->vertices[i].firstarc = NULL;  //边表置为空表
	}
	printf("Input edges,Creat Adjacency List\n");
	for (k = 0;k < G->arcnum;k++)
	{        //建立边表     
		scanf("%d,%d", &i, &j);          //读入边（Vi，Vj）的顶点对序号
		s = (ArcNode *)malloc(sizeof(ArcNode));    //生成边表结点
		s->adjvex = j;                  //邻接点序号为j
		s->nextarc = G->vertices[i].firstarc;
		G->vertices[i].firstarc = s;     //将新结点*S插入顶点Vi的边表头部
		s = (ArcNode *)malloc(sizeof(ArcNode));
		s->adjvex = i;                   //邻接点序号为i
		s->nextarc = G->vertices[j].firstarc;
		G->vertices[j].firstarc = s;      //将新结点*S插入顶点Vj的边表头部
	}
}
void DFSTraverse(ALGraph *G, int i)
{                         //以Vi为出发点对邻接链表表示的图G进行DFS搜索
	ArcNode *p;
	printf("%c", G->vertices[i].data);    //访问顶点Vi
	visited[i] = true;                      //标记Vi已访问
	p = G->vertices[i].firstarc;            //取Vi边表的头指针
	while (p)
	{                  //依次搜索Vi的邻接点Vj，这里j=p->adjvex
		if (!visited[p->adjvex])      //若Vj尚未被访问
			DFSTraverse(G, p->adjvex);        //则以Vj为出发点向纵深搜索
		p = p->nextarc;                    //找Vi的下一个邻接点
	}
}
void DFS(ALGraph *G)
{
	int i;
	for (i = 0;i < G->vexnum;i++)
		visited[i] = false;             //标志向量初始化
	for (i = 0;i < G->vexnum;i++)
		if (!visited[i])               //Vi未访问过 	    
			DFSTraverse(G, i);                //以Vi为源点开始DFS搜索 
}//以Vi为源点开始DFS搜索
void BFS(ALGraph *G, int k)
{                          //以Vk为源点对用邻接链表表示的图G进行广度优先搜索
	int i, f = 0, r = 0;
	ArcNode *p;
	int cq[MAX_VERTEX_NUM];         //定义FIFO队列     
	for (i = 0;i < G->vexnum;i++)
		visited[i] = false;	         //标志向量初始化
	for (i = 0;i <= G->vexnum;i++)
		cq[i] = -1;                          //初始化标志向量
	printf("%c", G->vertices[k].data); //访问源点Vk
	visited[k] = true;
	cq[r] = k;           //Vk已访问，将其入队。注意，实际上是将其序号入队 
	while (cq[f] != -1)
	{
		//队列非空则执行
		i = cq[f]; f = f + 1;                //Vi出队
		p = G->vertices[i].firstarc;     //取Vi的边表头指针
		while (p)
		{                //依次搜索Vi的邻接点Vj（令p->adjvex=j）
			if (!visited[p->adjvex])
			{           //若Vj未访问过
				printf("%c", G->vertices[p->adjvex].data);      //访问Vj
				visited[p->adjvex] = true;
				r = r + 1; cq[r] = p->adjvex;            //访问过的Vj入队
			}
			p = p->nextarc;               //找Vi的下一个邻接点
		}
	}//endwhile
}
bool DfsReachable(ALGraph *g, int i, int j)
{
	ArcNode *p;
	SqQueue Q;
	int e, k;
	InitQueue(Q);
	if (!&g->vexnum || !&g->arcnum)//图的当前顶点数或弧数为0时
		return ERROR;
	else
	{
		EnQueue(Q, i);
		while (!QueueEmpty(Q))
		{
			DeQueue(Q, e);
			visited[e] = true;//标记被访问过的顶点
			p = g->vertices[e].firstarc;
			for (; p != NULL; p = p->nextarc)
			{
				k = p->adjvex;//当前弧所指向顶点的位置
				if (k == j)
					return OK;
				else if (!visited[k])//当前顶点未被访问过
					EnQueue(Q, k);
			}
		}
		return ERROR;
	}
}
int main()
{
	ALGraph *G;
	G = (ALGraph *)malloc(sizeof(ALGraph));
	CreateGraph(G);
	int m, n;
	printf("2 Vertex\n");
	scanf("%d %d", &m, &n);
	//m = DfsReachable(G, m, n);
	//if (m)
	//	printf("Reachable\n");
	//else
		printf("Unreachable\n");
}