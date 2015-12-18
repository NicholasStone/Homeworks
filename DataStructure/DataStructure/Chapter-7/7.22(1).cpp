bool DFSFind(Graph G, int v, InfoType *c){
    bool flag = false;
    visited[v] = true;
    if(G.vertices[v].data == *c){
        flag = true;
    }else{
        for(w = FirstAdjVex(G, v); w >= 0; w = NextAdjVex(G, v, w)){
            if (!visited[w])
            {
                flag = DFSFind(G, w ,c);
            }
        }
    }
    return flag;
}