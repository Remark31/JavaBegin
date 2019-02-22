package boolindex;


import javafx.util.Pair;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * 倒排索引构建
 *
 * @author remark
 * @version 2019-2-22
 */


public class Invertindex {
    private TreeMap<String, Pair<Integer, ArrayList<Integer>>> invertIndex;
    private int maxpage;

    /**
     * 倒排索引构建
     * @param args 文档内容，每条String是一个文档
     */
    public Invertindex(String[] args) {

        this.invertIndex = new TreeMap<>();

        // 归一化词条
        ArrayList<Pair<String, Integer>> wordlist = makenormalized(args);

        // 排序

        wordlist.sort((frist, secound) -> {
            int ans = frist.getKey().compareTo(secound.getKey());
            if (ans != 0) {
                return ans;
            } else {
                return frist.getValue() - secound.getValue();
            }
        });

        // 合并

        mergePairList(wordlist);

    }

    /**
     * 对给定字符串数组进行归一化处理
     *
     * @param args 字符串数组，每个字符串就是一个文本，index为文本编号
     * @return 返回归一化词条，<词条，文编号>
     */
    private ArrayList<Pair<String, Integer>> makenormalized(String[] args) {

        ArrayList<Pair<String, Integer>> Ans = new ArrayList<>();

        for (int i = 0; i < args.length; i++) {
            String[] arg = args[i].split(" ");
            for (int j = 0; j < arg.length; j++) {
                Pair<String, Integer> tmp = new Pair<>(arg[j], i + 1);
                Ans.add(tmp);
            }
        }

        this.maxpage = args.length;

        return Ans;
    }

    /**
     * 将排序后的词条进行合并，形成倒排索引
     *
     * @param wordlist 归一化词条
     */

    private void mergePairList(ArrayList<Pair<String, Integer>> wordlist) {

        String before = wordlist.get(0).getKey();


        ArrayList<Integer> mlist = new ArrayList<>();
        mlist.add(wordlist.get(0).getValue());

        for (int i = 1; i < wordlist.size(); i++) {

            if (wordlist.get(i).getKey().equals(before)) {

                mlist.add(wordlist.get(i).getValue());

            } else {

                Pair<Integer, ArrayList<Integer>> tmplist = new Pair<>(mlist.size(), mlist);

                this.invertIndex.put(before, tmplist);

                mlist = new ArrayList<>();
                mlist.add(wordlist.get(i).getValue());
                before = wordlist.get(i).getKey();

            }
        }

        Pair<Integer, ArrayList<Integer>> tmplist = new Pair<>(mlist.size(), mlist);
        this.invertIndex.put(before, tmplist);
    }

    /**
     * 方便打印的字符串化输出
     * @return
     */
    public String toString() {
        String ans = this.getClass().getName() + "[" + "\n";
        for (String key : this.invertIndex.keySet()) {
            ans += "[key=" + key + ",faq=" + this.invertIndex.get(key).getKey()
                    + ",list=" + this.invertIndex.get(key).getValue().toString() + "]\n";
        }

        ans += "]";
        return ans;
    }

    /**
     * 获取当前文档的最大页码
     * @return
     */
    public int getMaxpage() {
        return this.maxpage;
    }

    public Pair<Integer, ArrayList<Integer>> getInvertIndexValue(String key) {
        return this.invertIndex.get(key);
    }


    public static void main(String[] args) {
        String[] words = {"breakthrough drug for schizophrenia", "new schizophrenia drug",
                "new approach for treatment of schizophrenia", "new hopes for schizophrenia patients"};

        Invertindex invertindex = new Invertindex(words);

        System.out.println(invertindex);


    }

}
