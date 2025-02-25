public class Lab {
    private Session morning; // Morning session
    private Session afternoon; // Afternoon session
    private int capacity; // Room capacity of lab
    private String location; // Location of lab

    // Constructor 1 (Overload)
    public Lab(Session morning, Session afternoon, int capacity, String location) {
        this(capacity, location);
        this.morning = morning;
        this.afternoon = afternoon;
    }

    // Constructor 2
    public Lab(int capacity, String location) {
        this.capacity = capacity;
        this.location = location;
    }

    // Getters
    public Session getMorning() {
        return morning;
    }
    public Session getAfternoon() {
        return afternoon;
    }
    public int getCapacity() {
        return capacity;
    }
    public String getLocation() {
        return location;
    }

    // Setters
    public void setMorning(Session morning) {
        this.morning = morning;
    }
    public void setAfternoon(Session afternoon) {
        this.afternoon = afternoon;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    // List...
    public String listAvailabilities() {
        String res = "";
        if (morning.getEnrollment() == 0) {
            res += "Morning: Available\n";
        }
        if (afternoon.getEnrollment() == 0) {
            res += "Afternoon: Available\n";
        } else if (morning.getEnrollment() > 0 && afternoon.getEnrollment() > 0) {
            res += "No Availabilities";
        }
        return res;
    }
    public String listReservations() {
        String res = "";
        if (morning.getEnrollment() > 0) {
            res += "Morning: Reserved\n";
        }
        if (afternoon.getEnrollment() > 0) {
            res += "Afternoon: Reserved\n";
        } else if (morning.getEnrollment() == 0 && afternoon.getEnrollment() == 0) {
            res += "No Reservations";
        }
        return res;
    }
    public String toString() {
        String res = "Lab{Capacity - " + capacity + ", Location - " + location + ", Morning: ";
        if (morning.getEnrollment() > 0) {
            res += "Session{Name - " + morning.getName() + ", Enrollment - " +
                    morning.getEnrollment() + "}, Afternoon: " ;
        } else {
            res += "Available, Afternoon: ";
        }
        if (afternoon.getEnrollment() > 0) {
            res += "Session{Name - " + afternoon.getName() + ", Enrollment - " +
                    afternoon.getEnrollment() + "}";
        } else {
            res += "Available";
        }
        res += "}";
        return res;

    }


}
