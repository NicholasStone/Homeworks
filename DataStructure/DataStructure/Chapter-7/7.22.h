#pragma once
#include <iostream>
using std::cout;
using std::endl;
//��󶥵���
const int MAX_VERTEX_NUM = 20;
//ͼ������
typedef enum {
	DG, DN, UDG, UDN
} GraphKind;
//����Ϣ��������
typedef int Infotype;
//�ڵ���Ϣ��������
typedef char VertexType;
typedef struct ArcNode{
	//����ָ��Ķ���λ��
	int adjvex;
	//ָ����һ������ָ��
	struct ArcNode *nextArc;
	//�û������Ϣ
	Infotype *info;
}ArcNode;

typedef struct VNode{
	//������Ϣ
	VertexType data;
	//ָ���һ�������õ�Ļ�ָ��
	ArcNode *firstarc;
}VNode, AdjList[ MAX_VERTEX_NUM ];

typedef struct {
	AdjList vertices;
	//ͼ�ĵ�ǰ������
	int vexnum = MAX_VERTEX_NUM;
	//ͼ�ĵ�ǰ����
	int arcnum;
	//ͼ������
	GraphKind kind;
}AlGraph;

void DFSTraverse( AlGraph, void( *Visit )(int), bool*);
void DFS( AlGraph, int, bool*);
void VisitFunc( int v );