package CompareCourses_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CompareCourses {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String[] input = reader.readLine().trim().split("\\s+");
            int N1 = Integer.parseInt(input[0]);
            int N2 = Integer.parseInt(input[1]);

            String[] student1CoursesInput = reader.readLine().trim().split("\\s+");
            Set<Integer> student1Courses = new HashSet<>();
            for (int i = 0; i < N1; i++) {
                student1Courses.add(Integer.parseInt(student1CoursesInput[i]));
            }

            String[] student2CoursesInput = reader.readLine().trim().split("\\s+");
            Set<Integer> student2Courses = new HashSet<>();
            for (int i = 0; i < N2; i++) {
                student2Courses.add(Integer.parseInt(student2CoursesInput[i]));
            }

            Set<Integer> allCourses = new HashSet<>(student1Courses);
            allCourses.addAll(student2Courses);
            printSet(allCourses, result);

            Set<Integer> commonCourses = new HashSet<>(student1Courses);
            commonCourses.retainAll(student2Courses);
            printSet(commonCourses, result);

            Set<Integer> onlyStudent1Courses = new HashSet<>(student1Courses);
            onlyStudent1Courses.removeAll(student2Courses);
            printSet(onlyStudent1Courses, result);

            Set<Integer> diffCourses = new HashSet<>(student1Courses);
            diffCourses.addAll(student2Courses);
            Set<Integer> symmetricDiff = new HashSet<>(diffCourses);
            symmetricDiff.removeAll(commonCourses);
            printSet(symmetricDiff, result);
        }

        System.out.print(result);
    }

    private static void printSet(Set<Integer> set, StringBuilder result) {
        if (set.isEmpty()) {
            result.append("\n");
        } else {
            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list); // Sort to print in ascending order
            for (Integer course : list) {
                result.append(course).append(" ");
            }
            result.append("\n");
        }
    }
}
