package synchronizeduse;

/**
 * 账户类测试
 *
 * @author remark
 * @version 2019-2-27
 */
public class AccountTest {
    private static int NUM_OF_THREAD = 1000;
    static Thread[] threads = new Thread[NUM_OF_THREAD];

    public static void main(String[] args) {
        final Account acc = new Account("John", 1000.0f);
        for (int i = 0; i < NUM_OF_THREAD; i++) {
            threads[i] = new Thread() {
                public void run() {
                    acc.deposit(100.0f);
                    acc.withdraw(100.0f);
                    acc.addmoney(100.0f);
                }
            };
            threads[i].start();
        }

        for (int i = 0; i < NUM_OF_THREAD; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                // ignore
            }
        }
        System.out.println("Finally, John's balance is:" + acc.getBalance());
    }

}
