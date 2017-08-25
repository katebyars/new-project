package models;

public class Word extends Language {

    private String word;
    private String definition;
    private int languageId;
    private String photo;

    public Word(String name, int id, String word, String definition, int languageId, String photo) {
        super(name, id);
        this.word = word;
        this.definition = definition;
        this.languageId = languageId;
        this.photo = photo;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Word word1 = (Word) o;

        if (languageId != word1.languageId) return false;
        if (!word.equals(word1.word)) return false;
        if (!definition.equals(word1.definition)) return false;
        return photo.equals(word1.photo);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + word.hashCode();
        result = 31 * result + definition.hashCode();
        result = 31 * result + languageId;
        result = 31 * result + photo.hashCode();
        return result;
    }
}
