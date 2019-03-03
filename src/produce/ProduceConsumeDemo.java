package produce;


import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 多线程生产者消费者
 *
 * @author remark
 * @version 2019-3-3
 */
public class ProduceConsumeDemo {


    /**
     * notify的方式
     */
    public static void notifyDemo() throws InterruptedException {
        LinkedList<String> datalink = new LinkedList<>();


        ProduceNotify produceNotify = new ProduceNotify(datalink);
        ConsumeNotify consume = new ConsumeNotify(datalink);

        produceNotify.start();
        consume.start();

        produceNotify.join();
        consume.join();
    }

    /**
     * 阻塞队列方式
     */
    public static void blockedQueueDemo() throws InterruptedException {
        LinkedBlockingDeque<String> data = new LinkedBlockingDeque<>(1);

        ProduceBlockList produceBlockList = new ProduceBlockList(data);
        ConsumeBlockList consumeBlockList = new ConsumeBlockList(data);

        produceBlockList.start();
        consumeBlockList.start();

        produceBlockList.join();
        consumeBlockList.join();
    }

    public static void main(String[] args) throws InterruptedException {
//        notifyDemo();
        blockedQueueDemo();
    }
}
