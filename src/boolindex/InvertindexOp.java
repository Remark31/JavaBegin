package boolindex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import static boolindex.Ops.*;


/**
 * 倒排索引的计算
 *
 * @author remark
 * @version 2019-2-22
 */
public class InvertindexOp extends Invertindex {

    /**
     * 初始化计算
     *
     * @param args
     */
    public InvertindexOp(String[] args) {
        super(args);
    }

    /**
     * 解析字符串，并且按照优先级进行计算
     *
     * @param str 运算字符串
     * @return
     */
    public String Operation(String str) {
        String[] args = str.split(" ");
        Stack<ArrayList<Integer>> wdstack = new Stack<>();
        Stack<String> opstack = new Stack<>();


        for (String arg : args) {
            if (!Ops.isInEnum(arg)) {
//                System.out.println(super.getInvertIndexValue(arg).getValue());
//                System.out.println("now element: " + arg);
//                System.out.println("uu:" + wdstack);
                wdstack.push(super.getInvertIndexValue(arg).getValue());
            } else {
                opstack.push(arg);
            }
        }

        while (!opstack.empty()) {
            String op = opstack.pop();

            switch (equalOps(op)) {
                case NOT:
                    wdstack.push(notOperation(wdstack.pop()));
                    break;
                case OR:
                    wdstack.push(orOperation(wdstack.pop(), wdstack.pop()));
                    break;
                case AND:
                    wdstack.push(andOperation(wdstack.pop(), wdstack.pop()));
                    break;
                default:
                    throw new RuntimeException("NO OP");
            }
        }

        ArrayList<Integer> ans = wdstack.pop();

        String ansString = "[";

        for (Iterator it = ans.iterator(); it.hasNext(); ) {
            ansString += it.next().toString() + ",";
        }

        ansString = ansString.substring(0, ansString.length() - 1);
        ansString += "]";
        return ansString;
    }

    /**
     * 与操作
     *
     * @param list1 输入结果1
     * @param list2 输入结果2
     * @return
     */
    private ArrayList<Integer> andOperation(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        int i1 = 0;
        int i2 = 0;

        ArrayList<Integer> ans = new ArrayList<>();

        while (i1 < list1.size() && i2 < list2.size()) {
            if (list1.get(i1) == list2.get(i2)) {
                ans.add(list1.get(i1));
                i1++;
                i2++;
            } else {
                if (list2.get(i2) > list1.get(i1)) {
                    i1++;
                } else {
                    i2++;
                }
            }
        }


        return ans;
    }

    /**
     * 或操作
     *
     * @param list1
     * @param list2
     * @return
     */
    private ArrayList<Integer> orOperation(ArrayList<Integer> list1, ArrayList<Integer> list2) {

        ArrayList<Integer> ans = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;

        int before = -1;

        while (i1 < list1.size() && i2 < list2.size()) {
            if (list1.get(i1) == list2.get(i2)) {

                if (list1.get(i1) != before) {
                    ans.add(list1.get(i1));
                    before = list1.get(i1);
                }
                i1++;
                i2++;

            } else {
                if (list1.get(i1) < list2.get(i2)) {
                    if (list1.get(i1) != before) {
                        ans.add(list1.get(i1));
                        before = list1.get(i1);
                    }
                    i1++;
                } else {
                    if (list2.get(i2) != before) {
                        ans.add(list2.get(i2));
                        before = list2.get(i2);
                    }
                    i2++;
                }
            }
        }

        if (i1 == list1.size()) {
            for (; i2 < list2.size(); i2++) {
                ans.add(list2.get(i2));
            }
        } else {
            for (; i1 < list1.size(); i1++) {
                ans.add(list1.get(i1));
            }
        }

        return ans;

    }

    /**
     * 非操作
     *
     * @param list
     * @return
     */

    private ArrayList<Integer> notOperation(ArrayList<Integer> list) {
        int maxpage = super.getMaxpage();

        ArrayList<Integer> ans = new ArrayList<>();

        int i = 0;
        int j = 1;
        for (; i < list.size(); i++) {
            if (list.get(i) == j) {
                j++;
            } else {
                while (list.get(i) > j) {
                    list.add(j);
                    j++;
                }
            }
        }
        while (j <= maxpage) {
            ans.add(j);
            j++;
        }


        return ans;
    }


    public static void main(String[] args) {

        String[] words = {"breakthrough drug for schizophrenia", "new schizophrenia drug",
                "new approach for treatment of schizophrenia", "new hopes for schizophrenia patients"};

        InvertindexOp invertindexOp = new InvertindexOp(words);

//        String[] ops = {"schizophrenia AND drug", "for AND NOT ( drug OR approach )"};
        System.out.println(invertindexOp);

        String[] ops = {"schizophrenia AND drug", "drug OR approach", "NOT drug"};

        for (String op : ops) {
            String ans = invertindexOp.Operation(op);
            System.out.println("word=" + op + ",ans=" + ans);
        }
    }
}
