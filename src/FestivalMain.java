public class FestivalMain {
    public static void main(String[] args) {
        FestivalGate gate = new FestivalGate();
        FestivalStatisticsThread statisticsThread = new FestivalStatisticsThread(gate);
        statisticsThread.start();

        for (int i = 0; i < 100; i++) {
            FestivalAttendeeThread attendee = new FestivalAttendeeThread(gate);
            attendee.start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
