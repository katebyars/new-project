package models;

public class Location {

    private String name;
    private String City;
    private String Region;
    private String address;
    private int id;

    public Location(String name, String city, String region, String address) {
        this.name = name;
        City = city;
        Region = region;
        this.address = address;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        if (!name.equals(location.name)) return false;
        if (City != null ? !City.equals(location.City) : location.City != null) return false;
        if (Region != null ? !Region.equals(location.Region) : location.Region != null) return false;
        return address != null ? address.equals(location.address) : location.address == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (City != null ? City.hashCode() : 0);
        result = 31 * result + (Region != null ? Region.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
