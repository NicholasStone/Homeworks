#include "7.22.h"
void VisitFunc( int v ){
	cout << v << endl;
}
void DFSTraverse( AlGraph G, void( *Visit )(int v), bool visited[]){
	Visit = VisitFunc;
	for(int v = 0; v < G.vexnum; v++){
		visited[ v ] = false;
	}
	for(int v = 0; v < G.vexnum; v++)
	{
		if(!visited[ v ]){
			DFS( G, v, visited);
		}
	}
}
void DFS( AlGraph G, int v, bool visited[] ){
	visited[ v ] = true;
	VisitFunc( v );
}