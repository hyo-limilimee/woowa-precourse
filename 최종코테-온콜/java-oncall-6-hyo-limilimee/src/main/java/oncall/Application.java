package oncall;

import oncall.Controller.Scheduler;

public class Application {
    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        scheduler.run();
    }
}
