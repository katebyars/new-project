package dao;

import com.sun.org.apache.regexp.internal.RE;
import models.Location;
import models.Residence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oResidenceDaoTest {
    private Sql2oResidenceDao residenceDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        residenceDao = new Sql2oResidenceDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    //helper
    public Residence setUpResidence () {
        return new Residence ("Istanbul", "Western Turkey", "Dolly and Akmet", "kebabs", "Wonderful dinner", "1234 Easy Street");
    }

    @Test
    public void addResidenceaddsResidence() throws Exception {
        Residence residence = setUpResidence();
        residenceDao.add(residence);
        int newLocationId = residence.getId();
        assertTrue(residence instanceof Location);
    }
    @Test
    public void addResidenceAddsToDao() throws Exception {
        Residence residence = setUpResidence();
        residenceDao.add(residence);
        assertEquals(1, residenceDao.getAll().size());
    }

    @Test
    public void addResidenceSetsId() throws Exception {
        Residence residence = setUpResidence();
        residenceDao.add(residence);
        int idOfTest = residence.getId();
        assertEquals(1, idOfTest);
    }

    @Test
    public void getAllResidences_True() {
        Residence residence1 = setUpResidence();
        Residence residence2 = setUpResidence();
        Residence residence3 = setUpResidence();
        residenceDao.add(residence1);
        residenceDao.add(residence2);
        residenceDao.add(residence3);
        assertEquals(3, residenceDao.getAll().size());
    }

    @Test
    public void getResidenceById_True() {
        Residence residence1 = setUpResidence();
        Residence residence2 = setUpResidence();
        Residence residence3 = new Residence("Ephesus", "Western Turkey", "Dolly and Akmet", "kebabs", "Wonderful dinner", "1234 Easy Street");
        residenceDao.add(residence1);
        residenceDao.add(residence2);
        residenceDao.add(residence3);
        assertEquals("Ephesus", residenceDao.findById(3).getCity());
    }

    @Test
    public void updateChangesName() {
        Residence residence = setUpResidence();
        residenceDao.add(residence);
        assertEquals("Istanbul", residenceDao.findById(1).getCity());
        residenceDao.update(1, "Dolly", "kebabs", "great kababs", "1234 Easy Street");
        assertEquals("Dolly", residenceDao.findById(1).getResidenceOwner());
    }

    @Test
    public void deleteLocationFromDao_True() {
        Residence residence = setUpResidence();
        residenceDao.add(residence);
        assertEquals(1, residenceDao.getAll().size());
        residenceDao.deleteById(1);
        assertEquals(0, residenceDao.getAll().size());
    }

    @Test
    public void deleteAllLocations() {
        Residence residence = setUpResidence();
        residenceDao.add(residence);
        assertEquals(1, residenceDao.getAll().size());
        residenceDao.deleteAll();
        assertEquals(0, residenceDao.getAll().size());
    }

}