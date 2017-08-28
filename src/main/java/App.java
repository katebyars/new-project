import com.google.gson.Gson;
import dao.Sql2oWordDao;
import dao.Sql2oLanguageDao;
import dao.Sql2oPhraseDao;
import exceptions.ApiException;
import models.Word;
import models.Language;
import models.Phrase;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        Sql2oPhraseDao phraseDao;
        Sql2oLanguageDao languageDao;
        Sql2oWordDao wordDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/studyabroad.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        wordDao = new Sql2oWordDao(sql2o);
        phraseDao = new Sql2oPhraseDao(sql2o);
        languageDao = new Sql2oLanguageDao(sql2o);
        conn = sql2o.open();


        //CREATE

        //a new word
        post("/languages/:languageId/words/new", "application/json", (req, res) -> {
            int languageId = Integer.parseInt(req.params("languageId"));
            Word word = gson.fromJson(req.body(), Word.class);
            word.setLanguageId(languageId);
            wordDao.add(word);
            res.status(201);
            return gson.toJson(word);
        });

        //a new phrase
        post("/languages/:languageId/phrases/new", "application/json", (req, res) -> {
            int languageId = Integer.parseInt(req.params("languageId"));
            Phrase phrase = gson.fromJson(req.body(), Phrase.class);
            phrase.setLanguageid(languageId);
            phraseDao.add(phrase);
            res.status(201);
            return gson.toJson(phrase);
        });

        //a new language
        post("/languages/new", "application/json", (req, res) -> {
            Language language = gson.fromJson(req.body(), Language.class);
            languageDao.add(language);
            res.status(201);;
            return gson.toJson(language);
        });



        //READ
        get("/languages", "application/json", (req, res) -> {
            return gson.toJson(languageDao.getAll());
        });

        get("/languages/:id", "application/json", (req, res) -> {
            int restaurantId = Integer.parseInt(req.params("id"));

            Language languageToFind = languageDao.findById(restaurantId);

            if (languageToFind == null){
                throw new ApiException(404, String.format("No langyage with the id: \"%s\" exists", req.params("id")));
            }

            return gson.toJson(languageToFind);
        });

        get("/words", "application/json", (req, res) -> {
            int languageId = Integer.parseInt(req.params("id"));

            List<Word> allWords = wordDao.getAll();
            return gson.toJson(allWords);
        });

        get("/phrases", "application/json", (req, res) -> {
            int languageId = Integer.parseInt(req.params("id"));

            List<Phrase> allPhrases = phraseDao.getAll();
            return gson.toJson(allPhrases);
        });

        //read all phrases by Language ID
        //read all words by language ID


        //FILTERS
        exception(ApiException.class, (exception, req, res) -> {
            ApiException err = (ApiException) exception;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json");
            res.status(err.getStatusCode());
            res.body(gson.toJson(jsonMap));
        });

        after((req, res) ->{
            res.type("application/json");
        });
    }
}