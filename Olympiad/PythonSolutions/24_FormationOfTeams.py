import sys
from itertools import combinations

def main():
    input = sys.stdin.read
    data = input().splitlines()
    idx = 0
    n, k = map(int, data[idx].split())
    idx += 1

    employees = []
    for _ in range(n):
        employees.append(data[idx])
        idx += 1

    employees.sort()

    combinations_list = list(combinations(employees, k))

    for combination in combinations_list:
        print("".join(combination))

if __name__ == "__main__":
    main()
