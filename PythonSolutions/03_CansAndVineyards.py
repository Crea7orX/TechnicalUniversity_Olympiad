def is_even(N):
    return N % 2 == 0

def main():
    T = int(input().strip())
    result = []

    for _ in range(T):
        N = int(input().strip())
        third = N // 3
        half = N // 2
        total_cans = third * 2 + half

        if not is_even(N):
            total_cans -= 1

        remaining_cans = total_cans // 2
        total = N + remaining_cans
        result.append(str(total))

    print("\n".join(result))

if __name__ == "__main__":
    main()
