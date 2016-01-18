#ifndef __TREE_H__
#define __TREE_H__

#include <iostream>

const int OK = 1;
const int ERROR = 0;

typedef char TElemType;

typedef struct BiTNode
{
	TElemType data;
	struct BiTNode *lchild, *rchild;
} BiTNode, *BiTree;

#endif // !__TREE_H__
