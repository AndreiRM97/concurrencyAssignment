import java.util.Map;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FestivalStatisticsThread extends Thread    {
    private FestivalGate gate;

    public FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Thread.sleep(5000);
                generateStatistics();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void generateStatistics() {
        Queue<TicketType> queue = gate.getTicketsQueue();
        if (!queue.isEmpty()) {
            Map<TicketType, Long> stats = queue.stream()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            System.out.println(stats);
        }
    }
}
