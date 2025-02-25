import java.sql.SQLOutput;

public class LabManager {
    // Fields... first, second, and third labs of this manager
    private Lab labOne;
    private Lab labTwo;
    private Lab labThree;

    // Basic constructor
    public LabManager(Lab labOne, Lab labTwo, Lab labThree) {
        this.labOne = labOne;
        this.labTwo = labTwo;
        this.labThree = labThree;
    }

    // Getters
    public Lab getLabOne() {
        return labOne;
    }
    public Lab getLabTwo() {
        return labTwo;
    }
    public Lab getLabThree() {
        return labThree;
    }

    // Setters
    public void setLabOne(Lab labOne) {
        this.labOne = labOne;
    }
    public void setLabTwo(Lab labTwo) {
        this.labTwo = labTwo;
    }
    public void setLabThree(Lab labThree) {
        this.labThree = labThree;
    }

    public int calculateTotalCapacity() {
        return (labOne.getCapacity() * 2) + (labTwo.getCapacity() * 2) +
                (labThree.getCapacity() * 2);
    }

    public double calculateTotalUtilization() {
        int labOneEnr = labOne.getMorning().getEnrollment() +
                labOne.getAfternoon().getEnrollment();
        int labTwoEnr = labTwo.getMorning().getEnrollment() +
                labTwo.getAfternoon().getEnrollment();
        int labThreeEnr = labThree.getMorning().getEnrollment() +
                labThree.getAfternoon().getEnrollment();
        double totalEnrollment = (double) ((labOneEnr) + (labTwoEnr) + (labThreeEnr));
        double totalCapacity = (double) this.calculateTotalCapacity();
        return Double.parseDouble(String.format("%.2f", totalEnrollment / totalCapacity));
        // Truncate to 2 dec places
    }

    public int calculateAvailableSeats() {
        int labOneEnr = labOne.getMorning().getEnrollment() +
                labOne.getAfternoon().getEnrollment();
        int labTwoEnr = labTwo.getMorning().getEnrollment() +
                labTwo.getAfternoon().getEnrollment();
        int labThreeEnr = labThree.getMorning().getEnrollment() +
                labThree.getAfternoon().getEnrollment();
        int totalEnrollment = ((labOneEnr) + (labTwoEnr) + (labThreeEnr));
        int totalCapacity = this.calculateTotalCapacity();
        return totalCapacity - totalEnrollment;
    }

    public String listReservedLabs() {
        String res = "Lab One\n";
        // Check lab one
        if (labOne.getMorning().getEnrollment() > 0) {
            res += "Morning: Reserved\n";
        }
        if (labOne.getAfternoon().getEnrollment() > 0) {
            res += "Afternoon: Reserved\n";
        } else if (labOne.getMorning().getEnrollment() == 0 &&
                labOne.getAfternoon().getEnrollment() == 0) {
            res += "No Reservations\n";
        }
        res += "\n";
        res += "Lab Two\n";
        // Check lab two
        if (labTwo.getMorning().getEnrollment() > 0) {
            res += "Morning: Reserved\n";
        }
        if (labTwo.getAfternoon().getEnrollment() > 0) {
            res += "Afternoon: Reserved\n";
        } else if (labTwo.getMorning().getEnrollment() == 0 &&
                labTwo.getAfternoon().getEnrollment() == 0) {
            res += "No Reservations\n";
        }
        res += "\n";
        res += "Lab Three\n";
        // Check lab three
        if (labThree.getMorning().getEnrollment() > 0) {
            res += "Morning: Reserved\n";
        }
        if (labThree.getAfternoon().getEnrollment() > 0) {
            res += "Afternoon: Reserved\n";
        } else if (labThree.getMorning().getEnrollment() == 0 &&
                labThree.getAfternoon().getEnrollment() == 0) {
            res += "No Reservations\n";
        }
        return res;
    }

    public String listAvailableLabs() {
        String res = "Lab One\n";
        // Check lab one
        if (labOne.getMorning().getEnrollment() == 0) {
            res += "Morning: Available\n";
        }
        if (labOne.getAfternoon().getEnrollment() == 0) {
            res += "Afternoon: Available\n";
        } else if (labOne.getMorning().getEnrollment() > 0 &&
                labOne.getAfternoon().getEnrollment() > 0) {
            res += "No Availabilities\n";
        }
        res += "\n";
        res += "Lab Two\n";
        // Check lab two
        if (labTwo.getMorning().getEnrollment() == 0) {
            res += "Morning: Available\n";
        }
        if (labTwo.getAfternoon().getEnrollment() == 0) {
            res += "Afternoon: Available\n";
        } else if (labTwo.getMorning().getEnrollment() > 0 &&
                labTwo.getAfternoon().getEnrollment() > 0) {
            res += "No Availabilities\n";
        }
        res += "\n";
        res += "Lab Three\n";
        // Check lab three
        if (labThree.getMorning().getEnrollment() == 0) {
            res += "Morning: Available\n";
        }
        if (labThree.getAfternoon().getEnrollment() == 0) {
            res += "Afternoon: Available\n";
        } else if (labThree.getMorning().getEnrollment() > 0 &&
                labThree.getAfternoon().getEnrollment() > 0) {
            res += "No Availabilities\n";
        }
        return res;
    }

    public String addReservation(String location, String time, String name, int enrollment) {
        if (labOne.getLocation().equals(location)) {
            if (enrollment > labOne.getCapacity()) {
                return "Error. Capacity exceeded.";
            }
            if (time.equals("morning") && labOne.getMorning().getEnrollment() == 0) {
                labOne.getMorning().setName(name);
                labOne.getMorning().setEnrollment(enrollment);
            } else if (time.equals("afternoon") && labOne.getAfternoon().getEnrollment() == 0) {
                labOne.getAfternoon().setName(name);
                labOne.getAfternoon().setEnrollment(enrollment);
            } else {
                return "Error. Invalid time.";
            }
        } else if (labTwo.getLocation().equals(location)) {
            if (enrollment > labTwo.getCapacity()) {
                return "Error. Capacity exceeded.";
            }
            if (time.equals("morning") && labTwo.getMorning().getEnrollment() == 0) {
                labTwo.getMorning().setName(name);
                labTwo.getMorning().setEnrollment(enrollment);
            } else if (time.equals("afternoon") && labTwo.getAfternoon().getEnrollment() == 0) {
                labTwo.getAfternoon().setName(name);
                labTwo.getAfternoon().setEnrollment(enrollment);
            } else {
                return "Error. Invalid time.";
            }
        } else if (labThree.getLocation().equals(location)) {
            if (enrollment > labThree.getCapacity()) {
                return "Error. Capacity exceeded.";
            }
            if (time.equals("morning") && labThree.getMorning().getEnrollment() == 0) {
                labThree.getMorning().setName(name);
                labOne.getMorning().setEnrollment(enrollment);
            } else if (time.equals("afternoon") && labThree.getAfternoon().getEnrollment() == 0) {
                labThree.getAfternoon().setName(name);
                labThree.getAfternoon().setEnrollment(enrollment);
            } else {
                return "Error. Invalid time.";
            }
        } else {
            return "Error. Invalid location.";
        }
        return "Reservation added!";
    }

    public String removeReservation(String location, String time) {
        if (labOne.getLocation().equals(location)) {
            if (time.equals("morning") && labOne.getMorning().getEnrollment() > 0) {
                labOne.getMorning().setName("");
                labOne.getMorning().setEnrollment(0);
            } else if (time.equals("afternoon") && labOne.getAfternoon().getEnrollment() > 0) {
                labOne.getAfternoon().setName("");
                labOne.getAfternoon().setEnrollment(0);
            } else {
                return "Error. Invalid time";
            }
        } else if (labTwo.getLocation().equals(location)) {
            if (time.equals("morning") && labTwo.getMorning().getEnrollment() > 0) {
                labTwo.getMorning().setName("");
                labTwo.getMorning().setEnrollment(0);
            } else if (time.equals("afternoon") && labTwo.getAfternoon().getEnrollment() > 0) {
                labTwo.getAfternoon().setName("");
                labTwo.getAfternoon().setEnrollment(0);
            } else {
                return "Error. Invalid time";
            }
        } else if (labThree.getLocation().equals(location)) {
            if (time.equals("morning") && labThree.getMorning().getEnrollment() > 0) {
                labThree.getMorning().setName("");
                labThree.getMorning().setEnrollment(0);
            } else if (time.equals("afternoon") && labThree.getAfternoon().getEnrollment() > 0) {
                labThree.getAfternoon().setName("");
                labThree.getAfternoon().setEnrollment(0);
            } else {
                return "Error. Invalid time";
            }
        } else {
            return "Error. Invalid location.";
        }
        return "Reservation removed!";
    }

    public String modifyReservation(String location, String time, String name, int enrollment) {
        if (labOne.getLocation().equals(location)) {
            if (enrollment > labOne.getCapacity()) {
                return "Error. Capacity exceeded.";
            }
            if (time.equals("morning") && labOne.getMorning().getEnrollment() > 0) {
                labOne.getMorning().setName(name);
                labOne.getMorning().setEnrollment(enrollment);
            } else if (time.equals("afternoon") && labOne.getAfternoon().getEnrollment() > 0) {
                labOne.getAfternoon().setName(name);
                labOne.getAfternoon().setEnrollment(enrollment);
            } else {
                return "Error. Invalid time.";
            }
        } else if (labTwo.getLocation().equals(location)) {
            if (enrollment > labTwo.getCapacity()) {
                return "Error. Capacity exceeded.";
            }
            if (time.equals("morning") && labTwo.getMorning().getEnrollment() > 0) {
                labTwo.getMorning().setName(name);
                labTwo.getMorning().setEnrollment(enrollment);
            } else if (time.equals("afternoon") && labTwo.getAfternoon().getEnrollment() > 0) {
                labTwo.getAfternoon().setName(name);
                labTwo.getAfternoon().setEnrollment(enrollment);
            } else {
                return "Error. Invalid time.";
            }
        } else if (labThree.getLocation().equals(location)) {
            if (enrollment > labThree.getCapacity()) {
                return "Error. Capacity exceeded.";
            }
            if (time.equals("morning") && labThree.getMorning().getEnrollment() > 0) {
                labThree.getMorning().setName(name);
                labOne.getMorning().setEnrollment(enrollment);
            } else if (time.equals("afternoon") && labThree.getAfternoon().getEnrollment() > 0) {
                labThree.getAfternoon().setName(name);
                labThree.getAfternoon().setEnrollment(enrollment);
            } else {
                return "Error. Invalid time.";
            }
        } else {
            return "Error. Invalid location.";
        }
        return "Reservation modified!";
    }

    public String toString() {
        return "LabManager{" + labOne.toString() + ", " + labTwo.toString() +
                ", " + labThree.toString() + "}";
    }


    public static void main(String[] args) {
        Session l1s1 = new Session("CS180", 20);
        Session l1s2 = new Session("CS180", 14);
        Session l2s1 = new Session("CS180", 20);
        Session l2s2 = new Session("CS180", 15);
        Session l3s1 = new Session("CS180", 31);
        Session l3s2 = new Session("CS180", 32);
        Lab l1 = new Lab(l1s1, l1s2, 25, "Lawson");
        Lab l2 = new Lab(l2s1, l2s2, 20, "Beering");
        Lab l3 = new Lab(l3s1, l3s2, 36, "WALC");
        LabManager lm = new LabManager(l1, l2, l3);

        System.out.println(lm.toString());
    }
}
