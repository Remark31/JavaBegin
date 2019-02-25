package dictionaryAndFaultTolerance;


/**
 * 编辑距离计算方法
 *
 * @author remark
 * @version 2019-2-25
 */
public class Levenshtein {

    /**
     * 计算编辑距离
     *
     * @param s1
     * @param s2
     * @return
     */
    public static int calLevenshteinDistance(String s1, String s2) {
        if (s1.length() == 0) {
            return s2.length();
        }

        if (s2.length() == 0) {
            return s1.length();
        }

        int[][] dp = new int[s1.length() + 1][s2.length()+1];

        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = i;
        }

        for (int j = 1; j <= s2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                int tmp;
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    tmp = 0;
                } else {
                    tmp = 1;
                }
                dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + tmp));
            }
        }

        return dp[s1.length()][s2.length()];
    }


    public static void main(String[] args) {
        System.out.println(calLevenshteinDistance("ivskan2", "ivan2"));
    }
}
