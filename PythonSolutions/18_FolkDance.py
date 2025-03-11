import sys

def main():
    input_data = sys.stdin.read().strip().splitlines()
        t = int(input_data[0])
        results = []
        for i in range(1, t+1):
            s = input_data[i].strip()
            results.append(str(count_valid_splits(s)))
        sys.stdout.write("\n".join(results))

    def count_valid_splits(s: str) -> int:
        n = len(s)
        if s.count('(') != s.count(')'):
            return 0
        prefix = 0
        min_prefix = 0
        valid_positions = 0
        prefix_sums = [0] * (n + 1)
        for i in range(n):
            prefix += 1 if s[i] == '(' else -1
            prefix_sums[i+1] = prefix
            if prefix < min_prefix:
                min_prefix = prefix
        for i in range(n):
            if prefix_sums[i] == min_prefix:
                valid_positions += 1
        return valid_positions

if __name__ == "__main__":
    main()
