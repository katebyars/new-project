package dao;

import models.Language;
import models.Location;
import models.Phrase;
import models.Word;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oPhraseDao implements PhraseDao {

    private final Sql2o sql2o;

    public Sql2oPhraseDao (Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(Phrase phrase) {
        String sql = "INSERT INTO phrases (phrase, definition, languageid, wordid) VALUES (:phrase, :definition, :languageid, :wordid)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql)
                    .bind(phrase)
                    .executeUpdate()
                    .getKey();
            phrase.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public List<Phrase> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM phrases")
                    .executeAndFetch(Phrase.class);
        }

    }

    @Override
    public Phrase findById(int id) {
        try (Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM phrases WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Phrase.class);
        }

    }

    @Override
    public List<Phrase> getAllPhrasesThatHaveASingleWord(Word word){
        return  null;
    }

    @Override
    public List<Phrase> getAllPhrasesByLanguage(Language language){
        return null;
    }

    @Override
    public void update(int id, String phrase, String definition, String languageid, String wordid){
        String sql = "UPDATE phrases SET phrases = :phrase, defintion = :definition, languageid = :languageid, wordid = :wordid WHERE id=:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("phrase", phrase)
                    .addParameter("defintion", definition)
                    .addParameter("languageid", languageid)
                    .addParameter("wordid", wordid)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from phrases WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }

    }

    @Override
    public void deleteAll() {
        String sql = "DELETE from phrases";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
