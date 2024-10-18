package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;



public class JobTest {
    //TODO: Create your unit tests here

    // Task 4:

    @Test
    public void testSettingJobId() {
        Job jobOne = new Job();
        Job jobTwo = new Job();
        assertNotEquals(jobOne.getId(), jobTwo.getId()); // Compare the Id's, not objects...
    }


    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJobField = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        // Check field values
        assertEquals("Product tester", testJobField.getName());
        assertEquals("ACME", testJobField.getEmployer().getValue());
        assertEquals("Desert", testJobField.getLocation().getValue());
        assertEquals("Quality control", testJobField.getPositionType().getValue());
        assertEquals("Persistence", testJobField.getCoreCompetency().getValue());

        // Check field types
        assertTrue(testJobField.getName() instanceof String);
        assertTrue(testJobField.getEmployer() instanceof Employer);
        assertTrue(testJobField.getLocation() instanceof Location);
        assertTrue(testJobField.getPositionType() instanceof PositionType);
        assertTrue(testJobField.getCoreCompetency() instanceof CoreCompetency);
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

    }