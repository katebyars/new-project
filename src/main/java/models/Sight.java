package models;

public class Sight extends Location {

    private String name;
    private String address;
    private String description;
    private int locationId;


    public Sight(String name, String city, String region, String address, int id, String name1, String address1, String description, int locationId) {
        super(name, city, region, address, id);
        this.name = name1;
        this.address = address1;
        this.description = description;
        this.locationId = locationId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Sight sight = (Sight) o;

        if (locationId != sight.locationId) return false;
        if (!name.equals(sight.name)) return false;
        if (!address.equals(sight.address)) return false;
        return description.equals(sight.description);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + locationId;
        return result;
    }
}
