import java.util.Arrays;

/*
 * 最大公共子序列
 * @author:Remark
 * @version: 2019-1-28
 */
public class lcs {
    private int getlcs(int[] a, int[] b){
        int[][] lcslist = new int[a.length + 1][a.length + 1];

        for (int i = 1 ; i < lcslist.length ; i ++){
            for (int j = 1 ; j < lcslist[i].length ; j ++){
                if (a[i-1] == b[j-1]) {
                        lcslist[i][j] = lcslist[i-1][j-1] + 1;
                } else{
                    lcslist[i][j] = (lcslist[i-1][j] > lcslist[i][j-1]) ? lcslist[i-1][j] : lcslist[i][j-1];
                }
            }
        }

        return lcslist[lcslist.length-1][lcslist[0].length-1];


    }

    public int lengthOfLIS(int[] nums) {
        int[] snums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(snums);

        int ans = getlcs(nums , snums);


        return ans;
    }
}
