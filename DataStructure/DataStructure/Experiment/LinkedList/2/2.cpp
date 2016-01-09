//
// Created by nicholas on 15-12-30.
//
#include "2.h"

void polynomialInit(Polynomial &L, int initLength)
{
	L.units = NULL;
	L.length = initLength;
	for (int i = 0; i < initLength; ++i)
	{
		PUnit *p = new PUnit;
		cout << "Power Number:";
		cin >> p->power;
		cout << "Coefficient Number:";
		cin >> p->coefficient;
		p->next = L.units;
		L.units = p;
	}
}

void polynomialAdd(Polynomial &L1, Polynomial &L2, Polynomial &L3)
{
	int maxLength = L1.length > L2.length ? L1.length : L2.length;
	PUnit * pL1 = NULL;
	PUnit * pL2 = NULL;
	PUnit * pL3 = NULL;
	double sum = 0;
	for (int i = 0; i < maxLength; i++)
	{
		pL1 = L1.units;
		pL2 = L2.units;

		if (pL1->power > pL2->power)
		{
			L1.units = L1.units->next;
			pL1->next = L3.units;
			L3.units = pL1;
			L3.length++;
		}
		else if (pL1->power == pL2->power)
		{
			L2.units = L2.units->next;
			pL1->coefficient += pL2->coefficient;
			pL1->next = L3.units;
			L3.units = pL1;
			delete pL2;
			L3.length++;
		}
		else
		{
			L2.units = L2.units->next;
			pL2->next = L3.units;
			L3.units = pL2;
			L3.length++;
		}

	}
}

void polynomialPrint(Polynomial &p)
{
	for (PUnit * i = p.units; i; i = i->next)
	{
		cout << i->coefficient << ":" << i->power << endl;
	}
}

int main()
{

	Polynomial ha;
	Polynomial hb;
	Polynomial hc;
	polynomialInit(ha, 1);
	polynomialPrint(ha);
	polynomialInit(hb, 2);
	polynomialPrint(hb);
	polynomialAdd(ha, hb, hc);
	polynomialPrint(hc);
}

