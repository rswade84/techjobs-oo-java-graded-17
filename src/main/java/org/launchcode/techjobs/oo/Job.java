package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    // Task 3 - #1
    public Job() { this.id = nextId; nextId++;  }

    // Task 3 - Create Full Constructor
    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields match.

    // Task 3 #5

    // equals() and hashCode() methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {  return Objects.hashCode(id);  }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    // Task 3: Getters and Setters...
    public String getName() { return name;}
    public void setName(String name) {  this.name = name;  }
    public Employer getEmployer() {  return employer;  }
    public void setEmployer(Employer employer) {  this.employer = employer;  }
    public Location getLocation() {  return location;  }
    public void setLocation(Location location) {  this.location = location;  }
    public PositionType getPositionType() {  return positionType;  }
    public void setPositionType(PositionType positionType) {  this.positionType = positionType;  }
    public CoreCompetency getCoreCompetency() {  return coreCompetency;  }
    public void setCoreCompetency(CoreCompetency coreCompetency) {  this.coreCompetency = coreCompetency;  }
    public int getId() {  return id;  }

    // Task 5: Custom toString method
    @Override
    public String toString() {
        // Initialize field values or set them to "Data not available" if empty or null
        String nameField = (name == null || name.isEmpty()) ? "Data not available" : name;
        String employerField = (employer == null || employer.getValue().isEmpty()) ? "Data not available" : employer.getValue();
        String locationField = (location == null || location.getValue().isEmpty()) ? "Data not available" : location.getValue();
        String positionTypeField = (positionType == null || positionType.getValue().isEmpty()) ? "Data not available" : positionType.getValue();
        String coreCompetencyField = (coreCompetency == null || coreCompetency.getValue().isEmpty()) ? "Data not available" : coreCompetency.getValue();

        // Check if all fields are empty, except for id...
        if (nameField.equals("Data not available") &&
                employerField.equals("Data not available") &&
                locationField.equals("Data not available") &&
                positionTypeField.equals("Data not available") &&
                coreCompetencyField.equals("Data not available")) {
            return "OOPS! This job does not seem to exist.";
        }

        // Return formatted string with all fields for the toString method...
        return System.lineSeparator() +
                "ID: " + id + System.lineSeparator() +
                "Name: " + nameField + System.lineSeparator() +
                "Employer: " + employerField + System.lineSeparator() +
                "Location: " + locationField + System.lineSeparator() +
                "Position Type: " + positionTypeField + System.lineSeparator() +
                "Core Competency: " + coreCompetencyField + System.lineSeparator();
    }
}