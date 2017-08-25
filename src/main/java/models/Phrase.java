package models;

public class Phrase extends Language {

    private String phrase;
    private String definition;
    private int wordId;

    public Phrase(String name, String phrase, String definition) {
        super(name);
        this.phrase = phrase;
        this.definition = definition;
        this.wordId = wordId;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Phrase phrase1 = (Phrase) o;

        if (wordId != phrase1.wordId) return false;
        if (!phrase.equals(phrase1.phrase)) return false;
        return definition.equals(phrase1.definition);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + phrase.hashCode();
        result = 31 * result + definition.hashCode();
        result = 31 * result + wordId;
        return result;
    }
}
