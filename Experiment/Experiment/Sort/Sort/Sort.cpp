#include <iostream>
using namespace std;
typedef struct LNode {	//单链表节点结构
	int	 data;
	struct LNode	 *next;
}LNode, *LinkList;
int printList(LinkList &L) {//输出单链表
	int i = 1;
	LinkList p = L;

	while (p) {
		cout << p->data<<"\t";
		p = p->next;
		i++;
	}
	cout << endl;
	return 1;
}//printList
int createList(LinkList &L, int data[], int n) {	//创建带头单链表,P30
	L = (LinkList)malloc(sizeof(LNode));
	L->data = 0;
	L->next = NULL;
	LinkList p;
	for (int i = 0; i < n; i++) {
		p = (LinkList)malloc(sizeof(LNode));
		p->data = data[i];
		p->next = L->next;
		L->next = p;
	}
	return 1;
}
void sort(LinkList head, int n) {
	if (n == 0)
		return;
	int min;
	int i, s = 0;
	LinkList p;
	LinkList r;
	LinkList t;
	p = head->next;
	r = head->next;
	t = head;
	min = p->data;
	for (i = 0; i<n; i++) {
		if (min>p->data) {
			min = p->data;
			r = p;
			s = i;
		}
		p = p->next;
	}
	for (i = 0; i<s; i++)
		t = t->next;
	t->next = r->next;
	r->next = head->next;
	head->next = r;
	sort(head->next, n - 1);
}
int main()
{
	int data[] = {17,35,29,68,93,77};
	LinkList L;
	createList(L, data, 6);
	cout << "原始链表：" << endl;
	printList(L);	//输出
	cout << endl;
	sort(L, 5);
	printList(L);
    return 0;
}

