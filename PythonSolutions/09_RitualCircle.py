import sys

def factorial(n):
    if n == 0:
        return 1
    return n * factorial(n - 1)

def main():
    input = sys.stdin.read
    data = input().split()
    T = int(data[0])
    idx = 1
    result = []

    for _ in range(T):
        N = int(data[idx])
        idx += 1
        result.append(str(factorial(N - 1)))

    print("\n".join(result))

if __name__ == "__main__":
    main()
