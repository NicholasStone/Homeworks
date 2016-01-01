//
// Created by nicholas on 15-12-30.
//

#ifndef EXPERIMENT_2_H
#define EXPERIMENT_2_H

#include <iostream>
#include <cmath>
using std::cin;
using std::cout;
using std::endl;

typedef struct PUnit{
    int    power = 0;
    double coefficient = 0;
	struct PUnit* next = NULL;
}PUnit, *ListPUnit;
typedef struct polynomial {	//单链表节点结构
	ListPUnit units = NULL;
    int length = 0;
}Polynomial;

void polynomialInit(Polynomial &P, int initLength);

double polynomialAdd(Polynomial &L1, Polynomial &L2, double x);

void polynomialPrint(Polynomial &p);
#endif //EXPERIMENT_2_H
