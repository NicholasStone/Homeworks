// 熟悉使用二分法、迭代法、牛顿法、割线法等方法对给定的方程进行根的求解。
// 至少选择上述方法中的一种算法（可选多种算法进行对比）求方程：f(x)=x3+4x2-10=0在[1,2]内的一个实根，且要求满足精度|x*-xn|<0.5×10-5
#include <iostream>
#include <cmath>
#define F(x) (x*x*x+4*x*x-10)
using namespace std;
// x -> xn
// y -> xn-1
// result -> xn+1
// e -> Eplison
double secandMethod(double x, double y, double e) {
	if (abs(x - y) < e)
		return x;
	double result = x - (F(x) / (F(x) - F(y))) * (x - y);
	return secandMethod(result, x, e);
}

int main(int argc, char const *argv[])
{
	cout.precision(6);
	cout.setf(ios::fixed);
	cout << secandMethod(2.0, 1.0, 0.5E-5) << endl;
	return 0;
}