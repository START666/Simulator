import java.util.Queue;

public class Server extends Machine {

    Queue<Task> taskQueue;
    public Server(String address, int maxMemorySize, int computingPower) {
        super(address, maxMemorySize,computingPower);
    }
}
