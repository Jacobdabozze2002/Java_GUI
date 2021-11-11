import java.net.Socket;

public class PortChecker extends Thread {
    private final String IP;
    private final boolean testedPorts[][] = new boolean[65535][2];
    private int numberOfThreads;
    private final int allowedNumberOfThreads;

    public PortChecker(String IP, int allowedNumbrOfThreads) {
        this.IP = IP;
        this.numberOfThreads = 0;
        this.allowedNumberOfThreads = allowedNumbrOfThreads;
    }

    public boolean check()[][] {
        int completedTests = 0;

        while(completedTests < 65535) {
            while(numberOfThreads < allowedNumberOfThreads && completedTests < 65535) {
                int port = (int) (Math.random() * 65535);

                if (!testedPorts[port][0]) {
                    testedPorts[port][0] = true;
                    ++completedTests;

                   JF_Thread thread = new JF_Thread(port);
                   thread.start();
                }
            }
        }

        return testedPorts;
    }

    private class JF_Thread extends Thread {
        private final int port;

        public JF_Thread(int port) {
            this.port = port;
        }

        @Override
        public synchronized void run() {
            ++numberOfThreads;

            try {
                Socket socket = new Socket(IP, port);
                socket.close();
                testedPorts[port][1] = true;
            } catch (Exception ignored) {
            }

            --numberOfThreads;
        }
    }
}