public class Task {

    private int task_size;
    private String generatedByAddress;

    public Task(int task_size, String generatedByAddress){
        this.task_size = task_size;
        this.generatedByAddress = generatedByAddress;
    }

    public int getTask_size() {
        return task_size;
    }

    public String getGeneratedByAddress() {
        return generatedByAddress;
    }
}
