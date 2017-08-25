package dao;

import models.Location;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oLocationDaoTest {

    private Sql2oLocationDao locationDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        locationDao = new Sql2oLocationDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    //helper
    public Location setUpLocation () {
        return new Location ("Ephesus", "Western Turkey", "Turkey", "1234 Main Street Ephesus, Turkey") ;

    }

    @Test
    public void addLocationAddsALocation() throws Exception {
        Location locationTest = setUpLocation();
        locationDao.add(locationTest);
        int newLocationId = locationTest.getId();
        assertTrue(locationTest instanceof Location);
    }

    @Test
    public void addLocationSetsId() throws Exception {
        Location testLocation = setUpLocation();
        locationDao.add(testLocation);
        int idOfTest = testLocation.getId();
        assertEquals(1, idOfTest);
    }

    @Test
    public void getAllLocationsGetsAllLocations_True() {
        Location locationTest = setUpLocation();
        Location locationTest2 = setUpLocation();
        Location locationTest3 = setUpLocation();
        locationDao.add(locationTest);
        locationDao.add(locationTest2);
        locationDao.add(locationTest3);
        assertEquals(3, locationDao.getAll().size());
    }

    @Test
    public void getLocationByID_Location() {
        Location location = setUpLocation();
        Location location1 = new Location("Hello", "Dolly", "I'm so glad to meet you", "Bye");
        locationDao.add(location);
        locationDao.add(location1);
        assertEquals("Hello", locationDao.findById(2).getName());
    }

    @Test
    public void updateChangesName() {
        Location location = setUpLocation();
        locationDao.add(location);
        assertEquals("Ephesus", locationDao.findById(1).getName());
        locationDao.update(1, "Dionysus", "Sirince", "Western Turkey", "1234 Easy Street");
        assertEquals("Dionysus", locationDao.findById(1).getName());
    }

    @Test
    public void deleteLocationFromDao_True() {
        Location location = setUpLocation();
        locationDao.add(location);
        assertEquals(1, locationDao.getAll().size());
        locationDao.deleteById(1);
        assertEquals(0, locationDao.getAll().size());
    }

    @Test
    public void deleteAllLocations() {
        Location location = setUpLocation();
        locationDao.add(location);
        assertEquals(1, locationDao.getAll().size());
        locationDao.deleteAll();
        assertEquals(0, locationDao.getAll().size());
    }
}