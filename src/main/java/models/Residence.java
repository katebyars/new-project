package models;

public class Residence extends Location {

    private String residenceOwner;
    private String foodIAte;
    private String description;

    public Residence(String name, String city, String region, String address, String residenceOwner, String foodIAte, String description) {
        super(name, city, region, address);
        this.residenceOwner = residenceOwner;
        this.foodIAte = foodIAte;
        this.description = description;
    }

    public String getResidenceOwner() {
        return residenceOwner;
    }

    public void setResidenceOwner(String residenceOwner) {
        this.residenceOwner = residenceOwner;
    }

    public String getFoodIAte() {
        return foodIAte;
    }

    public void setFoodIAte(String foodIAte) {
        this.foodIAte = foodIAte;
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

        if (!residenceOwner.equals(residence.residenceOwner)) return false;
        if (!foodIAte.equals(residence.foodIAte)) return false;
        return description.equals(residence.description);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + residenceOwner.hashCode();
        result = 31 * result + foodIAte.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }
}
