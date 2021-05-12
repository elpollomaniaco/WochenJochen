public class WochenJochen {
    private static Controller controller;

    public static void main(String[] args) {
        System.out.println("Wochen-Jochen gestartet...");

        // default values
        int port = 3333;

        for (int i = 0; i < args.length; i ++) {
            if (args[i].equalsIgnoreCase("-p")) {
                if (args.length > i + 1) {
                    port = Integer.parseInt(args[i + 1]);
                }
                i++;
            }
        }

        System.out.println(port);
        controller = new Controller(port);
    }
}
