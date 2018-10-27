import java.awt.*;
import java.util.ArrayList;

public class Simulator {

    public Simulator() {

        UIThread gui = new UIThread();
        gui.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        gui.drawRectangle();

        ArrayList<Machine> machineList = new ArrayList<>();

        machineList.add(new Device("10000", 20));
        machineList.add(new Device("10001", 50));
        machineList.add(new ComputingAccessPoint("10002", 300));
        machineList.add(new Server("10003", 500));

        gui.drawMachines(machineList);
//
//        for(Machine m : machineList){
//            if(m instanceof Device){
//                System.out.println(m.getAddress()+" is Device");
//            }
//            else if(m instanceof Server){
//                System.out.println(m.getAddress()+" is Server");
//            }else{
//                System.out.println("Not found");
//            }
//
//        }

    }

    public static void main(String[] args) {
        new Simulator();
    }
}
