#ifndef __EXPERIMENT_
#define __EXPERIMENT__
#include<iostream>
#include<cstdlib>

const int OK = 1;
const int ERROR = 0;

typedef int statue;
typedef char Elemtype;

typedef struct LNode {	//�������ڵ�ṹ
	Elemtype		data;
	struct LNode	*next;
}LNode, *LinkList;

class Node
{
public:
	Node( Elemtype *, bool );
	~Node();
	statue Insert( Elemtype, int );
	statue Print();
	int Length();
	statue Revrse();
	statue NewLinkList( char* );
	statue DelLinkList();
protected:
	LinkList L = NULL;

};

#endif