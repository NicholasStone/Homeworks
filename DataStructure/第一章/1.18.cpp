#include<iostream>
#include<string>
#include<map>

using namespace std;
enum Event { 长跑, 短跑, 跳高, 跳远, 铅球 };
enum Sex { 男, 女, ALL_SEX };
enum School { A, B, C, D, E, ALL_SCHOOL };
const int ROW_SIZE = 50;
typedef struct
{
	Event name;
	Sex sex;
	School school;
	string score;
	int goal;
} rows;

class Statistics
{
public:
	Statistics(rows *);
	~Statistics();
	//输出统计结果 第一参数为学校名 第二参数为性别 默认为NULL
	void SingleSummary(string school, string sex);
	void Summary();
protected:
	School _school = ALL_SCHOOL;
	Sex _sex = ALL_SEX;
	const rows *_table;
	bool _rowsSeleted[ROW_SIZE];
	int _goals[3];

	void rowsBySchool();
	void goalBySex();
	friend ostream &operator<<(ostream &, School &);
	friend ostream &operator<<(ostream &, Sex &);
	void str2enum(string school, string sex);
};

Statistics::Statistics(rows *table) :_table(table)
{
	for (int i = 0; i < ROW_SIZE; i++)
	{
		_rowsSeleted[i] = true;
	}
}

Statistics::~Statistics() {}

/**
 * 根据输入的数据输出结果
 * @param sch 学校名
 * @param s   性别
 */
void Statistics::SingleSummary(string sch = "ALL_SCHOOL", string s = "ALL_SEX")
{
	//转换字符串为对应的枚举类型
	str2enum(sch, s);
	//根据校名选择行
	Statistics::rowsBySchool();
	//根据已选择的列统计男女总分 
	Statistics::goalBySex();
	//输出
	cout << _school << "的" << _sex << "总分为" << _goals[_sex] << endl;
}

void Statistics::Summary()
{
	for (_school = A; _school <= ALL_SCHOOL; _school = (School)(_school + 1))
	{
		cout << _school << "中 ";
		Statistics::rowsBySchool();
		for (_sex = 男; _sex <= ALL_SEX; _sex = (Sex)(_sex + 1))
		{
			Statistics::goalBySex();
			cout << _sex << "成绩为" << _goals[_sex] << " ";
		}
		cout << endl;
	}
}

/**
 * 根据输入的数据选择行
 * 修改成员数组rowsSeleted，若符合要求则对应的列数为true
 */
void Statistics::rowsBySchool()
{
	for (int i = 0; i < ROW_SIZE; i++)
	{
		_rowsSeleted[i] = true;
	}
	if (_school != ALL_SCHOOL)
	{
		for (int i = 0; i < ROW_SIZE; i++)
		{
			if (_table[i].school != _school)
			{
				_rowsSeleted[i] = false;
			}
		}
	}
}

/**
 * 根据成员数组rowsSeleted和性别加分
 * 学过成员数组goals
 */
void Statistics::goalBySex()
{
	if (_sex == ALL_SEX)
	{
		for (int i = 0; i < ROW_SIZE; i++)
		{
			if (_rowsSeleted[i])
			{
				_goals[ALL_SEX] += _table[i].goal;
			}
		}
	}
	else
	{
		_goals[男] = 0;
		_goals[女] = 0;
		for (int i = 0; i < ROW_SIZE; i++)
		{
			if (_rowsSeleted[i])
			{
				if (_table[i].sex == 男)
				{
					_goals[男] += _table[i].goal;
				}
				else
				{
					_goals[女] += _table[i].goal;
				}
			}
		}
	}
}

/**
 * 重写运算符 以输出枚举类型School
 */
ostream &operator<<(ostream &output, School &school)
{
	switch (school)
	{
	case A:
		output << "A学校";
		break;
	case B:
		output << "B学校";
		break;
	case C:
		output << "C学校";
		break;
	case D:
		output << "D学校";
		break;
	case E:
		output << "E学校";
		break;
	default:
		output << "所有学校";
		break;
	}
	return output;
}

/**
* 重写运算符 以输出枚举类型Sex
*/
ostream &operator<<(ostream &output, Sex &sex)
{
	switch (sex)
	{
	case 男:
		output << "男生";
		break;
	case 女:
		output << "女生";
		break;
	default:
		output << "团体";
		break;
	}
	return output;
}

/**
 * 将字符串转化为枚举类型
 * @param school 学校名
 * @param sex    性别
 */
void Statistics::str2enum(string school, string sex)
{
	//为了解决字符串转枚举类型的问题，上网百度然后学完之后所写
	map<string, School> m;
	m["A"] = A;
	m["B"] = B;
	m["C"] = C;
	m["D"] = D;
	m["E"] = E;
	m["ALL_SCHOOL"] = ALL_SCHOOL;

	map<string, Sex> s;
	s["男"] = 男;
	s["女"] = 女;
	s["ALL_SEX"] = ALL_SEX;

	if (m.find(school) != m.end())
	{
		_school = m[school];
	}
	else
	{
		cout << "不存在学校'" << school << "'，默认为所有学校" << endl << endl;
		_school = ALL_SCHOOL;
	}

	if (s.find(sex) != s.end())
	{
		_sex = s[sex];
	}
	else
	{
		cout << "不存在'" << sex << "'性别类型，默认为所有性别" << endl << endl;
		_sex = ALL_SEX;
	}
}

int main(int argc, char const *argv[])
{
	string school;
	string sex;
	rows table[ROW_SIZE] = {
		{ 长跑,男,A,"3'10s",4 },
		{ 长跑,女,A,"3'25s",3 },
		{ 长跑,男,B,"3'45s",1 },
		{ 长跑,女,B,"3'33s",2 },
		{ 长跑,男,C,"3'22s",3 },
		{ 长跑,女,C,"3'17s",2 },
		{ 长跑,男,D,"3'16s",2 },
		{ 长跑,女,D,"3'13s",1 },
		{ 长跑,男,E,"3'06s",5 },
		{ 长跑,女,E,"3'28s",3 },

		{ 短跑,男,A,"11.05",5 },
		{ 短跑,女,A,"12.33",4 },
		{ 短跑,男,B,"13.76",2 },
		{ 短跑,女,B,"12.12",5 },
		{ 短跑,男,C,"12.61",2 },
		{ 短跑,女,C,"12.22",4 },
		{ 短跑,男,D,"12.43",3 },
		{ 短跑,女,D,"12.01",5 },
		{ 短跑,男,E,"12.32",4 },
		{ 短跑,女,E,"12.15",5 },

		{ 跳高,男,A,"2m12",5 },
		{ 跳高,女,A,"1m93",5 },
		{ 跳高,男,B,"1m55",1 },
		{ 跳高,女,B,"1m64",2 },
		{ 跳高,男,C,"1m77",3 },
		{ 跳高,女,C,"1m70",3 },
		{ 跳高,男,D,"1m76",3 },
		{ 跳高,女,D,"1m89",4 },
		{ 跳高,男,E,"1m92",5 },
		{ 跳高,女,E,"1m73",3 },

		{ 跳远,男,A,"7m13",1 },
		{ 跳远,女,A,"7m22",2 },
		{ 跳远,男,B,"7m43",4 },
		{ 跳远,女,B,"7m51",5 },
		{ 跳远,男,C,"7m42",4 },
		{ 跳远,女,C,"7m57",5 },
		{ 跳远,男,D,"7m32",3 },
		{ 跳远,女,D,"7m12",1 },
		{ 跳远,男,E,"7m41",4 },
		{ 跳远,女,E,"7m34",3 },

		{ 铅球,男,A,"16.59",4 },
		{ 铅球,女,A,"17.68",5 },
		{ 铅球,男,B,"15.55",3 },
		{ 铅球,女,B,"13.67",1 },
		{ 铅球,男,C,"15.74",3 },
		{ 铅球,女,C,"14.91",2 },
		{ 铅球,男,D,"16.53",4 },
		{ 铅球,女,D,"17.68",5 },
		{ 铅球,男,E,"15.41",3 },
		{ 铅球,女,E,"17.93",5 }

	};
	Statistics summary(table);
	cout << "功能1>汇总表：" << endl;
	summary.Summary();
	cout << endl;
	cout << "功能2>根据条件输出:" << endl;
	cout << "请输入学校名(A,B,C,D,E,ALL_SCHOOL):" << endl;
	cin >> school;
	cout << "请输入性别(男,女,ALL_SEX):" << endl;
	cin >> sex;
	summary.SingleSummary("C","男");


	return 0;
}