package Model;

import Enums.StadiumSector;
import Interfaces.Identifiable;
import Interfaces.Printable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ticket implements Identifiable, Printable {
    private static List<Long> idList = new ArrayList<>();

    private Long id;
    private String concertHall;
    private int eventCode;
    private LocalDateTime time;
    private DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    private boolean isPromo;
    private StadiumSector sector;



    private float maxBackapackKG;
    private float ticketPrice;
    private long duration;

    public Ticket(Long id, String concertHall, int eventCode, LocalDateTime time,
                  boolean isPromo, StadiumSector sector, float maxBackapackKG) {
        Date startTime = new Date();
        this.setId(id);

        if (concertHall.length() > 10) {
            throw new IllegalArgumentException("Hall doesn't exist");
        }
        this.concertHall = concertHall;
        if (eventCode > 999) {
            throw new IllegalArgumentException("Invalid code");
        }
        this.eventCode = eventCode;

        if (sector != StadiumSector.A && sector != StadiumSector.B && sector != StadiumSector.C) {
            throw new IllegalArgumentException("Choose between A, B, C sectors.");
        }

        this.time = time;
        this.isPromo = isPromo;
        if (isPromo) {
            ticketPrice = 100.00f;
        } else {
            ticketPrice = 150.00f;
        }
        this.sector = sector;
        this.maxBackapackKG = maxBackapackKG;
        Date endTime = new Date();
        this.duration = endTime.getTime() - startTime.getTime();
    }

    public Ticket(String concertHall, int eventCode, LocalDateTime time) {
        Date startTime = new Date();

        if (concertHall.length() > 10) {
            throw new IllegalArgumentException("Hall doesn't exist");
        }
        this.concertHall = concertHall;

        if (eventCode > 999) {
            throw new IllegalArgumentException("Invalid code");
        }
        this.eventCode = eventCode;
        this.time = time;

        ticketPrice = 199.99f;

        Date endTime = new Date();
        this.duration = endTime.getTime() - startTime.getTime();
    }

    public Ticket() {
        Date startTime = new Date();
        ticketPrice = 249.99f;
        Date endTime = new Date();
        this.duration = endTime.getTime() - startTime.getTime();
    }

    public void setSector(StadiumSector sector){
        this.sector = sector;
    }

    public StadiumSector getSector(){
        return this.sector;
    }

    public void print(){
        System.out.println("Ticket's content.");
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        if (id == null) {
            throw new NullPointerException("Write ID value.");
        }
        if (this.getId() == null) {
            idList.add(id);
            this.id = id;
        } else if (this.getId() != null) {
            if (idList.contains(id)) {
                throw new IllegalArgumentException("ID " + id + " already exists.");
            }
             else {
                idList.remove(this.getId());
                this.id = id;
                idList.add(id);
            }
        }
    }

    public float getMaxBackapackKG() {
        return maxBackapackKG;
    }

    public boolean isPromo() {
        return isPromo;
    }

    public DateTimeFormatter getFormatter() {
        return formatter;
    }

    public int getEventCode() {
        return eventCode;
    }

    public String getConcertHall() {
        return concertHall;
    }

    public static List<Long> getIdList() {
        return idList;
    }

    public static void setIdList(List<Long> idList) {
        Ticket.idList = idList;
    }

    public void setTime(LocalDateTime time){
        this.time = time;
    }

    public LocalDateTime getTime(){
        return this.time;
    }

    public long getDuration() {
        return this.duration;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public void formatOutput(LocalDateTime time){
        System.out.println("Time: "+ time.format(this.formatter));
    }
}