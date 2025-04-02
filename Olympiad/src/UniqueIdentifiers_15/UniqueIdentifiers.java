package UniqueIdentifiers_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class UniqueIdentifiers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(reader.readLine().trim());

            Map<String, Integer> nameToId = new HashMap<>();
            Map<Integer, String> idToName = new HashMap<>();

            int id = 0;
            for (int i = 0; i < N; i++) {
                String name = reader.readLine().trim();

                if (nameToId.containsKey(name)) {
                    continue;
                }

                nameToId.put(name, id);
                idToName.put(id, name);
                id++;
            }

            int Q = Integer.parseInt(reader.readLine().trim());

            for (int i = 0; i < Q; i++) {
                String query = reader.readLine().trim();

                if (query.matches("\\d+")) {
                    int _id = Integer.parseInt(query);
                    result.append(idToName.get(_id)).append("\n");
                } else {
                    result.append(nameToId.get(query)).append("\n");
                }
            }
        }

        System.out.print(result);
    }
}
