package models;

public class Restaurant extends Location {

    private String name;
    private String foodIAte;
    private String address;
    private String description;
    private int locationId;

    public Restaurant(String name, String city, String region, String address, int id, String name1, String foodIAte, String address1, String description, int locationId) {
        super(name, city, region, address, id);
        this.name = name1;
        this.foodIAte = foodIAte;
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

    public String getFoodIAte() {
        return foodIAte;
    }

    public void setFoodIAte(String foodIAte) {
        this.foodIAte = foodIAte;
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

        Restaurant that = (Restaurant) o;

        if (locationId != that.locationId) return false;
        if (!name.equals(that.name)) return false;
        if (!foodIAte.equals(that.foodIAte)) return false;
        if (!address.equals(that.address)) return false;
        return description.equals(that.description);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + foodIAte.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + locationId;
        return result;
    }
}
