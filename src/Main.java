import action.*;

public class Main {

    public static void main (String[] args) throws ActionFinishedException {
        int i = 1;
        ForeseableAction a1 = new ForeseableAction(2);
        ForeseableAction a2 = new ForeseableAction(2);
        ForeseableAction a3 = new ForeseableAction(2);
        ForeseableAction a4 = new ForeseableAction(2);
        Scheduler s1 = new SequentialScheduler();
        Scheduler s2 = new SequentialScheduler();
        s1.addAction(a1);
        s1.addAction(a2);
        s2.addAction(a3);
        s2.addAction(a4);
        s1.addAction(s2);
        while (!s1.isFinished()) {
            s1.doStep();
            System.out.println("i = " + (i++));
        }
    }
}