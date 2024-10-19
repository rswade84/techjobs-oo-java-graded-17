package org.launchcode.techjobs.oo;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    // Task 4
    @Test
    public void testSettingJobId() {
        Job setJobOne = new Job();
        Job setJobTwo = new Job();
        assertNotEquals(setJobOne.getId(), setJobTwo.getId()); // Compare the Id's, not objects...
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJobConstructor = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        // Check field values
        assertEquals("Product tester", testJobConstructor.getName());
        assertEquals("ACME", testJobConstructor.getEmployer().getValue());
        assertEquals("Desert", testJobConstructor.getLocation().getValue());
        assertEquals("Quality control", testJobConstructor.getPositionType().getValue());
        assertEquals("Persistence", testJobConstructor.getCoreCompetency().getValue());

        // Check field types
        assertTrue(testJobConstructor.getName() instanceof String);
        assertTrue(testJobConstructor.getEmployer() instanceof Employer);
        assertTrue(testJobConstructor.getLocation() instanceof Location);
        assertTrue(testJobConstructor.getPositionType() instanceof PositionType);
        assertTrue(testJobConstructor.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job firstJob = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        Job secondJob = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertFalse(firstJob.equals(secondJob));
    }

    // Task 5: Build toString method
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJobField = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        String jobString = testJobField.toString();
        String lineSeparator = System.lineSeparator(); // This creates a new line...

        // Check that it starts with a newline....
        assertEquals(lineSeparator, jobString.substring(0, lineSeparator.length()));

        // Check that it ends with a newline....
        assertEquals(lineSeparator, jobString.substring(jobString.length() - lineSeparator.length()));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testToString = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        String expectedOutput = System.lineSeparator() +
                "ID: " + testToString.getId() + System.lineSeparator() +
                "Name: Product tester" + System.lineSeparator() +
                "Employer: ACME" + System.lineSeparator() +
                "Location: Desert" + System.lineSeparator() +
                "Position Type: Quality control" + System.lineSeparator() +
                "Core Competency: Persistence" + System.lineSeparator();
        assertEquals(expectedOutput, testToString.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job testEmptyFields = new Job("",
                new Employer(""),
                new Location(""),
                new PositionType(""),
                new CoreCompetency(""));

        String expectedOutput = System.lineSeparator() +
                "ID: " + testEmptyFields.getId() + System.lineSeparator() +
                "Name: Data not available" + System.lineSeparator() +
                "Employer: Data not available" + System.lineSeparator() +
                "Location: Data not available" + System.lineSeparator() +
                "Position Type: Data not available" + System.lineSeparator() +
                "Core Competency: Data not available" + System.lineSeparator();
        assertEquals(expectedOutput, testEmptyFields.toString());
    }

}