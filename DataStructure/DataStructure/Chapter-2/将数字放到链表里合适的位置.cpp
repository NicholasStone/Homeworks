void NodeInsert(Node *node, Node * Head)
{
	Node * p = Head->next;
	//链表为空
	if(!p)
	{
		Head->next = node;
		return;
	}
	//中间值
	Node * q = Head;
	for(;p->next;p = p->next, q = q->next)
	{
		if(p->value > node->value)
		{
			node->next = q->next;
			q->next = node;
			return;
		}
	}
	//最后一个
	if(p->value > node->value){
		node->next = q->next;
		q->next = node;
	}
	else{
		p->next = node;
	}
}

