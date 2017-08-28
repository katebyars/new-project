package models;

public class Word extends Language {

    private String word;
    private String definition;
    private int languageId;

    public Word(String languageName, String word, String definition, int languageId) {
        super(languageName);
        this.word = word;
        this.definition = definition;
        this.languageId = languageId;

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
        if (!word.equals(word1.word)) return false;
        return definition.equals(word1.definition);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + word.hashCode();
        result = 31 * result + definition.hashCode();
        result = 31 * result + languageId;
        return result;
    }
}
