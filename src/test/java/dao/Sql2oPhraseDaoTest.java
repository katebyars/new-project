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
        Phrase phrase = setUpAPhrase();
        Phrase phrase1 = new Phrase("Italian", "Sono stanca", "I am tired.");
        phraseDao.add(phrase);
        phraseDao.add(phrase1);
        assertEquals("Italian", phraseDao.findById(2).getName());
    }

    @Test
    public void updateChangesName() {
        Phrase phrase = setUpAPhrase();
        phraseDao.add(phrase);
        assertEquals("Turkish", phraseDao.findById(1).getName());
        phraseDao.update("Italian", "Ho freddo", "I am cold.", 1);
        assertEquals("Italian", phraseDao.findById(1).getName());
    }

    @Test
    public void deleteLocationFromDao_True() {
        Phrase phrase = setUpAPhrase();
        phraseDao.add(phrase);
        assertEquals(1, phraseDao.getAll().size());
        phraseDao.deleteById(1);
        assertEquals(0, phraseDao.getAll().size());
    }

    @Test
    public void deleteAllLocations() {
        Phrase phrase = setUpAPhrase();
        phraseDao.add(phrase);
        assertEquals(1, phraseDao.getAll().size());
        phraseDao.deleteAll();
        assertEquals(0, phraseDao.getAll().size());
    }

}