#include "2.h"

int LENGTH(LinkList & list)
{
	int Length = 0;
	for(LNode *i = list; i->next; i = i->next)
	{
		Length++;
	}

	return Length;
}