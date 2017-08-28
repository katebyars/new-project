package models;

public class Residence extends Location {

    private String residenceowner;
    private String foodiate;
    private String description;
    private String residenceaddress;
    private int locationId;

    public Residence(String city, String region, String residenceowner, String foodiate, String description, String residenceaddress) {
        super(city, region);
        this.residenceowner = residenceowner;
        this.foodiate = foodiate;
        this.description = description;
        this.residenceaddress = residenceaddress;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getResidenceowner() {return residenceowner;}

    public void setResidenceowner(String residenceowner) {this.residenceowner = residenceowner;}

    public String getResidenceaddress() {return residenceaddress;}

    public void setResidenceaddress(String residenceaddress) {this.residenceaddress = residenceaddress;}

    public String getFoodiate() {
        return foodiate;
    }

    public void setFoodiate(String foodiate) {
        this.foodiate = foodiate;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Residence residence = (Residence) o;

        if (!residenceowner.equals(residence.residenceowner)) return false;
        if (!foodiate.equals(residence.foodiate)) return false;
        return description.equals(residence.description);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + residenceowner.hashCode();
        result = 31 * result + foodiate.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }
}
