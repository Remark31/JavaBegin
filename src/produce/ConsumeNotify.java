package produce;


import java.util.LinkedList;
import java.util.Random;

/**
 * 消费者，消费数据
 *
 * @author remark
 * @version 2019-3-3
 */
public class ConsumeNotify extends Thread {
    private LinkedList<String> datalink;

    public ConsumeNotify(LinkedList<String> data) {
        this.datalink = data;
    }

    public void run() {
        while (true) {
            synchronized (this.datalink) {
                try {
                    while (this.datalink.size() == 0) {
                        System.out.println("Data is Empty, wait");
                        this.datalink.wait();
                    }

                    System.out.println("Get Data:=" + datalink.getLast());
                    this.datalink.removeLast();

                    Random random = new Random();

                    Thread.sleep((long) random.nextInt(5) * 1000);
                    this.datalink.notify();

                } catch (InterruptedException e) {
                    System.out.println("Interrupted Exception");
                    e.printStackTrace();
                }
            }
        }
    }


}
