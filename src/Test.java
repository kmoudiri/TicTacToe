import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test {

    public static String[] uniqueNames(String[] names1, String[] names2) {
        Set<String> result = new HashSet<>();
        result.addAll(Arrays.asList(names1));
        result.addAll(Arrays.asList(names2));
        String[] strings = result.toArray(new String[0]);
        Arrays.sort(strings);
        return strings;
    }

    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", Test.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}