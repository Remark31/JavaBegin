package pair1;

public class Pair<T> {
    private T frist;
    private T secound;

    public Pair() {
        this.frist = null;
        this.secound = null;
    }

    public Pair(T frist, T secound) {
        this.frist = frist;
        this.secound = secound;
    }

    public T getFrist() {
        return frist;
    }

    public T getSecound() {
        return secound;
    }

    public void setFrist(T frist) {
        this.frist = frist;
    }

    public void setSecound(T secound) {
        this.secound = secound;
    }

    public String toString() {
        return this.getClass().getName() + "[frist=" + this.frist + ",secound=" + this.secound + "]";
    }
}
