Status SymmetryString(char const *data)
{
	Queue Q;
	if(!QueueInit(Q)){
		return ERROR;
	}
	Stack S;
	StackInit(S);
	Elemtype q,s;
	for (char *i = data; *i != '\0'; ++i)
	{
		StackPush(S, *i);
		EnQueue(Q, *i);
	}
	while(!StackEmpty(S)){
		Pop(S ,s);
		DeQueue(Q ,q);
		if(s != q){
			return NOT;
		} 
	}
}