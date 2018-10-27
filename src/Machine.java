public class Machine {

    private String address;
    private int memorySize;
    private int maxMemorySize;

    public Machine(String address, int maxMemorySize) {
        this.address = address;
        this.memorySize = memorySize;
        this.maxMemorySize = maxMemorySize;

    }

    public String getAddress() {
        return address;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public int getMaxMemorySize() {
        return maxMemorySize;
    }
}
