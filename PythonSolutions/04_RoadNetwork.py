class Road:
    def __init__(self, from_city, to_city, cost):
        self.from_city = from_city
        self.to_city = to_city
        self.cost = cost

    def __lt__(self, other):
        return self.cost < other.cost

class UnionFind:
    def __init__(self, size):
        self.parent = [i for i in range(size)]
        self.rank = [0] * size

    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def union(self, x, y):
        root_x = self.find(x)
        root_y = self.find(y)

        if root_x == root_y:
            return False

        if self.rank[root_x] > self.rank[root_y]:
            self.parent[root_y] = root_x
        elif self.rank[root_x] < self.rank[root_y]:
            self.parent[root_x] = root_y
        else:
            self.parent[root_y] = root_x
            self.rank[root_x] += 1

        return True

def main():
    import sys
    input = sys.stdin.read
    data = input().split()
    idx = 0
    T = int(data[idx])
    idx += 1
    result = []

    for _ in range(T):
        N = int(data[idx])
        M = int(data[idx + 1])
        idx += 2

        roads = []
        for _ in range(M):
            A = int(data[idx])
            B = int(data[idx + 1])
            C = int(data[idx + 2])
            roads.append(Road(A, B, C))
            idx += 3

        roads.sort()
        union_find = UnionFind(N)
        mst = []
        total_cost = 0

        for road in roads:
            if union_find.union(road.from_city, road.to_city):
                mst.append(road)
                total_cost += road.cost
                if len(mst) == N - 1:
                    break

        if len(mst) == N - 1:
            result.append(str(total_cost))
            for road in mst:
                result.append(f"{road.from_city} {road.to_city}")
        else:
            result.append("-1")

    print("\n".join(result))

if __name__ == "__main__":
    main()
