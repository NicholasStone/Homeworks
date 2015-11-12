#include<iostream>
using namespace std;
const int INIT_QUEUE_LENGTH = 5;
const int QUEUE_INCREMENT = 10;

typedef int Elemtype;
typedef int Status;

const Status OK = 1;
const Status ERROR = 0;
typedef struct Node{
	Elemtype value;
	struct Node * next;
}Node,*LinkList;

Status EnQueue( LinkList &L, Elemtype n )
{
	Node *p = new Node;
	p->value = n;
	p->next = L->next;
	L->next = p;
	return OK;
}

Status DeQueue( LinkList &L, Elemtype &n )
{
	LinkList q = L;
	LinkList p;
	for(p = L->next; p->next != L; p = p->next);
	p->next = L->next;
	L = p;
	n = q->value;
	delete q;
	return OK;
}

Status QueueInit( LinkList &L, int n )
{
	L = new Node;
	cin >> L->value;
	L->next = new Node;
	cin >> L->next->value;
	L->next->next = L;
	for(int i = 0; i < n - 2; i++)
	{
		Elemtype n;
		cin >> n;
		EnQueue( L, n );
	}
	return OK;
}

void PrintQueue( LinkList &L )
{
	cout << L->value << endl;
	for(Node *i = L->next;i != L;i = i->next){
		cout << i->value << endl;
	}
}

int main( int argc, char const * argv[] )
{
	LinkList L = NULL;
	QueueInit( L, INIT_QUEUE_LENGTH );
	Elemtype n;
	DeQueue( L, n );
	cout << "³ö¶ÓÁÐ" << n << endl;
	PrintQueue( L );
}