public class Main {

    // a total of 65,535 ports

    public static void main(String str[]) {

        PortChecker portChecker = new PortChecker("google.com", 5000);
        boolean ports[][] = portChecker.check();

        System.out.println("Available ports are:");

        for (int i = 0; i < 65535; ++i) {
            if (ports[i][1]) {
                System.out.println("-\t" + i);
            }
        }
    }

}
