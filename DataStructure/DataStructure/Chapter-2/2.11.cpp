#include "2.h"
using namespace std;

Status SqListInit( SqList & );
Status SqListInsert( SqList &, ElemType );
void SqListPrint( SqList & );

int main( int argc, char const *argv[] )
{
	SqList sq;
	SqListInit( sq );
	SqListInsert( sq, 75 );
	SqListPrint( sq );
	return 0;
}

Status SqListInit( SqList & Sq )
{

	Sq.elem = (ElemType*) malloc( sizeof( ElemType )*LIST_INIT_SIZE );
	if(!Sq.elem)
	{
		return LIST_OVERFLOW;
	}
	for(int i = 0; i < LIST_INIT_LENGHT; i++)
	{
		Sq.elem[ i ] = (i + 1) * 10;
	}
	Sq.length = LIST_INIT_LENGHT;
	Sq.listsize = LIST_INIT_SIZE;
	return OK;
}

Status SqListInsert( SqList & Sq, ElemType Elem )
{
	//若长度不够则自增
	if(Sq.length == Sq.listsize)
	{
		ElemType *newbase = (ElemType*) realloc( Sq.elem, sizeof( ElemType )*Sq.listsize + LISTINCREMENT );
		if(!newbase)
		{
			return LIST_OVERFLOW;
		}
		Sq.listsize += LISTINCREMENT;
	}
	ElemType p = 0;
	ElemType q = Sq.length - 1;
	//边界效应
	if(Sq.elem[ p ] > Elem)
	{
		q = p;
	}
	else if(Sq.elem[ q ] < Elem)
	{
		q = Sq.length;
	}
	else
	{
		while(q - p > 1)
		{
			ElemType mid = (p + q) / 2;
			if(Elem > Sq.elem[ mid ])
			{
				p = mid;
			}
			else
			{
				q = mid;
			}
		}
	}

	for(int i = Sq.length; i > q ; i--)
	{
		Sq.elem[ i ] = Sq.elem[ i - 1 ];
	}
	Sq.elem[ q ] = Elem;
	Sq.length++;
	return OK;
}

void SqListPrint( SqList & Sq )
{
	cout << "Size:" << Sq.listsize << endl;
	cout << "Length:" << Sq.length << endl;
	cout << "Elems:";
	for(int i = 0; i < Sq.length; i++)
	{
		cout << Sq.elem[ i ] << " ";
	}
}

