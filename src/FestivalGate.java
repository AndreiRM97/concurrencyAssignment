import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FestivalGate {
    private Queue<TicketType> ticketsQueue = new ConcurrentLinkedQueue<>();

    public void addTicket(TicketType ticketType) {
        ticketsQueue.add(ticketType);
    }

    public Queue<TicketType> getTicketsQueue() {
        return ticketsQueue;
    }
}
