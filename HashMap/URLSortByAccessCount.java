import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class URLSortByAccessCount {
    public static void main(String[] args) {
        String filePath = "access_log.txt";
        Map<String, Integer> urlCountMap = new HashMap<>();

        // 读取文件并统计每个 URL 的访问次数
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // 去除行末的空白字符
                String url = line.trim();
                // 更新 URL 的访问次数
                urlCountMap.put(url, urlCountMap.getOrDefault(url, 0) + 1);
            }
        } catch (IOException e) {
            System.err.println("读取文件时发生错误: " + e.getMessage());
            return;
        }

        // 将 Map 中的键值对转换为 List，方便排序
        List<Map.Entry<String, Integer>> urlCountList = new ArrayList<>(urlCountMap.entrySet());

        // 对 List 进行排序，按访问次数降序排列
        urlCountList.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        // 输出排序后的结果
        for (Map.Entry<String, Integer> entry : urlCountList) {
            System.out.println("URL: " + entry.getKey() + ", 访问次数: " + entry.getValue());
        }
    }
}    