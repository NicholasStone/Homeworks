//1��	��˳���A�е�����Ԫ�ص���������дһ���򣬽�x���뵽˳�����ʵ�λ���ϣ�ʹ�ñ���Ȼ����
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
	LinkList front = L;	// ǰ��ָ��
	LinkList item = L;	// ��λָ��
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

statue Node::Print() {//���������
	int i = 0;
	LinkList p = L;
	cout << "���\t��ַ\tdata\tnext\n" << endl;
	while(p) {
		cout << i << "\t" << p << "\t" << p->data << "\t" << p->next << endl;
		p = p->next;
		i++;
	}
	return OK;
}//Print

statue Node::NewLinkList( char *data ) {	//������ͷ������,P30
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

int Node::Length() {	//��������
	int len;
	LinkList p = L;
	for(len = 0, p = L; p->next; p = p->next, len++);
	return len;

}//Length

statue Node::Revrse() {//������ľ͵�ת��
								 //���ΰ�ÿһ���ڵ���뵽�±��ǰ��
	LinkList p = L->next;
	LinkList q = p->next;
	LinkList s = q->next;
	p->next = NULL;
	while(s->next) {
		q->next = p; p = q;
		q = s; s = s->next; //��L��Ԫ����������±��ͷ
	}
	q->next = p;
	s->next = q;
	L->next = s;

	return OK;
}

//Reverse
