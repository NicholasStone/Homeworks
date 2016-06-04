#ifndef __QUEUE_H__
#define __QUEUE_H__

#define MAXQSIZE 100
#define OK 1
#define ERROR 0
#define OVERFLOW -1

typedef int QElemType;
typedef struct
{
	QElemType *base;
	int front;
	int rear;
}SqQueue;

int InitQueue(SqQueue &Q);
int QueueLength(SqQueue Q);
int EnQueue(SqQueue &Q, QElemType e);
int DeQueue(SqQueue &Q, QElemType &e);
int QueueEmpty(SqQueue Q);
#endif // !__QUEUE_H__
