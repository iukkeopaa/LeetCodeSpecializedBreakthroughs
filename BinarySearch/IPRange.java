import java.util.Arrays;
import java.util.Comparator;

class IPRange {
    String startIP;
    String endIP;
    String location;

    public IPRange(String startIP, String endIP, String location) {
        this.startIP = startIP;
        this.endIP = endIP;
        this.location = location;
    }

    // 将 IP 地址转换为 32 位整数
    public static long ipToLong(String ip) {
        String[] ipParts = ip.split("\\.");
        long result = 0;
        for (int i = 0; i < 4; i++) {
            result = result << 8 | Integer.parseInt(ipParts[i]);
        }
        return result;
    }

    // 在有序数组中查找最后一个小于等于某个给定值的元素
    public static int findLastLessEqual(IPRange[] ranges, String targetIP) {
        long target = ipToLong(targetIP);
        int left = 0, right = ranges.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long start = ipToLong(ranges[mid].startIP);
            if (start <= target) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // 示例数据
        IPRange[] ranges = {
                new IPRange("192.168.1.0", "192.168.1.255", "Local Network 1"),
                new IPRange("10.0.0.0", "10.0.0.255", "Local Network 2"),
                new IPRange("172.16.0.0", "172.31.255.255", "Private Network")
        };

        // 按照起始 IP 从小到大排序
        Arrays.sort(ranges, Comparator.comparingLong(range -> ipToLong(range.startIP)));

        // 查找示例
        String targetIP = "192.168.1.100";
        int index = findLastLessEqual(ranges, targetIP);
        if (index != -1) {
            System.out.println("IP " + targetIP + " 可能属于: " + ranges[index].location);
        } else {
            System.out.println("未找到匹配的 IP 区间");
        }
    }
}    