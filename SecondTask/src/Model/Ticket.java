package Model;

import Enums.StadiumSector;
import Interfaces.Identifiable;
import Interfaces.NullableWarning;
import Interfaces.Printable;
import Interfaces.Sharable;
import Service.AnnotationValidator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class Ticket implements Identifiable, Printable, Sharable {
    @NullableWarning
    private Long id;
    @NullableWarning
    private String concertHall;
    private int eventCode;
    private LocalDateTime time;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    private boolean isPromo;
    private StadiumSector sector;
    private float maxBackapackKG;
    private float ticketPrice;
    private long duration;

    public Ticket(Long id, String concertHall, int eventCode, LocalDateTime time,
                  boolean isPromo, StadiumSector sector, float maxBackapackKG) {
        Date startTime = new Date();
        this.id = generateOrValidateId(id);
        validateConcertHall(concertHall);
        this.concertHall = concertHall;
        validateEventCode(eventCode);
        this.eventCode = eventCode;
        validateSector(sector);
        this.sector = sector;
        this.time = time;
        this.isPromo = isPromo;
        this.ticketPrice = isPromo ? 100.00f : 150.00f;
        this.maxBackapackKG = maxBackapackKG;
        Date endTime = new Date();
        this.duration = endTime.getTime() - startTime.getTime();
        validateAnnotations();
    }

    public Ticket(String concertHall, int eventCode, LocalDateTime time) {
        Date startTime = new Date();
        this.id = IdManeger.generateId();
        validateConcertHall(concertHall);
        this.concertHall = concertHall;
        validateEventCode(eventCode);
        this.eventCode = eventCode;
        this.time = time;
        this.ticketPrice = 199.99f;
        Date endTime = new Date();
        this.duration = endTime.getTime() - startTime.getTime();
        validateAnnotations();
    }

    public Ticket() {
        Date startTime = new Date();
        this.id = IdManeger.generateId();
        this.ticketPrice = 249.99f;
        Date endTime = new Date();
        this.duration = endTime.getTime() - startTime.getTime();
        validateAnnotations();
    }

    public void setSector(StadiumSector sector) {
        this.sector = sector;
    }

    public StadiumSector getSector() {
        return this.sector;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public void shared(String phoneNumber) {
        System.out.println("Ticket ID" + this.getId() + "shared on " + phoneNumber + "");
    }

    public void shared(String phoneNumber, String email) {
        System.out.println("Ticket ID" + this.getId() + "shared on " + phoneNumber + " and email " + email + "");
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

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public LocalDateTime getTime() {
        return this.time;
    }

    public long getDuration() {
        return this.duration;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Ticket ticket = (Ticket) obj;
        return Objects.equals(id, ticket.id) &&
                Objects.equals(concertHall, ticket.concertHall) &&
                eventCode == ticket.eventCode &&
                Objects.equals(time, ticket.time) &&
                isPromo == ticket.isPromo &&
                Float.compare(maxBackapackKG, ticket.maxBackapackKG) == 0 &&
                Objects.equals(sector, ticket.sector);


    }

    @Override
    public int hashCode() {
        return Objects.hash(id, concertHall, eventCode, time, isPromo, sector, maxBackapackKG);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketPrice=" + ticketPrice +
                ", sector=" + sector +
                ", isPromo=" + isPromo +
                ", time=" + time +
                ", eventCode=" + eventCode +
                ", concertHall='" + concertHall + '\'' +
                ", id=" + id +
                ", maxBackapackKG=" + maxBackapackKG +
                '}';
    }

    @Override
    public void print(){
        System.out.println(this.toString());
    }

    private Long generateOrValidateId(Long id) {
        if (id == null) {
            return IdManeger.generateId();
        } else if (IdManeger.addId(id)) {
            return id;
        } else {
            throw new IllegalArgumentException("ID already exists");
        }
    }

    private void validateConcertHall(String concertHall) {
        if (concertHall.length() > 10) {
            throw new IllegalArgumentException("Hall doesn't exist");
        }
    }

    private void validateEventCode(int eventCode) {
        if (eventCode > 999) {
            throw new IllegalArgumentException("Invalid code");
        }
    }

    private void validateSector(StadiumSector sector){
        if (sector != StadiumSector.A && sector != StadiumSector.B && sector != StadiumSector.C) {
            throw new IllegalArgumentException("Choose between A, B, C sectors.");
        }
    }

    public void formatOutput(LocalDateTime time) {
        System.out.println("Time: " + time.format(this.formatter));
    }

    private void validateAnnotations() {
        try {
            AnnotationValidator.validate(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}