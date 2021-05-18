package model;

public class Plane {
    private int id;
    private String model;
    private String serialNumber;
    private int seats;

    public Plane() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", seats=" + seats +
                '}';
    }
}
