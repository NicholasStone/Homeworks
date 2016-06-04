#include <iostream>

using namespace std;

int main() {
    char *data = "HelloWorld";
    Node node( data, true );
    node.Insert( 'a', 5 );
    node.Print();
    return 0;
}