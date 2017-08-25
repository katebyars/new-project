package models;

public class Language {

    private String name;
    private int id;


    public Language(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Language language = (Language) o;

        return name.equals(language.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
