package models;

public class Word extends Language {

    private String word;
    private String definition;
    private int languageId;
    private int id;

    public Word (String word, String name) {
        super(name);
        this.word = word;
        this.definition = "unknown";
        this.id = id;
        this.languageId = languageId;

    }

    public Word(String name, String word, String definition) {
        super(name);
        this.word = word;
        this.definition = definition;
        this.languageId = languageId;
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Word word1 = (Word) o;

        if (languageId != word1.languageId) return false;
        if (id != word1.id) return false;
        if (!word.equals(word1.word)) return false;
        return definition != null ? definition.equals(word1.definition) : word1.definition == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + word.hashCode();
        result = 31 * result + (definition != null ? definition.hashCode() : 0);
        result = 31 * result + languageId;
        result = 31 * result + id;
        return result;
    }
}
