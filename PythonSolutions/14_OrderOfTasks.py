def factorial(n):
    if n == 0 or n == 1:
        return 1
    return n * factorial(n - 1)

def find_permutation_rank(tasks, n, k):
    available_tasks = list(range(n))
    rank = 1

    for i in range(k):
        current_task = tasks[i]
        index = available_tasks.index(current_task)
        rank += index * factorial(n - 1 - i)
        available_tasks.pop(index)

    return rank

def main():
    import sys
    input = sys.stdin.read
    data = input().split()
    idx = 0
    T = int(data[idx])
    idx += 1
    result = []

    for _ in range(T):
        n = int(data[idx])
        k = int(data[idx + 1])
        idx += 2

        tasks = list(map(int, data[idx:idx + k]))
        idx += k

        rank = find_permutation_rank(tasks, n, k)
        result.append(str(rank))

    print("\n".join(result))

if __name__ == "__main__":
    main()
