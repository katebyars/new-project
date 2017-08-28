package models;

public class Language {

    private String languagename;
    private int id;

    public Language(String languagename) {

        this.languagename = languagename;
    }

    public String getlanguagename() {
        return languagename;
    }

    public void setLanguageName(String languagename) {
        this.languagename = languagename;
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

        return languagename.equals(language.languagename);
    }

    @Override
    public int hashCode() {
        return languagename.hashCode();
    }
}
