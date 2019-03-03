package produce;


import java.util.Date;
import java.util.LinkedList;
import java.util.Random;

/**
 * 生产者，生产数据
 * @author remark
 * @version 2019-3-3
 */
public class ProduceNotify extends Thread {

    private LinkedList<String> datalink;
    private int Max = 1;

    public ProduceNotify(LinkedList<String> data) {
        this.datalink = data;
    }


    public void run(){
        while (true) {
            synchronized (this.datalink) {
                try{
                    while(this.datalink.size() == Max) {
                        System.out.println("data is full, please wait");
                        this.datalink.wait();
                    }

                    String now = new Date().toString();
                    if (this.datalink.add(now)) {
                        System.out.println("ProduceNotify suc=" +  now);
                        Random random = new Random();

                        Thread.sleep((long) random.nextInt(5) * 1000);
                        this.datalink.notify();
                    }


                } catch (InterruptedException e) {
                    System.out.println("Interrupted Exception");
                    e.printStackTrace();
                }
            }
        }
    }
}
