package models;

public class Language {

    private String languageName;
    private int id;

    public Language(String languageName) {
        this.languageName = languageName;
    }

    public String getName() {
        return languageName;
    }

    public void setName(String name) {
        this.languageName = languageName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Language language = (Language) o;

        return languageName.equals(language.languageName);
    }

    @Override
    public int hashCode() {
        return languageName.hashCode();
    }
}
