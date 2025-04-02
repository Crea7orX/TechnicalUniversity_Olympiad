package RoadNetwork_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoadNetwork {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String[] input = reader.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input[0]); // number of cities
            int M = Integer.parseInt(input[1]); // number of possible roads

            Road[] roads = new Road[M];
            for (int m = 0; m < M; m++) {
                String[] roadsInput = reader.readLine().trim().split("\\s+");
                int A = Integer.parseInt(roadsInput[0]); // first city
                int B = Integer.parseInt(roadsInput[1]); // second city
                int C = Integer.parseInt(roadsInput[2]); // road costs

                roads[m] = new Road(A, B, C);
            }

            Arrays.sort(roads); // sort by cost

            UnionFind unionFind = new UnionFind(N);
            List<Road> minimumSpanningTree = new ArrayList<>();
            int totalCost = 0;

            for (Road road : roads) {
                if (unionFind.union(road.from, road.to)) {
                    minimumSpanningTree.add(road);
                    totalCost += road.cost;
                    if (minimumSpanningTree.size() == N - 1) {
                        break;
                    }
                }
            }

            if (minimumSpanningTree.size() == N - 1) {
                result.append(totalCost).append("\n");
                for (Road road : minimumSpanningTree) {
                    result.append(road.from).append(" ").append(road.to).append("\n");
                }
            } else {
                result.append(-1).append("\n");
            }
        }

        System.out.print(result);
    }

    private static class Road implements Comparable<Road> {
        public int from, to, cost;

        public Road(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Road other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    private static class UnionFind {
        public int[] parent, rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return false;
            }

            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }

            return true;
        }
    }
}
