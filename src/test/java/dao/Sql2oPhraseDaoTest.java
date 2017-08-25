package dao;
import models.Phrase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oPhraseDaoTest {
    private Sql2oPhraseDao phraseDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        phraseDao = new Sql2oPhraseDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    //helper
    public Phrase setUpAPhrase () {
        return new Phrase ("Turkish", "Gurusuruz", "See you later") ;

    }

    @Test
    public void addAPhraseAddsAPhrase () throws Exception {
        Phrase phrase = setUpAPhrase();
        assertTrue(phrase instanceof Phrase);
    }


    @Test
    public void addPhraseToDao_True() throws Exception {
        Phrase phrase1 = setUpAPhrase();
        phraseDao.add(phrase1);
        assertEquals(1, phraseDao.getAll().size());
    }

    @Test
    public void addPhraseSetsId() throws Exception {
        Phrase phrase1 = setUpAPhrase();
        phraseDao.add(phrase1);
        int idOfPhrase = phrase1.getId();
        assertEquals(1, idOfPhrase);
    }

    @Test
    public void getAllPhrasesAddsAPhrase_True() {
        Phrase test = setUpAPhrase();
        Phrase test2 = setUpAPhrase();
        Phrase test3 = setUpAPhrase();
        phraseDao.add(test);
        phraseDao.add(test2);
        phraseDao.add(test3);
        assertEquals(3, phraseDao.getAll().size());
    }

    @Test
    public void getPhraseById() {
        Phrase location = setUpAPhrase();
        Phrase location1 = new Phrase("Italian", "Sono stanca", "I am tired.");
        phraseDao.add(location);
        phraseDao.add(location1);
        assertEquals("Italian", phraseDao.findById(2).getName());
    }
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