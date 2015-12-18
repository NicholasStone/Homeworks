#pragma once
#include <iostream>
using std::cout;
using std::endl;
//最大顶点数
const int MAX_VERTEX_NUM = 20;
//图的类型
typedef enum {
	DG, DN, UDG, UDN
} GraphKind;
//弧信息变量类型
typedef int Infotype;
//节点信息变量类型
typedef char VertexType;
typedef struct ArcNode{
	//弧所指向的顶点位置
	int adjvex;
	//指向下一条弧的指针
	struct ArcNode *nextArc;
	//该弧相关信息
	Infotype *info;
}ArcNode;

typedef struct VNode{
	//顶点信息
	VertexType data;
	//指向第一条依附该点的弧指针
	ArcNode *firstarc;
}VNode, AdjList[ MAX_VERTEX_NUM ];

typedef struct {
	AdjList vertices;
	//图的当前顶点数
	int vexnum = MAX_VERTEX_NUM;
	//图的当前弧数
	int arcnum;
	//图的种类
	GraphKind kind;
}AlGraph;

void DFSTraverse( AlGraph, void( *Visit )(int), bool*);
void DFS( AlGraph, int, bool*);
void VisitFunc( int v );