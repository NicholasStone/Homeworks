#include<iostream>

double g( double m, double n )
{
	std::cout << m << "\t" << n << std::endl;
	if(m == 0) return 0;
	return (g( m - 1, 2 * n ) + n);
}

int main( int argc, char const * argv[] )
{
	std::cout << g( 5, 2 );
}