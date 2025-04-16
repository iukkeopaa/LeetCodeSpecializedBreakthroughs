import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindCommonStrings {
    public static List<String> findCommonStrings(String[] arr1, String[] arr2) {
        Set<String> hashSet = new HashSet<>();
        for (String s : arr1) {
            hashSet.add(s);
        }

        List<String> commonStrings = new ArrayList<>();
        for (String s : arr2) {
            if (hashSet.contains(s)) {
                commonStrings.add(s);
            }
        }

        return commonStrings;
    }

    public static void main(String[] args) {
        String[] arr1 = {"string1", "string2", "string3"};  // 假设这里有大约 10 万条字符串
        String[] arr2 = {"string2", "string4", "string5"};  // 假设这里有大约 10 万条字符串

        List<String> result = findCommonStrings(arr1, arr2);
        System.out.println(result);
    }
}