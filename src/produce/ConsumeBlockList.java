package produce;



import java.util.concurrent.LinkedBlockingDeque;

/**
 * 阻塞队列实现生产者消费者
 * @author remark
 * @version 2019-3-3
 */
public class ConsumeBlockList extends Thread {
    private LinkedBlockingDeque<String> datalist;

    public ConsumeBlockList(LinkedBlockingDeque<String> data) {
        this.datalist = data;
    }

    public void run() {
        while(true) {
            try {
                String data = datalist.take();
                System.out.println("Get Data=" + data);


            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
