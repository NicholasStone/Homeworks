#ifndef __GRAPH_H__
#define __GRAPH_H__

#define MAX_VERTEX_NUM 20
typedef char VertexType;
typedef struct ArcNode
{
	int adjvex;
	struct ArcNode *nextarc = nullptr;
} ArcNode;

typedef struct VNode
{
	VertexType data;
	ArcNode  *firstarc = nullptr;
} VNode, AdjList[MAX_VERTEX_NUM];

typedef struct
{
	AdjList vertices;
	int vexnum, arcnum;
} ALGraph;
bool visited[MAX_VERTEX_NUM];
void CreateGraph(ALGraph *G);
//void DFS(ALGraph *G);
//void BFS(ALGraph *G, int k);
#endif // !__GRAPH_H__
