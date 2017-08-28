package models;

public class Location {

    private String city;
    private String region;
    private int id;

    public Location(String city, String region) {
        this.city = city;
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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

        Location location = (Location) o;

        if (id != location.id) return false;
        if (!city.equals(location.city)) return false;
        return region.equals(location.region);
    }

    @Override
    public int hashCode() {
        int result = city.hashCode();
        result = 31 * result + region.hashCode();
        result = 31 * result + id;
        return result;
    }
}
