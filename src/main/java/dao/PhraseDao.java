package dao;

import models.Language;
import models.Phrase;
import models.Word;

import java.util.List;

public interface PhraseDao {
    //create
    void add(Phrase phrase);

    //read
    List<Phrase> getAll();
    Phrase findById(int id);
    List<Phrase> getAllPhrasesByLanguage(Language language);
    List<Phrase> getAllPhrasesThatHaveASingleWord(Word word);


    //update
    void update(String name, String phrase, String definition, int id);

    //delete
    void deleteById(int id); //see above
    void deleteAll();
}