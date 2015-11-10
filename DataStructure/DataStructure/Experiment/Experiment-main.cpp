#include "Experiment.h"

int main( int argc, char const *argv[] )
{
	char *data = "HelloWorld";
	Node node( data, true );
	node.Insert( 'a', 5 );
	node.Print();
	return 0;
}