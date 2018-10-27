import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Machine {

    private int computingPower;
    private String address;
    private int memorySize;
    private int maxMemorySize;



    public Machine(String address, int maxMemorySize, int computingPower) {
        this.computingPower = computingPower;
        this.address = address;
        this.memorySize = maxMemorySize;
        this.maxMemorySize = maxMemorySize;
    }

    public int getComputingPower() {
        return computingPower;
    }

    public String getAddress() {
        return address;
    }

    public void setMemorySize(int memorySize){
        this.memorySize = memorySize;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public int getMaxMemorySize() {
        return maxMemorySize;
    }
}
