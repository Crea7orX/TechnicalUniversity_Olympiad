import sys

def main():
    input = sys.stdin.read
    data = input().split()
    idx = 0
    T = int(data[idx])
    idx += 1
    result = []

    for _ in range(T):
        N = int(data[idx])
        idx += 1
        observations = list(map(int, data[idx:idx + N]))
        idx += N

        stack = []
        output = []
        for i in range(N):
            while stack and observations[stack[-1]] >= observations[i]:
                stack.pop()
            output.append(str(stack[-1] + 1) if stack else "0")
            stack.append(i)

        result.append(" ".join(output))

    print("\n".join(result))

if __name__ == "__main__":
    main()
