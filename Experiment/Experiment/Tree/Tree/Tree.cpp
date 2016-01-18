#include "Tree.h"
#include <stack>

using namespace std;

int PrintElement(TElemType e)
{
	//printf("%c ", e);
	cout << e;
	return OK;
}

int(*Visit)(TElemType);

int CreateBiTree(BiTree & T)
{
	TElemType ch;
	cin >> ch;
	if (ch == '.') T = NULL;
	else
	{
		T = new BiTNode;
		T->data = ch;              // 生成根结点
		CreateBiTree(T->lchild);// 构造左子树
		CreateBiTree(T->rchild);// 构造右子树
	}
	return OK;
}   //CreateBiTree

	//后序遍历二叉树(递归)
void PostOrderTraverse(BiTree & T, int(*Visit)(TElemType e))
{
	if (T)
	{
		PostOrderTraverse(T->lchild, Visit);    //后序遍历左子树
		PostOrderTraverse(T->rchild, Visit);//后序遍历右子树
		Visit(T->data);//访问根结点
	}
}    //PostOrderTraverse

void InOrderTraverse(BiTree & T, int(*Visit)(TElemType e))
{
	if (T)
	{
		InOrderTraverse(T->lchild, Visit);    //后序遍历左子树
		Visit(T->data);//访问根结点
		InOrderTraverse(T->rchild, Visit);//后序遍历右子树

	}
}    //PostOrderTraverse

void PreOrderTraverse(BiTree &T, int(*Visit)(TElemType))
{
	if (T)
	{
		Visit(T->data);//访问根结点
		PreOrderTraverse(T->lchild, Visit);    //后序遍历左子树
		PreOrderTraverse(T->rchild, Visit);//后序遍历右子树

	}
}

//////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////

int countLeaves(BiTree & T)
{
	if (!T) return 0;
	if (!(T->lchild || T->rchild)) return 1;
	return countLeaves(T->lchild) + countLeaves(T->rchild);
}

int PreOrderAtIndex(BiTree const &T, int index, int(*Visit)(TElemType))
{
	if (!T || index < 1)
		return index;

	if (index == 1)
	{
		Visit(T->data);
		return 0;
	}
	index = PreOrderAtIndex(T->lchild, --index, Visit);
	PreOrderAtIndex(T->rchild, index, Visit);
}

int countLeavesLegacy(BiTree const &T)
{
	if (!T)
	{
		return 0;
	}
	int sum = 0;
	stack<BiTree> s;
	BiTree branch = T;
	while (branch || !s.empty())
	{
		if (branch)
		{
			s.push(branch);
			branch = branch->lchild;
		}
		else
		{
			branch = s.top();
			if (!branch->lchild && !branch->rchild)
			{
				sum++;
			}
			s.pop();
			branch = branch->rchild;
		}
	}
	return sum;
}

void PreOrderAtIndexLegacy(BiTree const & T, int const index, int(*Visit)(TElemType))
{
	stack<BiTree> s;
	BiTree branch = T;
	int i = 1;
	while (branch || !s.empty())
	{
		if (i == index)
		{
			Visit(branch->data);
			break;
		}
		i++;
		s.push(branch);
		branch = branch->lchild;
		while (!branch && !s.empty())
		{
			branch = s.top();
			s.pop();
			branch = branch->rchild;
		}
	}
}

int main(int argc, char const *argv[])
{

	BiTree T;    //declaration

	cout << "Input a tree :" << endl;
	//用例:ABD..EH...CF.I..G..\n
	CreateBiTree(T);    //创建

	Visit = &PrintElement;

	PreOrderAtIndex(T, 4, Visit);
	cout << endl;
	PreOrderAtIndexLegacy(T, 4, Visit);

	cout << endl << countLeaves(T) << endl;
	cout << countLeavesLegacy(T) << endl;
	return 0;
}
