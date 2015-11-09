#include "Experiment.h"

int main(int argc, char const *argv[])
{
	char *data = "HelloWorld";
	Node node(data);
	node.Revrse();
	node.Print();
	return 0;
}