package boolindex;

import java.util.ArrayList;

import javafx.util.Pair;

import java.util.TreeMap;


/**
 * 构建位置索引
 *
 * @author remark
 * @version 2019-2-23
 */
public class PositionIndex {
    private TreeMap<String, Pair<Integer, ArrayList<positionElement>>> positionIndex;

    /**
     * 初始化位置索引
     *
     * @param data 每个String是一个文档，整体是个文档集
     */
    public PositionIndex(String[] data) {
        this.positionIndex = new TreeMap<>();

        // 归一化词条
        ArrayList<Pair<String, Pair<Integer, Integer>>> wordlist = makenormalized(data);

        // 排序
        wordlist.sort(new PairStringIntSort());

        System.out.println("wordlist= " + wordlist);

        // 合并
        mergePairList(wordlist);
    }

    /**
     * 归一化词语
     *
     * @param datas
     * @return
     */
    private ArrayList<Pair<String, Pair<Integer, Integer>>> makenormalized(String[] datas) {
        ArrayList<Pair<String, Pair<Integer, Integer>>> ans = new ArrayList<>();

        for (int index = 0; index < datas.length; index++) {

            String[] words = datas[index].split(" ");

            for (int j = 0; j < words.length; j++) {
                ans.add(new Pair<>(words[j], new Pair<>(index, j)));
            }

        }

        return ans;
    }

    /**
     * 对归一好的词表进行合并
     *
     * @param wordlist
     */
    private void mergePairList(ArrayList<Pair<String, Pair<Integer, Integer>>> wordlist) {
        String beforeKey = "";
        int beforeId = -1;
        ArrayList<positionElement> tmpList = new ArrayList<>();

        positionElement tmpElement = null;

//         private TreeMap<String, Pair<Integer, ArrayList<positionElement>>> positionIndex;
//                          key           faq             <fileid, <times>>

        for (int i = 0; i < wordlist.size(); i++) {
            if (wordlist.get(i).getKey().equals(beforeKey) && wordlist.get(i).getValue().getKey() == beforeId) {
                tmpElement.addElement(wordlist.get(i).getValue().getValue());
            } else if (wordlist.get(i).getKey().equals(beforeKey) && wordlist.get(i).getValue().getKey() != beforeId) {

                tmpList.add(tmpElement);

                beforeId = wordlist.get(i).getValue().getKey();
                tmpElement = new positionElement(wordlist.get(i).getValue().getKey());
                tmpElement.addElement(wordlist.get(i).getValue().getValue());
            } else {

                if (!beforeKey.equals("")) {
                    tmpList.add(tmpElement);
                    this.positionIndex.put(beforeKey, new Pair<>(tmpList.size(), tmpList));
                }
                beforeKey = wordlist.get(i).getKey();

                tmpElement = new positionElement(wordlist.get(i).getValue().getKey());
                tmpElement.addElement(wordlist.get(i).getValue().getValue());
                beforeId = wordlist.get(i).getValue().getKey();
                tmpList = new ArrayList<>();

            }
        }

        tmpList.add(tmpElement);
        this.positionIndex.put(beforeKey, new Pair<>(tmpList.size(), tmpList));


    }

    public String toString() {
        String ans = this.getClass().getName() + "[" + "\n";
        for (String key : this.positionIndex.keySet()) {
            ans += "[key=" + key + ",faq=" + this.positionIndex.get(key).getKey()
                    + ",list=" + this.positionIndex.get(key).getValue().toString() + "]\n";
        }

        ans += "]";
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"to be or not to", "to here and no here", "it not a question"};

        PositionIndex positionIndex = new PositionIndex(words);

        System.out.println(positionIndex);
    }

}
