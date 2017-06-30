

def main():
    with open("expression.txt", "r") as f:
        expression = f.readline()
    try:
        notation = reverse_polish_notation(expression)
    except Exception as e:
        print(e)
    else:
        print(" ".join(notation))


def reverse_polish_notation(expression: str) -> list:
    output_queue = []
    """输出队列"""
    op_stack = []
    """操作符栈"""

    l = len(expression)
    i = 0
    while i < l:
        if str(expression[i]) == " ":
            """忽略空格"""
            continue
        if expression[i].isdigit() or expression[i] == '.':
            """如果是数字则直接放入输出队列"""
            digit = []
            dot_flag = 0
            while expression[i].isdigit() or expression[i] == '.':
                if expression[i] == '.':
                    dot_flag += 1
                if dot_flag > 1:
                    raise ValueError("多余的小数点")
                digit.append(expression[i])
                i += 1
            i -= 1
            output_queue.append("".join(digit))
        elif is_operator(expression[i]):
            """
            如果是操作符则根据优先级进行出入栈操作
            令读入操作符为 O1,栈顶操作符为 O2,当有:
                1.O1 为左结合性且其运算优先级要小于或等于 O2 的
                2.O1 为右结合性且运算优先级小于 O2
            时,将 O2 从栈顶弹出放入输出队列中
            然后将 O1 入栈
            """
            while len(op_stack) > 0:
                top = op_stack[len(op_stack) - 1]
                is_left_assoc = left_assoc(expression[i])
                if (is_left_assoc and (op_precedence(expression[i]) <= op_precedence(top))) \
                        or ((not is_left_assoc) and (op_precedence(expression[i]) < op_precedence(top))):
                    output_queue.append(op_stack.pop())
                else:
                    break
            op_stack.append(expression[i])
        elif str(expression[i]) == "(":
            """读入字符若为左括号则直接入栈"""
            op_stack.append(expression[i])
        elif str(expression[i]) == ")":
            """读入字符为右括号时将栈顶弹出放入输出队列,直到遇到左括号.将左括号弹出但不放入序列,若没有则抛出异常"""
            try:
                while True:
                    s = op_stack.pop()
                    if str(s) != "(":
                        output_queue.append(s)
                    else:
                        break
            except IndexError:
                raise Exception("括号不匹配:缺少左括号")
        else:
            """读入其他字符抛出异常"""
            raise ValueError("未知的字符:" + expression[i])
        i += 1

    while len(op_stack) > 0:
        """将操作符栈中剩余操作符弹出放入输出队列,若遇到 '(' 或 ')' 则说明有异常的括号"""
        op = op_stack.pop()
        if str(op) == "(" or str(op) == ")":
            raise Exception("括号不匹配:多余的括号")
        output_queue.append(op)
    return output_queue


def op_precedence(op: str) -> int:
    if op == "+" or op == "-":
        return 1
    elif op == "*" or op == "/":
        return 2
    elif op == "^":
        return 3
    else:
        return 0


def is_operator(c: str) -> bool:
    operators = ("+", "-", "*", "/", "^")
    try:
        operators.index(c)
    except ValueError:
        return False
    else:
        return True


def left_assoc(c: str) -> bool:
    left_assoc_operator = ("+", "-", "*", "/")
    try:
        left_assoc_operator.index(c)
    except ValueError:
        return False
    else:
        return True


if __name__ == '__main__':
    main()
