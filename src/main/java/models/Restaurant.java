package models;

public class Restaurant extends Location {

    private String restaurantName;
    private String foodIAte;
    private String restaurantAddress;
    private String description;
    private int locationId;

    public Restaurant(String name, String city, String region, String restaurantName, String foodIAte, String restaurantAddress, String description) {
        super(name, city, region);
        this.restaurantName = restaurantName;
        this.foodIAte = foodIAte;
        this.restaurantAddress = restaurantAddress;
        this.description = description;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getFoodIAte() {
        return foodIAte;
    }

    public void setFoodIAte(String foodIAte) {
        this.foodIAte = foodIAte;
    }

    public String getRetaurantName() {
        return restaurantName;
    }

    public void setRetaurantName(String retaurantName) {
        this.restaurantName = retaurantName;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
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
        if (!restaurantName.equals(that.restaurantName)) return false;
        if (!foodIAte.equals(that.foodIAte)) return false;
        if (!restaurantAddress.equals(that.restaurantAddress)) return false;
        return description.equals(that.description);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + restaurantName.hashCode();
        result = 31 * result + foodIAte.hashCode();
        result = 31 * result + restaurantAddress.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + locationId;
        return result;
    }
}
