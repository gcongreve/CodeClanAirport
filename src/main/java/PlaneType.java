public enum PlaneType {
    CODINGPLANE1(1),
    CODINGPLANE2(2),
    CODINGPLANE3(3),
    CODINGPLANE4(4);

    private final int capacity;

    PlaneType(int capacity){
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
