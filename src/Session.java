public class Session {
    private String name; // name of session
    private int enrollment; // # of attendees enrolled in session

    //Constructor
    public Session(String name, int enrollment) {
        this.name = name;
        this.enrollment = enrollment;
    }

    // Getters
    public String getName() {
        return name;
    }
    public int getEnrollment() {
        return enrollment;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setEnrollment(int enrollment) {
        this.enrollment = enrollment;
    }

    // toString
    public String toString() {
        return "Session{Name - " + name + ", Enrollment - " + enrollment + "}";
    }

}
