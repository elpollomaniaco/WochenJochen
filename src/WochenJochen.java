public class WochenJochen {
    private static Controller controller;

    public static void main(String[] args) {
        System.out.println("Wochen-Jochen gestartet...");

        // default values
        int port = 3333;
        int refreshRate = 3;

        for (int i = 0; i < args.length; i ++) {
            if (args[i].equalsIgnoreCase("-p")) {
                if (args.length > i + 1) {
                    port = Integer.parseInt(args[i + 1]);
                }
                i++;
            } else if (args[i].equalsIgnoreCase("-r")) {
                if (args.length > i + 1) {
                    refreshRate = Integer.parseInt(args[i + 1]);
                }
                i++;
            }
        }

        controller = new Controller(port, refreshRate);
    }
}
