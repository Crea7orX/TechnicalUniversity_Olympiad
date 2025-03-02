import sys

def main():
    input = sys.stdin.read
    data = input().splitlines()
    T = int(data[0])
    result = []

    for i in range(1, T + 1):
        s = data[i].strip()
        if is_valid(s):
            result.append("Valid")
        else:
            result.append("Invalid")

    print("\n".join(result))

def is_valid(s):
    stack = []
    for c in s:
        if c in '([{':
            stack.append(c)
        else:
            if not stack:
                return False
            top = stack.pop()
            if not is_matching_pair(top, c):
                return False
    return not stack

def is_matching_pair(opening, closing):
    return (opening == '(' and closing == ')') or \
           (opening == '[' and closing == ']') or \
           (opening == '{' and closing == '}')

if __name__ == "__main__":
    main()
