package atomic;


import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 域通知的操作
 *
 * @author remark
 * @version 2019-2-27
 */

class TestData {
    public volatile int value1 = 1;
    volatile int value2 = 2;
    protected int value3 = 3;
    private int value4 = 4;

    public String toString() {
        return this.getClass().getName() + "[value1=" + this.value1 + ",value2=" + this.value2
                + ",value3=" + this.value3 + ",value4=" + this.value4;
    }
}

public class AtomicIntegerFieldUpdaterLearn {

    AtomicIntegerFieldUpdater<TestData> getUpdater(String fileName) {
        return AtomicIntegerFieldUpdater.newUpdater(TestData.class, fileName);
    }

    void doit(TestData data) {

        System.out.println("1 ==> " + getUpdater("value1").getAndSet(data, 10));
        System.out.println("3 ==> " + getUpdater("value2").incrementAndGet(data));
        System.out.println("2 ==> " + getUpdater("value3").decrementAndGet(data));
        System.out.println("true ==> " + getUpdater("value4").compareAndSet(data, 4, 5));
    }


    public static void main(String[] args) {
        AtomicIntegerFieldUpdaterLearn test = new AtomicIntegerFieldUpdaterLearn();
        TestData data = new TestData();
        try {
            test.doit(data);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(data);
        }


    }
}
