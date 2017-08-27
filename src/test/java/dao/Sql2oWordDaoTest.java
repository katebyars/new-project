package dao;

import models.Word;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oWordDaoTest {

    private Sql2oWordDao wordDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        wordDao = new Sql2oWordDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }


    //helper
    public Word setUpAWord () {
        return new Word ("Italian", "Ciao", "Hello") ;

    }

    @Test
    public void addAWord () throws Exception {
        Word word = setUpAWord();
        assertTrue(word instanceof  Word);
    }


    @Test
    public void addWordToDao_True() throws Exception {
        Word word = setUpAWord();
        wordDao.add(word);
        assertEquals(1, wordDao.getAll().size());
    }

    @Test
    public void addWordSetsID() throws Exception {
        Word word = setUpAWord();
        wordDao.add(word);
        int idOfWord = word.getId();
        assertEquals(1, idOfWord);
    }

    @Test
    public void getAllWords() {
        Word word = setUpAWord();
        Word word2 = setUpAWord();
        Word word3 = setUpAWord();
        wordDao.add(word);
        wordDao.add(word2);
        wordDao.add(word3);
        assertEquals(3, wordDao.getAll().size());
    }
//
//    @Test
//    public void getWordById() {
//        Word word = setUpAWord();
//        Word word2 = new Word("Italian", "Sono", "I am");
//        wordDao.add(word);
//        wordDao.add(word2);
//        assertEquals("Italian", wordDao.findById(2).getName());
//    }
//
//    @Test
//    public void updateChangesName() {
//        Word word = setUpAWord();
//        wordDao.add(word);
//        assertEquals("Italian", wordDao.findById(1).getName());
//        wordDao.update("Italian", "Ho", "I", 1);
//        assertEquals("Italian", wordDao.findById(1).getName());
//    }
//
//    @Test
//    public void deleteAWordFromDao_True() {
//        Word word = setUpAWord();
//        wordDao.add(word);
//        assertEquals(1, wordDao.getAll().size());
//        wordDao.deleteById(1);
//        assertEquals(0, wordDao.getAll().size());
//    }
//
//    @Test
//    public void deleteAllLocations() {
//        Word word = setUpAWord();
//        wordDao.add(word);
//        assertEquals(1, wordDao.getAll().size());
//        wordDao.deleteAll();
//        assertEquals(0, wordDaod.getAll().size());
//    }

}