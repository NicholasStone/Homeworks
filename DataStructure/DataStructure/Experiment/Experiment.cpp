//1．	设顺序表A中的数据元素递增有序，试写一程序，将x插入到顺序表的适当位置上，使该表仍然有序。
//

#include "Experiment.h"
using namespace std;

Node::Node( Elemtype * val, bool Res = true)
{
	NewLinkList( val );
	if(Res){
		Revrse();
	}
}
Node::~Node()
{
	DelLinkList();
}

statue Node::DelLinkList()
{
	LinkList del = L, p;
	for(p = L->next;p->next;p = p->next) {
		delete del;
		del = p;
	}
	delete del;
	return OK;
}

statue Node::Insert( Elemtype ins, int n )
{
	LinkList front = L;	// 前驱指针
	LinkList item = L;	// 本位指针
	n--;
	for(int i = 0;item->next && i < n; i++)
	{
		front = item;
		item = item->next;
	}
	front->next = new LNode;
	front->next->data = ins;
	front->next->next = item;
	return OK;
}//Insert

statue Node::Print() {//输出单链表
	int i = 0;
	LinkList p = L;
	cout << "序号\t地址\tdata\tnext\n" << endl;
	while(p) {
		cout << i << "\t" << p << "\t" << p->data << "\t" << p->next << endl;
		p = p->next;
		i++;
	}
	return OK;
}//Print

statue Node::NewLinkList( char *data ) {	//创建带头单链表,P30
	if(L){
		DelLinkList();
	}
	L = new LNode;
	L->data = '?';
	L->next = NULL;
	LinkList p = L;
	for(char *i = data;*i != '\0';i++) {
		p = new LNode;
		p->data = *i;
		p->next = L->next;
		L->next = p;
	}
	return OK;
}//NewLinkList

int Node::Length() {	//求单链表长度
	int len;
	LinkList p = L;
	for(len = 0, p = L; p->next; p = p->next, len++);
	return len;

}//Length

statue Node::Revrse() {//单链表的就地转置
								 //依次把每一个节点插入到新表的前面
	LinkList p = L->next;
	LinkList q = p->next;
	LinkList s = q->next;
	p->next = NULL;
	while(s->next) {
		q->next = p; p = q;
		q = s; s = s->next; //把L的元素逐个插入新表表头
	}
	q->next = p;
	s->next = q;
	L->next = s;

	return OK;
}

//Reverse
