//判断以@结尾的任意长字符串是否为回文
#include<iostream>
using namespace std;

typedef char Elemtype;
typedef int Status;

const Status OK = 1;
const Status ERROR = 0;
typedef struct Node{
	Elemtype value;
	struct Node * next;
}Node, *LinkList;

LinkList NodeInit( LinkList & L, Elemtype* data )
{
	L = new Node;
	LinkList p = L;

	for(int i = 0; data[ i ]; i++)
	{
		p->value = data[ i ];
		p->next = new Node;
		p = p->next;
	}
	return p;
}
bool SymmetryString( Node & L ,Elemtype* data)
{
	LinkList Head, End;
	End = NodeInit( Head ,data);

}