#include <iostream>
using std::cout;
using std::endl;
using std::endl;

typedef struct LNode
{
	int order;
	struct LNode * next = NULL;
} LNode, *LinkList;

void Josephus(int n, int m, int s, LinkList & L);
void initList(LinkList & L, int n);
void printList(LinkList & L, int n);

int main(int argc, char const *argv[])
{
	LinkList L = NULL;
	Josephus(10, 3, 7, L);
	//initList(L, 10);
	//printList(L, 10);
}

void initList(LinkList & L, int n)
{
	L = new LNode;
	L->order = n;
	L->next = L;
	LNode * beginning = L;
	LNode * node = NULL;
	for (int i = n - 1; i > 0; i--)
	{
		node = new LNode;
		node->order = i;
		node->next = L;
		L = node;
		beginning->next = L;
	}
}

void printList(LinkList & L, int n)
{
	LNode * node = L;
	for (int i = 0; i < n + 4; i++)
	{
		cout << node->order << endl;
		node = node->next;
	}
}

void Josephus(int n, int m, int s, LinkList & L)
{
	initList(L, n);
	LNode * node = NULL;
	LNode * prevNode = L;
	for (int i = 0; i < s - 1; i++)
	{
		prevNode = prevNode->next;
	}
	while (L)
	{
		for (int i = 0; i < m; i++)
		{
			prevNode = prevNode->next;
		}
		cout << prevNode->next->order << endl;
		node = prevNode->next;
		if (prevNode->next != prevNode->next->next)
			prevNode->next = prevNode->next->next;
		else
			break;
		delete node;
	}
}