//1��	��˳���A�е�����Ԫ�ص���������дһ���򣬽�x���뵽˳�����ʵ�λ���ϣ�ʹ�ñ���Ȼ����

#include "Experiment.h"
using namespace std;

Node::Node(Elemtype * val)
{
	NewNode(val);
}

Node::~Node()
{
	DelNode();
}

statue Node::DelNode()
{
	LinkList del = L, p;
	for (p = L->next;p->next;p = p->next) {
		delete del;
		del = p;
	}
	delete del;
	return OK;
}

statue Node::Insert(Elemtype ins, int n)
{
	LinkList front;	// ǰ��ָ��
	LinkList item = L;	// ��λָ��
	for (int i = 0;item->next && i < n;item = item->next, i++)
	{

	}
	return OK;
}//Insert

statue Node::Print() {//���������
	int i = 0;
	LinkList p = L;
	cout << "���\t��ַ\tdata\tnext\n" << endl;
	while (p) {
		printf("%d\t%x\t%c\t%x\n", i, p, p->data, p->next);
		p = p->next;
		i++;
	}
	return OK;
}//Print

statue Node::NewNode(char *data) {	//������ͷ������,P30
	L = new LNode;
	L->data = '?';
	L->next = NULL;
	LinkList p = L;
	for (char *i = data;*i != '\0';i++) {
		p = new LNode;
		p->data = *i;
		p->next = L->next;
		L->next = p;
	}
	return OK;
}//NewNode

int Node::Length() {	//��������
	int len;
	LinkList p = L;
	for (len = 0, p = L; p->next; p = p->next, len++);
	return len;

}//Length

statue Node::Revrse() {//������ľ͵�ת��
								 //���ΰ�ÿһ���ڵ���뵽�±��ǰ��
	LinkList p = L->next;
	LinkList q = p->next;
	LinkList s = q->next;
	p->next = NULL;
	while (s->next) {
		q->next = p; p = q;
		q = s; s = s->next; //��L��Ԫ����������±��ͷ
	}
	q->next = p;
	s->next = q;
	L->next = s;

	return OK;
}

//Reverse


