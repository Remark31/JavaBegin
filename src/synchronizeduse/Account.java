package synchronizeduse;

/**
 * 测试 synchronized 的账户类型
 *
 * @author remark
 * @version 2019-2-27
 */
class Account {
    String name;
    float amount;


    public Account(String name, float amount) {
        this.name = name;
        this.amount = amount;
    }

    /**
     * 加钱
     * @param amt
     */
    public synchronized void deposit(float amt) {
        System.out.println("====add: Begin====");
        float tmp = amount;
        tmp += amt;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // ignore
        }


        amount = tmp;
        System.out.println("====add: End====");
    }


    /**
     * 减钱
     * @param amt
     */
    public synchronized void withdraw(float amt) {
        System.out.println("====minus: Begin====");
        float tmp = amount;
        tmp -= amt;

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // ignore
        }



        amount = tmp;
        System.out.println("====minus: End====");

    }

    public void addmoney(float amt) {

        synchronized(this) {
            System.out.println("=== addmoney: Begin====");

            this.amount = this.amount + amt;

            try{
                Thread.sleep(800);
            } catch (InterruptedException e){

            }

            System.out.println("==== addmoney: End=====");
        }

    }

    public float getBalance() {
        return amount;
    }
}