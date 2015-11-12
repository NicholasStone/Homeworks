#include<iostream>

void test( int &sum ){
	typedef struct node{
		int value;
		struct node * next;
	}Node;

	Node *p, *L = NULL;
	do
	{
		p = new Node;
		std::cin >> p->value;
		p->next = L;
		L = p;
	} while(L->value);

	sum = 0;
	
	do{
		p = L;
		sum += p->value;
		std::cout << sum << std::endl;
		L = p->next;
		delete p;
	} while(L);
}

int main( int argc, char const *argv[] )
{
	int sum;
	test( sum );
	return 0;
}