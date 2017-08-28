package dao;
import models.Word;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import java.util.List;

public class Sql2oWordDao implements WordDao {

    private final Sql2o sql2o;
    public Sql2oWordDao (Sql2o sql2o){
        this.sql2o = sql2o;
    }


    @Override
    public void add(Word word) {
        String sql = "INSERT INTO words (word, definition, languageId) VALUES (:word, :definition, :languageId)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(word)
                    .executeUpdate()
                    .getKey();
            word.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Word> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM words")
                    .executeAndFetch(Word.class);
        }

    }

    @Override
    public Word findById(int id) {
        try (Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM words WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Word.class);
        }

    }

    @Override
    public void update(String word, String definition, int id){
        String sql = "UPDATE words SET word = :word, definition = :definition WHERE id = :id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("word", word)
                    .addParameter("definition", definition)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from words WHERE id=:id";
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
        String sql = "DELETE from words";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}