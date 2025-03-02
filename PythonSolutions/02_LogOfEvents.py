def is_valid(s):
    stack = []

    for ch in s:
        if ch == '(':
            stack.append(ch)
        elif ch == ')':
            if not stack:
                return False
            stack.pop()

    return not stack

def main():
    T = int(input().strip())
    result = []

    for _ in range(T):
        input_line = input().strip()
        if is_valid(input_line):
            result.append("Valid")
        else:
            result.append("Invalid")

    print("\n".join(result))

if __name__ == "__main__":
    main()
