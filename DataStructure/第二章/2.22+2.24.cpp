#include "2.h"
using namespace std;

void NodeInit( LinkList & L , int InitLength)
{
	L = new LNode;
	LinkList p = L;

	for(int i = 0; i < InitLength - 1; i++)
	{
		cin >> p->data;
		p->next = new LNode;
		p = p->next;
	}
	cin >> p->data;
}

void NodePrint( LinkList const &Node )
{
	LinkList i;
	for(i = Node; i; i = i->next)
	{
		cout << i->data << " ";
	}
	cout << endl;
}

LinkList NodeInvers( LinkList & L )
{
	LinkList result = NULL, p = L, q = NULL;
	while(p)
	{
		q = p->next;
		p->next = result;
		result = p;
		p = q;
	}
	return result;
}

LinkList NodeMergeInvers( LinkList &A, LinkList &B )
{
	LinkList result = NULL, pa = A, pb = B;
	LinkList qa = NULL, qb = NULL;
	//¶Ô±È½×¶Î
	while(pa && pb)
	{
		if(pa->data < pb->data)
		{
			qa = pa->next;
			pa->next = result;
			result = pa;
			pa = qa;
		}
		else
		{
			qb = pb->next;
			pb->next = result;
			result = pb;
			pb = qb;
		}
	}
	//ÊÕÎ²½×¶Î
	if(pa)
	{
		while(qa)
		{
			qa = pa->next;
			pa->next = result;
			result = pa;
			pa = qa;
		}
	}
	else
	{
		while(qb)
		{
			qb = pb->next;
			pb->next = result;
			result = pb;
			pb = qb;
		}
	}
	return result;
}

int main( int argc, char const *argv[] )
{
	LinkList A = NULL;
	LinkList B = NULL;

	NodeInit( A, 3 );
	LinkList C = NodeInvers( A );
	NodePrint( C );
}

