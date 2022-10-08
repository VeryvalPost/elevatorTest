import java.util.*;

public class Main {

    static int waitDoorsInSeconds = 10;
    static int waitMoveInSeconds = 5;
    static int totalSeconds = 0;
    static int previousFloor = -1;
    static int currentFloor = 0;

    public static void main(String[] ags) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> track = new LinkedList<>();

        while (true) {
            System.out.println("Ожидаю ввода этажа: (для завершения введите - 0)");
            String input = scanner.nextLine();

            if ("0".equals(input)) {
                while (!track.isEmpty()) {
                    System.out.print("этаж " + track.poll() + " -> ");
                }
                System.out.println(" этаж 0");
                System.out.println("Время затраченное лифтом на маршрут = " + totalSeconds + " с.");
                break;
            }
            pressButton(input, track);
            previousFloor = currentFloor;
        }
    }


    public static int pressButton(String input, Queue<Integer> track) {
        int button = Integer.parseInt(input);
        if (0 < button && button <= 25) {
            track.offer(button);
            currentFloor = button;
            if (previousFloor != -1) {
                totalSeconds += Math.abs(currentFloor - previousFloor) * waitMoveInSeconds;
                totalSeconds += waitDoorsInSeconds;
            } else {
                totalSeconds = currentFloor * waitMoveInSeconds + waitDoorsInSeconds;
            }
            return totalSeconds;
        } else {
            System.out.println("Такого этажа нет в доме");
        }
        return 0;
    }
}
