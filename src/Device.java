import java.util.LinkedList;
import java.util.Queue;

public class Device extends Machine {

    Queue<Task> taskQueue;

    public Device(String address, int maxMemorySize, int computingPower) {
        super(address, maxMemorySize, computingPower);
        taskQueue = new LinkedList<>();
    }

    public void generateJob() {
        int size = (int) (Math.random() * 11);
        if (size < this.getMemorySize()) {
            Task task = new Task(size, this.getAddress());
            taskQueue.offer(task);
            this.setMemorySize(this.getMemorySize() - size);
        }

    }

    public void doTask(){
        //TODO: do the next available task based on the speed(computing power) of the current device
    }

    public boolean sendTask(Machine machine){
        //TODO: send the next available task to the machine, make sure to check the connection before send the task

        return true;
    }

    public Queue<Task> getTaskQueue() {
        return taskQueue;
    }
}
