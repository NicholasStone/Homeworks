def main():
    with open('number.txt', 'r') as f:
        number = f.readline()
    print(number_rec(number))


def number_rec(number: str):
    w = p = j = 0
    e = 1
    number_iter = iter(number)
    d = str(number[0])
    if not d.isdigit():
        raise ValueError("Not Number Line 12")

    for d in number_iter:
        if not d.isdigit():
            break
        else:
            w = w * 10 + int(d)
    if d == ".":
        d = next(number_iter)
        if not d.isdigit():
            raise ValueError("Not Number Line 19")
        else:
            w = w * 10 + int(d)
            j += 1
        for d in number_iter:
            if not d.isdigit():
                break
            else:
                w = w * 10 + int(d)
                j += 1
    if d == "E" or d == "e":
        d = next(number_iter)
        if d == "-":
            e = -1
            d = next(number_iter)
        if d == "+":
            d = next(number_iter)
        if not d.isdigit():
            raise ValueError("Not number Line 36")
        else:
            p = p * 10 + int(d)
            for d in number_iter:
                if not d.isdigit():
                    break
                else:
                    p = p * 10 + int(d)
    return w * pow(10, e * p - j)


if __name__ == '__main__':
    main()
