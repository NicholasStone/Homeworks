//
// Created by nicholas on 15-12-30.
//

#ifndef EXPERIMENT_2_H
#define EXPERIMENT_2_H

#include <iostream>
using std::cin;
using std::cout;
using std::endl;

typedef struct PUnit{
    int    power;
    double coefficient;
	struct PUnit* next;
}PUnit, *ListPUnit;
typedef struct polynomial {	//单链表节点结构
    ListPUnit units;
    int length;
}Polynomial;

void nodeInit(LinkList &L, int initLength);

double nodeAdd(LinkList &L1, LinkList &L2, double x);

#endif //EXPERIMENT_2_H
