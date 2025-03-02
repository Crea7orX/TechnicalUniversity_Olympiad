import sys

def main():
    input = sys.stdin.read
    data = input().splitlines()
    idx = 0
    n, k = map(int, data[idx].split())
    idx += 1

    team = list(map(int, data[idx].split()))
    idx += 1

    result = find_lex_order(n, k, team)
    print(result)

def find_lex_order(n, k, team):
    count = 1
    for i in range(k):
        start = team[i - 1] if i > 0 else 0
        for j in range(start, team[i]):
            count += count_combinations(n, k - i - 1, j)
    return count

def count_combinations(n, k, last):
    if k == 0:
        return 1
    count = 0
    for i in range(last, n):
        count += count_combinations(n, k - 1, i)
    return count

if __name__ == "__main__":
    main()
