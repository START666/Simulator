import java.util.Queue;

public class ComputingAccessPoint extends Machine {
    Queue<Task> taskQueue;

    public ComputingAccessPoint(String address, int maxMemorySize, int computingPower) {
        super(address, maxMemorySize, computingPower);
    }
}
