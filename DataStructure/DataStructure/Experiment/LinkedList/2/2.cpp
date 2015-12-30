//
// Created by nicholas on 15-12-30.
//
#include "2.h"

void polynomialInit(Polynomial &L, int initLength){
    L.Units = (PUnit)malloc(sizeof(PUnit));
    L.Units = NULL;
    for (int i = 0; i < initLength; ++i) {
        ListPolynomial p;
        p = (ListPolynomial)malloc(sizeof(LPolynomial));
        scanf(&p->coefficient);
        L->next = p;
    }
}

double polynomialAdd(LinkList &L1, LinkList &L2, double x){
    int maxLengtn = L1.length > L2.length ? L1.length : L2.length;
    PUnit * pL1 = L1.units;
    PUnit * pl2 = L2.units;
    for (int i = 0; i < maxLengtn; ++i) {
    }
}

