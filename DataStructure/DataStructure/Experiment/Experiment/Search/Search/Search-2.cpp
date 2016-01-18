#include<stdio.h>    
#include<stdlib.h>       
#define TRUE 1
#define FALSE 0      
#define OK 1             
#define N 10
#define EQ(a,b) ((a)==(b))
#define LT(a,b) ((a)<(b))  
typedef int Status;
typedef int Boolean;
typedef int KeyType;
typedef struct
{
	KeyType key;
	int others;
} ElemType;
typedef ElemType TElemType;
typedef struct BiTNode
{
	TElemType data;
	struct BiTNode *lchild, *rchild;
}BiTNode, *BiTree;
Status initDSTable(BiTree *DT)
{    // 操作结果: 构造一个空的动态查找表DT 
	*DT = NULL;
	return OK;
}
BiTree searchBST(BiTree T, KeyType key)
{
	if ((!T) || EQ(key, T->data.key))
		return T;
	else if LT(key, T->data.key)                // 在左子树中继续查找 
		return searchBST(T->lchild, key);
	else
		return searchBST(T->rchild, key);         // 在右子树中继续查找 
}
void searchBST(BiTree *T, KeyType key, BiTree f, BiTree *p, Status *flag)
{
	if (!*T)
	{
		*p = f;
		*flag = FALSE;
	}
	else if EQ(key, (*T)->data.key)
	{
		*p = *T;
		*flag = TRUE;
	}
	else if LT(key, (*T)->data.key)
		searchBST(&(*T)->lchild, key, *T, p, flag); // 在左子树中继续查找 
	else
		searchBST(&(*T)->rchild, key, *T, p, flag); //  在右子树中继续查找 
}
Status insertBST(BiTree *T, ElemType e)
{
	BiTree p, s;
	Status flag;
	searchBST(T, e.key, NULL, &p, &flag);
	if (!flag)
	{
		s = (BiTree)malloc(sizeof(BiTNode));
		s->data = e;
		s->lchild = s->rchild = NULL;
		if (!p)
			*T = s;
		else if LT(e.key, p->data.key)
			p->lchild = s;
		else
			p->rchild = s;
		return TRUE;
	}
	else
		return FALSE;
}
void deleteBST(BiTree *p)
{
	BiTree q, s;
	if (!(*p)->rchild)
	{
		q = *p;
		*p = (*p)->lchild;
		free(q);
	}
	else if (!(*p)->lchild)
	{
		q = *p;
		*p = (*p)->rchild;
		free(q);
	}
	else
	{
		q = *p;
		s = (*p)->lchild;
		while (s->rchild)
		{
			q = s;
			s = s->rchild;
		}
		(*p)->data = s->data;
		if (q != *p)
			q->rchild = s->lchild;
		else
			q->lchild = s->lchild;
		free(s);
	}
}
void traverseDSTable(BiTree DT, void(*Visit)(ElemType))
{
	if (DT)
	{
		traverseDSTable(DT->lchild, Visit);
		Visit(DT->data);
		traverseDSTable(DT->rchild, Visit); // 最后中序遍历右子树 
	}
}
void print(ElemType c)
{
	printf("(%d,%d) ", c.key, c.others);
}
void main()
{
	BiTree dt, p;
	int i;
	KeyType j;
	ElemType r[N] = { { 63, 1 },{ 21, 2 },{ 35, 3 },{ 37, 4 },{ 33, 5 },{ 12, 6 },{ 155, 7 },{ 63, 8 },{ 97, 9 },{ 78, 10 } };
	initDSTable(&dt);
	for (i = 0; i<N; i++)
		insertBST(&dt, r[i]);
	traverseDSTable(dt, print);
	printf("\nPlease input the value you want to find: ");
	scanf_s("%d", &j);
	p = searchBST(dt, j);
	if (p)
	{
		printf("Value has been find in this tree\n。");
	}
	else
		printf("Can not find value in this tree\n");
}
