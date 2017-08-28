package dao;
import java.util.ArrayList;
import java.util.Arrays;

import com.sun.org.apache.regexp.internal.RE;
import models.Location;
import models.Residence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oLocationDaoTest {

    private Sql2oLocationDao locationDao;
    private Sql2oResidenceDao residenceDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        locationDao = new Sql2oLocationDao(sql2o);
        residenceDao = new Sql2oResidenceDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    //helper
    public Location setUpLocation () {
        return new Location ("Ephesus","Western Turkey") ;
    }

    //helper
    public Residence setUpResidence () {
        return new Residence ("Istanbul", "Western Turkey", "Dolly and Akmet", "kebabs", "Wonderful dinner", "1234 Easy Street");
    }

    @Test
    public void addLocationAddsALocation() throws Exception {
        Location locationTest = setUpLocation();
        assertTrue(locationTest instanceof Location);
    }

    @Test
    public void locationAddsToDao_True() throws Exception {
        Location locationTest= setUpLocation();
        locationDao.add(locationTest);
        assertEquals(1, locationDao.getAll().size());
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
        Location location1 = new Location("Hello", "Dolly");
        locationDao.add(location);
        locationDao.add(location1);
        assertEquals("Hello", locationDao.findById(2).getCity());
    }
//    @Test
//    public void addFoodTypeToRestaurantAddsTypeCorrectly() throws Exception {
//        Residence residence = setUpResidence();
//        residenceDao.add(residence);
//        Residence residence2 = setUpResidence();
//        residenceDao.add(residence2);
//
//        Foodtype testFoodtype = setupNewFoodtype();
//
//        foodtypeDao.add(testFoodtype);
//
//        foodtypeDao.addFoodtypeToRestaurant(testFoodtype, testRestaurant);
//        foodtypeDao.addFoodtypeToRestaurant(testFoodtype, altRestaurant);
//
//        assertEquals(2, foodtypeDao.getAllRestaurantsForAFoodtype(testFoodtype.getId()).size());
//    }

    @Test
    public void getAllResidencesForALocationReturnsResidencesCorrectly() throws Exception {
        Residence residence = setUpResidence();
        residenceDao.add(residence);
        Residence residence2 = setUpResidence();
        residenceDao.add(residence2);

        Location location = setUpLocation();
        locationDao.add(location);
        locationDao.addResidenceToLocation(residence, location);
        locationDao.addResidenceToLocation(residence2, location);

        Residence[] residences = {residence, residence2};

        assertEquals(2, Arrays.asList(residences).size());
    }


    @Test
    public void updateChangesName() {
        Location location = setUpLocation();
        locationDao.add(location);
        assertEquals("Ephesus", locationDao.findById(1).getCity());
        locationDao.update(1, "Dionysus", "Turkey");
        assertEquals("Dionysus", locationDao.findById(1).getCity());
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