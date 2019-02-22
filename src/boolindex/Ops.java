package boolindex;

public enum Ops {

    AND("AND"),OR("OR"),NOT("NOT");

    private String ops;

    public String getOps() {
        return this.ops;
    }

    Ops(String ops){
        this.ops = ops;
    }

    /**
     * 判断是否在枚举之中
     * @param args
     * @return
     */
    public static boolean isInEnum(String args) {
        for (Ops t : Ops.values()) {
            if (t.getOps().equals(args)) {
                return true;
            }
        }
        return false;
    }

    public static Ops equalOps(String s) {
        for (Ops t : Ops.values()) {
            if (t.getOps().equals(s)){
                return t;
            }
        }
        return null;
    }

}
