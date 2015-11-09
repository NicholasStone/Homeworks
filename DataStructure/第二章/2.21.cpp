#include "2.h"

void ListInverse( SqList & Sq )
{
	ElemType tmp = 0;
	for(int i = 0; i < Sq.length / 2; i++)
	{
		tmp = Sq.elem[ i ];
		Sq.elem[ i ] = Sq.elem[ Sq.length - i - 1 ];
		Sq.elem[ Sq.length - i - 1 ] = tmp;
	}
}