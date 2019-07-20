public enum PlaneType {
    BOEING747(50, 1000);

    private int capacity;
    private int totalWeight;

    PlaneType(int capacity, int totalWeight){
        this.capacity = capacity;
        this.totalWeight = totalWeight;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public int getTotalWeight(){
        return this.totalWeight;
    }
}

