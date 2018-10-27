import sun.awt.Mutex;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class UIThread extends Thread {

    private JFrame frame;
    private MyCanvas panel;
    private static int width = 500;
    private static int height = 500;
    private static int dotSize = 10;
    public BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    public Graphics2D g2d = image.createGraphics();
    public ArrayList<Machine> machineList = null;

    Mutex readyLock;

    public UIThread() {
        readyLock = new Mutex();
    }

    @Override
    public void run() {
        synchronized (readyLock) {
            setup();
            frame.setVisible(true);
        }
    }

    private void setup() {
        frame = new JFrame("Simulator");
        panel = new MyCanvas();
        frame.setLayout(new GridLayout(1, 1));

        frame.setSize(width, height);
        //panel.setBackground(Color.white);
        frame.add(panel);
        //frame.pack();

        g2d.setPaint(Color.WHITE);    //set background to white
        g2d.fillRect(0, 0, image.getWidth(), image.getHeight());

    }

    public void clearCanvas() {
        g2d.setPaint(Color.WHITE);    //set background to white
        g2d.fillRect(0, 0, image.getWidth(), image.getHeight());
        synchronized (readyLock) {
            panel.setImage(image);
        }
    }

    public void drawMachines(ArrayList<Machine> machineList) {
        int size = 50;
        int currentDeviceX = 10;
        int currentDeviceY = 10;
        int currentCAPX = 10;
        int currentCAPY = currentDeviceY + size + 30;
        int currentServerX = 10;
        int currentServerY = currentCAPY + size + 30;


        for (Machine m : machineList) {
            String address = m.getAddress();
            if (m instanceof Device) {
                drawRectangle(currentDeviceX, currentDeviceY, size, Color.BLUE);
                drawText(currentDeviceX, currentDeviceY + size / 2, address);
                currentDeviceX += size + 10;
            }

            if (m instanceof ComputingAccessPoint) {
                drawRectangle(currentCAPX, currentCAPY, size, Color.RED);
                drawText(currentCAPX, currentCAPY + size / 2, address);
                currentCAPX += size + 10;
            }

            if (m instanceof Server) {
                drawRectangle(currentServerX, currentServerY, size, Color.GREEN);
                drawText(currentServerX, currentServerY + size / 2, address);
                currentServerX += size + 10;
            }

        }

    }

    public void drawText(int x, int y, String text) {

        g2d.setPaint(Color.WHITE);
        g2d.setFont(new Font("TimesNewRoman", Font.PLAIN, 16));
        g2d.drawString(text, x, y);
    }

    public void drawRectangle(int x, int y, int size, Color color) {

        g2d.setPaint(color);
        g2d.fillRect(x, y, size, size);
        synchronized (readyLock) {
            panel.setImage(image);
            System.out.println("Rectangle drawn.");
        }

    }

    //MyCanvas class is written based on JPanel
    private class MyCanvas extends JPanel {
        private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        private Graphics2D g2d = image.createGraphics();
        private int imgCount = 0;

        public MyCanvas() {
            g2d.setPaint(Color.WHITE);    //set background to white
            g2d.fillRect(0, 0, image.getWidth(), image.getHeight());

        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, null);
//            try {
//                File imgOut = new File("image" + imgCount + ".jpg");
//                ImageIO.write(image, "jpg", imgOut);
//                imgCount++;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

        }

        public void setImage(BufferedImage image) {
            this.image = image;
            repaint();
        }


    }


}
