import java.util.ArrayList;

public class Hanger {

    private String name;
    private ArrayList<Plane> hanger;
    private int capacity;

    public Hanger(String name, int capacity) {
        this.name = name;
        this.hanger = new ArrayList<>();
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Plane> getHanger() {
        return hanger;
    }

    public int getCapacity() {
        return capacity;
    }

    public void addPlane(Plane plane) {
        this.hanger.add(plane);
    }

    public boolean isFull(){
        return hanger.size() == capacity;
    }


}
