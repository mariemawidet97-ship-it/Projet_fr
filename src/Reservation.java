package model;

import java.util.Date;

public class Reservation {
    private int id;
    private int localId;
    private int userId;
    private Date date;

    public Reservation(int id, int localId, int userId, Date date) {
        this.id = id;
        this.localId = localId;
        this.userId = userId;
        this.date = date;
    }

    public int getId() { return id; }
    public int getLocalId() { return localId; }
    public int getUserId() { return userId; }
    public Date getDate() { return date; }

    @Override
    public String toString() {
        return id + " | Local:" + localId + " | User:" + userId + " | " + date;
    }
}