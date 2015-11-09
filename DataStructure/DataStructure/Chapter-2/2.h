#ifndef __2__
#define __2__
#include <iostream>
#include <cstdlib>
const int LIST_INIT_SIZE = 100;
const int LISTINCREMENT = 10;

typedef int Status;
const Status LIST_OVERFLOW = -1;
const Status OK = 1;
const Status ERROR = 0;

typedef int ElemType;

typedef struct{
	ElemType	*elem = NULL;
	int			length = 0;
	int			listsize = 0;
}SqList;

typedef struct LNode{
	ElemType		data;
	struct LNode*	next = NULL;
}LNode,*LinkList;

#endif
