#include<stdio.h>
int number;
typedef struct
{
	int q[20];
	int f, r;
}queue;
int nodelist[20][20];
queue Q;
int z[20];
int a, b, n, i, j, x, y;
int finished;
void enq(queue *Q, int x)
{
	Q->q[Q->r] = x;
	if (Q->r == 19)   Q->r = 0;
	else      Q->r++;
	if (Q->r == Q->f) printf("Overflow!\n");
}
int front(queue *Q)
{
	if (Q->r == Q->f)  printf("Underflow!\n");
	else   return(Q->q[Q->f]);
}
void deq(queue *Q)
{
	if (Q->r == Q->f)   printf("Underflow!\n");
	else
	{
		if (Q->f == 19)  Q->f = 0;
		else     Q->f++;
	}
}
int qempty(queue Q)
{
	if (Q.f == Q.r)  return 1;
	else   return 0;
}
void readgraph()
{
	printf("\nPlease input n:");   scanf_s("%d", &n);
	printf("Please input nodelist[i][j]:\n");
	for (i = 1; i <= n; i++)
	{
		for (j = 1; j <= n; j++)  scanf_s("%d", &nodelist[i][j]);
	}
	printf("\n");    printf("List-link is bulit\n");
	for (i = 1; i <= n; i++)
	{
		for (j = 1; j <= n; j++)  printf("%3d", nodelist[i][j]);
		printf("\n");
	}
}
void shortest(int a, int b)
{
	if (a == b)  nodelist[a][a] = 2;
	else
	{
		enq(&Q, a);  nodelist[a][a] = 2; finished = 0;
		while (!qempty(Q) && !finished)
		{
			a = front(&Q);   deq(&Q);   j = 1;
			while ((j <= n) && !finished)
			{
				if ((nodelist[a][j] == 1) && (nodelist[j][j] != 2))
				{
					enq(&Q, j); nodelist[j][j] = 2;  z[j] = a;
					if (j == b) finished = 1;/*&&(nodelist[a][j]==1))*/
				}
				if (!finished)  j++;
			}
		}
		if (!finished) printf("There is no path.");
	}
}
void writepath(int a, int b)
{
	i = b;
	while (i != a) { printf("%d<-", i); i = z[i]; }
	printf("%d", a);
}
void main()
{
	readgraph();
	printf("Please input a:"); scanf_s("%d", &a);
	printf("Please input b:"); scanf_s("%d", &b);
	Q.f = 0;  Q.r = 0;  shortest(a, b);
	if (finished)  writepath(a, b);
}
