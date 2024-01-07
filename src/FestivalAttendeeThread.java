import java.util.Random;

public class FestivalAttendeeThread extends Thread  {
    private TicketType ticketType;
    private FestivalGate gate;

    public FestivalAttendeeThread(FestivalGate gate) {
        this.gate = gate;
        this.ticketType = TicketType.values()[new Random().nextInt(TicketType.values().length)];
    }

    @Override
    public void run() {
        gate.addTicket(ticketType);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
