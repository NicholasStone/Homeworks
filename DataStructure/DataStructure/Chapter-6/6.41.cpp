Statue preOrderAtIndex(BiTree *tree, int &index,const int num,State (*visit)(TElemType e)){
    if(tree){
        if(num == index){
            return visit(tree->data);
        }
    }else{
        return;
    }
    preOrderAtIndex( tree->lchild, ++index, num, visit);
    preOrderAtIndex( tree->rchold, ++index, num, visit);
}