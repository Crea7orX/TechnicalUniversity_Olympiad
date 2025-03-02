import sys
import heapq

def main():
    input = sys.stdin.read
    data = input().splitlines()
    idx = 0
    T = int(data[idx])
    idx += 1
    result = []

    for _ in range(T):
        S, L, M = map(int, data[idx].split())
        idx += 1

        adj = [[] for _ in range(S + 1)]
        max_cost = 0

        for _ in range(L):
            x, y, c, t = map(int, data[idx].split())
            adj[x].append((y, c, t))
            adj[y].append((x, c, t))
            max_cost = max(max_cost, c)
            idx += 1

        low, high = 1, max_cost
        final_result = 0

        while low <= high:
            mid = (low + high) // 2
            if can_reach(S, M, adj, mid):
                final_result = mid
                high = mid - 1
            else:
                low = mid + 1

        result.append(str(final_result))

    print("\n".join(result))

def can_reach(S, M, adj, max_cost):
    dist = [float('inf')] * (S + 1)
    dist[1] = 0

    pq = []
    heapq.heappush(pq, (0, 1))

    while pq:
        time, u = heapq.heappop(pq)

        if u == S:
            return time <= M

        if time > dist[u]:
            continue

        for v, c, t in adj[u]:
            if c <= max_cost:
                new_time = time + t
                if new_time < dist[v]:
                    dist[v] = new_time
                    heapq.heappush(pq, (new_time, v))

    return dist[S] <= M

if __name__ == "__main__":
    main()
