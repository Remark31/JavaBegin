package boolindex;

import java.util.ArrayList;

public class positionElement {
    private int fileindex;
    private ArrayList<Integer> position;



    public positionElement(int fileindex) {
        this.fileindex = fileindex;
        this.position = new ArrayList<>();
    }


    public int getFileindex() {
        return this.fileindex;
    }

    public ArrayList<Integer> getPosition() {
        return this.position;
    }

    public void addElement(int index) {
        this.position.add(index);
    }



    public String toString() {
        String ans = "positionElement[fileindex=" + this.fileindex + ",positions=" + this.position + "]";
        return ans;
    }
}
