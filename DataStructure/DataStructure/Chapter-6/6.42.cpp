int leaf(BiTree *tree){
    if(!tree) return 0;
    if(!(tree->lchild && tree->rchild)) return 1;
    return leaf(tree->lchild) + leaf(tree->rchild);
}