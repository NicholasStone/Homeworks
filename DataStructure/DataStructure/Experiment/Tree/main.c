#include <stdio.h>
#include <stdlib.h>

#define OK 1
#define OVERFLOW -1
typedef int TElemType;
typedef int TElemType;
typedef struct BiTNode { //结点结构
	TElemType data;
	struct BiTNode *lchild, *rchild;    //左右孩子指针
} BiTNode, *BiTree;

int PrintElement(TElemType e) {
	printf("%c ", e);
	return OK;
}

int (*Visit)(TElemType);

int CreateBiTree(BiTree & T) {
	TElemType ch;
	scanf("%c", &ch);
	if (ch == '.') T = NULL;
	else {
		if (!(T = (BiTNode *) malloc(sizeof(BiTNode)))) exit(OVERFLOW);
		T->data = ch;              // 生成根结点
		CreateBiTree(T->lchild);// 构造左子树
		CreateBiTree(T->rchild);// 构造右子树
	}
	return OK;
}   //CreateBiTree

//后序遍历二叉树(递归)
void PostOrderTraverse(BiTree & T,

		int (*Visit)(TElemType e)

) {
	if (T) {
		PostOrderTraverse(T
				->lchild, Visit);    //后序遍历左子树
		PostOrderTraverse(T
				->rchild, Visit);//后序遍历右子树
		Visit(T
				->data);//访问根结点
	}
}    //PostOrderTraverse

int main(int argc, char *argv[]) {

	BiTree T;    //declaration

	printf("\nInput a tree : \n");
	//用例:ABD..EH...CF.I..G..\n
	CreateBiTree(T);    //创建

	printf("\nPostOrderTraverse : ");
	Visit = &PrintElement;
	PostOrderTraverse(T, Visit);    //后序 遍历

	printf("\n");
	return 0;
}
