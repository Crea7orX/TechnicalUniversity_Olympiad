def print_set(s, result):
    if not s:
        result.append("")
    else:
        sorted_list = sorted(s)
        result.append(" ".join(map(str, sorted_list)))

def main():
    import sys
    input = sys.stdin.read
    data = input().split()
    idx = 0
    T = int(data[idx])
    idx += 1
    result = []

    for _ in range(T):
        N1 = int(data[idx])
        N2 = int(data[idx + 1])
        idx += 2

        student1_courses = set(map(int, data[idx:idx + N1]))
        idx += N1

        student2_courses = set(map(int, data[idx:idx + N2]))
        idx += N2

        all_courses = student1_courses.union(student2_courses)
        print_set(all_courses, result)

        common_courses = student1_courses.intersection(student2_courses)
        print_set(common_courses, result)

        only_student1_courses = student1_courses.difference(student2_courses)
        print_set(only_student1_courses, result)

        symmetric_diff = student1_courses.symmetric_difference(student2_courses)
        print_set(symmetric_diff, result)

    for line in result:
        print(line)

if __name__ == "__main__":
    main()
