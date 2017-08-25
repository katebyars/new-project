package dao;
import models.Language;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static org.junit.Assert.*;

public class Sql2oLanguageDaoTest {

    private Sql2oLanguageDao languageDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        languageDao = new Sql2oLanguageDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    //helper
    public Language setUpLanguage () {
        return new Language ("Turkish") ;

    }

    @Test
    public void addLanguageAddsALanguageAndAddsToDao_True() throws Exception {
        Language testLanguage = setUpLanguage();
        languageDao.add(testLanguage);
        assertTrue(testLanguage instanceof Language);
        assertEquals(1,languageDao.getAll().size());
    }

    @Test
    public void addLanguageSetsId() throws Exception {               Language testLanguage = setUpLanguage();                      languageDao.add(testLanguage);
        int idOfTest = testLanguage.getId();
        assertEquals(1, idOfTest);
    }

    @Test
    public void getAllLangugesGetsAllLanguages_True() {
        Language testLanguage = setUpLanguage();
        Language testLanguage2 = setUpLanguage();
        Language testLanguage3 = setUpLanguage();
        languageDao.add(testLanguage);
        languageDao.add(testLanguage2);
        languageDao.add(testLanguage3);
        assertEquals(3, languageDao.getAll().size());
    }
//
//    @Test
//    public void getLocationByID_Location() {
//        Location location = setUpLocation();
//        Location location1 = new Location("Hello", "Dolly", "I'm so glad to meet you", "Bye");
//        locationDao.add(location);
//        locationDao.add(location1);
//        assertEquals("Hello", locationDao.findById(2).getName());
//    }
//
//    @Test
//    public void updateChangesName() {
//        Location location = setUpLocation();
//        locationDao.add(location);
//        assertEquals("Ephesus", locationDao.findById(1).getName());
//        locationDao.update(1, "Dionysus", "Sirince", "Western Turkey", "1234 Easy Street");
//        assertEquals("Dionysus", locationDao.findById(1).getName());
//    }
//
//    @Test
//    public void deleteLocationFromDao_True() {
//        Location location = setUpLocation();
//        locationDao.add(location);
//        assertEquals(1, locationDao.getAll().size());
//        locationDao.deleteById(1);
//        assertEquals(0, locationDao.getAll().size());
//    }
//
//    @Test
//    public void deleteAllLocations() {
//        Location location = setUpLocation();
//        locationDao.add(location);
//        assertEquals(1, locationDao.getAll().size());
//        locationDao.deleteAll();
//        assertEquals(0, locationDao.getAll().size());
//    }

}