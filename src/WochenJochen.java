import calendar.TimeSlot;
import calendar.Week;

public class WochenJochen {
    private static Controller controller;

    public static void main(String[] args) {
        // default values
        int port = 3333;
        int refreshRate = 10;
        int dayCount = 7;
        int slotCount = 6;
        float startTime = 8;
        float endTime = 20;


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
            } else if (args[i].equalsIgnoreCase("-d")) {
                if (args.length > i + 1) {
                    dayCount = Integer.parseInt(args[i + 1]);
                }
                i++;
            } else if (args[i].equalsIgnoreCase("-s")) {
                if (args.length > i + 1) {
                    slotCount = Integer.parseInt(args[i + 1]);
                }
                i++;
            } else if (args[i].equalsIgnoreCase("-t")) {
                if (args.length > i + 2) {
                    startTime = Float.parseFloat(args[i + 1]);
                    endTime = Float.parseFloat(args[i + 2]);
                }
                i++;
            }
        }

        System.out.printf("Starting WochenJochen with:%n" +
                "Port: %d%n" +
                "Refresh rate: %ds%n" +
                "Day count: %d%n" +
                "Time slots: %d per day%n" +
                "Time interval: %02d:%02d - %02d:%02d%n" +
                "----------------------------%n",
                port, refreshRate, dayCount, slotCount, (int) startTime, (int) (startTime % 1 * 60), (int) endTime, (int) (endTime % 1 * 60));

        controller = new Controller(port, refreshRate, dayCount, slotCount, startTime, endTime);
    }

    public static void printCalendar(Week week) {
        for(int i = 0; i < week.getDayCount(); i++) {
            System.out.println(week.getDayName(i).toUpperCase());
            System.out.println("---------------------");

            TimeSlot[] day = week.getDay(i);
            for(int j = 0; j < day.length; j++) {
                System.out.printf("%s\t%s%n", week.getTime(j), day[j].getEventName());
            }

            System.out.println("---------------------");
        }
    }
}
