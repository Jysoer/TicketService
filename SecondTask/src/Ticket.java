import java.util.Date;

public class Ticket {
    String id;
    String concertHall;
    int eventCode;
    long time;
    boolean isPromo;
    char sector;
    float maxBackapackKG;
    private float ticketPrice;
    long duration;

    public Ticket (String id, String concertHall, int eventCode, long time, boolean isPromo, char sector, float maxBackapackKG){
        Date startTime = new Date();

        if (id.length() > 4){
            throw new IllegalArgumentException("Invalid ID");
        }
        this.id = id;

        if (concertHall.length() > 10){
            throw new IllegalArgumentException("Hall doesn't exist");
        }
        this.concertHall = concertHall;
        if (eventCode > 999){
            throw new IllegalArgumentException("Invalid code");
        }
        this.eventCode = eventCode;

        if(sector != 'A' && sector != 'B' && sector != 'C'){
            throw new IllegalArgumentException("Choose between A, B, C sectors.");
        }

        this.time = time;
        this.isPromo = isPromo;
        if(isPromo){
            ticketPrice = 100.00f;
        }
        else {
            ticketPrice = 150.00f;
        }
        this.sector = sector;
        this.maxBackapackKG = maxBackapackKG;
        Date endTime = new Date();
        this.duration = endTime.getTime() - startTime.getTime();
    }

    public Ticket (String concertHall, int eventCode, long time){
        Date startTime = new Date();

        if (concertHall.length() > 10){
            throw new IllegalArgumentException("Hall doesn't exist");
        }
        this.concertHall = concertHall;

        if (eventCode > 999){
            throw new IllegalArgumentException("Invalid code");
        }
        this.eventCode = eventCode;
        this.time = time;

        ticketPrice = 199.99f;

        Date endTime = new Date();
        this.duration = endTime.getTime() - startTime.getTime();
    }
    public Ticket (){
        Date startTime = new Date();
        ticketPrice = 249.99f;
        Date endTime = new Date();
        this.duration = endTime.getTime() - startTime.getTime();
    }

    public float getTicketPrice() {
        return ticketPrice;
    }
}