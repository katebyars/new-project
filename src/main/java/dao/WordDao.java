package dao;

import models.Phrase;
import models.Word;

import java.util.List;

public interface WordDao {
    //create
    void add(Word word);
    //read

    List<Word> getAll();
    Word findById(int id);

    //update
    void update (String word, String definition, int id);
//
//    //delete
//    void deleteById(int id);
}
