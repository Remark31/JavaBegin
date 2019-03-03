package produce;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 阻塞队列方式生产者
 *
 * @author remark
 * @version 2019-3-3
 */
public class ProduceBlockList extends Thread {
    private LinkedBlockingDeque<String> datalist;

    public ProduceBlockList(LinkedBlockingDeque<String> data) {
        this.datalist = data;
    }

    public void run() {
        while (true) {
            try {
                String data = new Date().toString();
                this.datalist.put(data);
                System.out.println("Produce: " + data);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
