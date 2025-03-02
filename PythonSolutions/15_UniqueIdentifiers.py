def main():
    import sys
    input = sys.stdin.read
    data = input().splitlines()
    
    idx = 0
    T = int(data[idx].strip())
    idx += 1
    result = []

    for _ in range(T):
        N = int(data[idx].strip())
        idx += 1

        name_to_id = {}
        id_to_name = {}
        current_id = 0

        for _ in range(N):
            name = data[idx].strip()
            idx += 1

            if name not in name_to_id:
                name_to_id[name] = current_id
                id_to_name[current_id] = name
                current_id += 1

        Q = int(data[idx].strip())
        idx += 1

        for _ in range(Q):
            query = data[idx].strip()
            idx += 1

            if query.isdigit():
                _id = int(query)
                result.append(id_to_name.get(_id, "") + "\n")
            else:
                result.append(str(name_to_id.get(query, "")) + "\n")

    print("".join(result), end="")

if __name__ == "__main__":
    main()
