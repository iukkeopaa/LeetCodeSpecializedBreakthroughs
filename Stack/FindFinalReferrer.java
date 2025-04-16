import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FindFinalReferrer {
    // 栈实现的查找最终推荐人方法
    public static String findFinalReferrerWithStack(Map<String, String> referralDict, String user) {
        Stack<String> stack = new Stack<>();
        String currentUser = user;

        while (referralDict.containsKey(currentUser)) {
            stack.push(currentUser);
            currentUser = referralDict.get(currentUser);
        }
        return currentUser;
    }

    // 递归实现的查找最终推荐人方法
    public static String findFinalReferrerRecursive(Map<String, String> referralDict, String user) {
        if (!referralDict.containsKey(user)) {
            return user;
        }
        return findFinalReferrerRecursive(referralDict, referralDict.get(user));
    }

    public static void main(String[] args) {
        // 示例推荐关系字典
        Map<String, String> referralDict = new HashMap<>();
        referralDict.put("user1", "user2");
        referralDict.put("user2", "user3");
        referralDict.put("user3", "user4");
        referralDict.put("user5", "user6");

        // 查找 user1 的最终推荐人（栈实现）
        String finalReferrerWithStack = findFinalReferrerWithStack(referralDict, "user1");
        System.out.println("user1 的最终推荐人（栈实现）是: " + finalReferrerWithStack);

        // 查找 user1 的最终推荐人（递归实现）
        String finalReferrerRecursive = findFinalReferrerRecursive(referralDict, "user1");
        System.out.println("user1 的最终推荐人（递归实现）是: " + finalReferrerRecursive);
    }
}    