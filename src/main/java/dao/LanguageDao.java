package dao;

import models.Language;

import java.util.List;

public interface LanguageDao {

    //create
    void add(Language language);

    //read
    List<Language> getAll();
    Language findById(int id);

    //update
    void update(int id, String languagename);

    //delete
    void deleteById(int id); //see above
    void deleteAll();
}