package atomic;


import sun.jvm.hotspot.runtime.Threads;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 整数的原子操作
 *
 * @author remark
 * @version 2019-2-27
 */
public class AtomicIntegerLearn {
    public static void main(String[] args) throws InterruptedException {

        final AtomicInteger value = new AtomicInteger(0);

        System.out.println("Atomic CAS value= " + value.compareAndSet(0, 5));
        System.out.println("value=" + value.get());
        System.out.println("Atomic CAS value= " + value.compareAndSet(0,3));
        System.out.println("value=" + value.get());
        value.set(3);

        System.out.println("Increase value=" + value.incrementAndGet());
        System.out.println("get and Add value=" + value.getAndAdd(1));
        System.out.println("get and set value=" + value.getAndSet(1));
        System.out.println("value=" + value.get());


        final int ThreadSize = 10;
        Thread[] ts = new Thread[ThreadSize];

        for (int i = 0 ; i < ThreadSize ; i ++) {
            ts[i] = new Thread(){
              public void run(){
                  value.incrementAndGet();
              }
            };
        }

        for(Thread t : ts){
            t.start();
        }

        for(Thread t : ts){
            t.join();
        }

        System.out.println("value=" + value.get());


    }
}
