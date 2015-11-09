#include<iostream>
#include<string>
#include<map>

using namespace std;
enum Event { ����, ����, ����, ��Զ, Ǧ�� };
enum Sex { ��, Ů, ALL_SEX };
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
	//���ͳ�ƽ�� ��һ����ΪѧУ�� �ڶ�����Ϊ�Ա� Ĭ��ΪNULL
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
 * �������������������
 * @param sch ѧУ��
 * @param s   �Ա�
 */
void Statistics::SingleSummary(string sch = "ALL_SCHOOL", string s = "ALL_SEX")
{
	//ת���ַ���Ϊ��Ӧ��ö������
	str2enum(sch, s);
	//����У��ѡ����
	Statistics::rowsBySchool();
	//������ѡ�����ͳ����Ů�ܷ� 
	Statistics::goalBySex();
	//���
	cout << _school << "��" << _sex << "�ܷ�Ϊ" << _goals[_sex] << endl;
}

void Statistics::Summary()
{
	for (_school = A; _school <= ALL_SCHOOL; _school = (School)(_school + 1))
	{
		cout << _school << "�� ";
		Statistics::rowsBySchool();
		for (_sex = ��; _sex <= ALL_SEX; _sex = (Sex)(_sex + 1))
		{
			Statistics::goalBySex();
			cout << _sex << "�ɼ�Ϊ" << _goals[_sex] << " ";
		}
		cout << endl;
	}
}

/**
 * �������������ѡ����
 * �޸ĳ�Ա����rowsSeleted��������Ҫ�����Ӧ������Ϊtrue
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
 * ���ݳ�Ա����rowsSeleted���Ա�ӷ�
 * ѧ����Ա����goals
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
		_goals[��] = 0;
		_goals[Ů] = 0;
		for (int i = 0; i < ROW_SIZE; i++)
		{
			if (_rowsSeleted[i])
			{
				if (_table[i].sex == ��)
				{
					_goals[��] += _table[i].goal;
				}
				else
				{
					_goals[Ů] += _table[i].goal;
				}
			}
		}
	}
}

/**
 * ��д����� �����ö������School
 */
ostream &operator<<(ostream &output, School &school)
{
	switch (school)
	{
	case A:
		output << "AѧУ";
		break;
	case B:
		output << "BѧУ";
		break;
	case C:
		output << "CѧУ";
		break;
	case D:
		output << "DѧУ";
		break;
	case E:
		output << "EѧУ";
		break;
	default:
		output << "����ѧУ";
		break;
	}
	return output;
}

/**
* ��д����� �����ö������Sex
*/
ostream &operator<<(ostream &output, Sex &sex)
{
	switch (sex)
	{
	case ��:
		output << "����";
		break;
	case Ů:
		output << "Ů��";
		break;
	default:
		output << "����";
		break;
	}
	return output;
}

/**
 * ���ַ���ת��Ϊö������
 * @param school ѧУ��
 * @param sex    �Ա�
 */
void Statistics::str2enum(string school, string sex)
{
	//Ϊ�˽���ַ���תö�����͵����⣬�����ٶ�Ȼ��ѧ��֮����д
	map<string, School> m;
	m["A"] = A;
	m["B"] = B;
	m["C"] = C;
	m["D"] = D;
	m["E"] = E;
	m["ALL_SCHOOL"] = ALL_SCHOOL;

	map<string, Sex> s;
	s["��"] = ��;
	s["Ů"] = Ů;
	s["ALL_SEX"] = ALL_SEX;

	if (m.find(school) != m.end())
	{
		_school = m[school];
	}
	else
	{
		cout << "������ѧУ'" << school << "'��Ĭ��Ϊ����ѧУ" << endl << endl;
		_school = ALL_SCHOOL;
	}

	if (s.find(sex) != s.end())
	{
		_sex = s[sex];
	}
	else
	{
		cout << "������'" << sex << "'�Ա����ͣ�Ĭ��Ϊ�����Ա�" << endl << endl;
		_sex = ALL_SEX;
	}
}

int main(int argc, char const *argv[])
{
	string school;
	string sex;
	rows table[ROW_SIZE] = {
		{ ����,��,A,"3'10s",4 },
		{ ����,Ů,A,"3'25s",3 },
		{ ����,��,B,"3'45s",1 },
		{ ����,Ů,B,"3'33s",2 },
		{ ����,��,C,"3'22s",3 },
		{ ����,Ů,C,"3'17s",2 },
		{ ����,��,D,"3'16s",2 },
		{ ����,Ů,D,"3'13s",1 },
		{ ����,��,E,"3'06s",5 },
		{ ����,Ů,E,"3'28s",3 },

		{ ����,��,A,"11.05",5 },
		{ ����,Ů,A,"12.33",4 },
		{ ����,��,B,"13.76",2 },
		{ ����,Ů,B,"12.12",5 },
		{ ����,��,C,"12.61",2 },
		{ ����,Ů,C,"12.22",4 },
		{ ����,��,D,"12.43",3 },
		{ ����,Ů,D,"12.01",5 },
		{ ����,��,E,"12.32",4 },
		{ ����,Ů,E,"12.15",5 },

		{ ����,��,A,"2m12",5 },
		{ ����,Ů,A,"1m93",5 },
		{ ����,��,B,"1m55",1 },
		{ ����,Ů,B,"1m64",2 },
		{ ����,��,C,"1m77",3 },
		{ ����,Ů,C,"1m70",3 },
		{ ����,��,D,"1m76",3 },
		{ ����,Ů,D,"1m89",4 },
		{ ����,��,E,"1m92",5 },
		{ ����,Ů,E,"1m73",3 },

		{ ��Զ,��,A,"7m13",1 },
		{ ��Զ,Ů,A,"7m22",2 },
		{ ��Զ,��,B,"7m43",4 },
		{ ��Զ,Ů,B,"7m51",5 },
		{ ��Զ,��,C,"7m42",4 },
		{ ��Զ,Ů,C,"7m57",5 },
		{ ��Զ,��,D,"7m32",3 },
		{ ��Զ,Ů,D,"7m12",1 },
		{ ��Զ,��,E,"7m41",4 },
		{ ��Զ,Ů,E,"7m34",3 },

		{ Ǧ��,��,A,"16.59",4 },
		{ Ǧ��,Ů,A,"17.68",5 },
		{ Ǧ��,��,B,"15.55",3 },
		{ Ǧ��,Ů,B,"13.67",1 },
		{ Ǧ��,��,C,"15.74",3 },
		{ Ǧ��,Ů,C,"14.91",2 },
		{ Ǧ��,��,D,"16.53",4 },
		{ Ǧ��,Ů,D,"17.68",5 },
		{ Ǧ��,��,E,"15.41",3 },
		{ Ǧ��,Ů,E,"17.93",5 }

	};
	Statistics summary(table);
	cout << "����1>���ܱ�" << endl;
	summary.Summary();
	cout << endl;
	cout << "����2>�����������:" << endl;
	cout << "������ѧУ��(A,B,C,D,E,ALL_SCHOOL):" << endl;
	cin >> school;
	cout << "�������Ա�(��,Ů,ALL_SEX):" << endl;
	cin >> sex;
	summary.SingleSummary("C","��");


	return 0;
}