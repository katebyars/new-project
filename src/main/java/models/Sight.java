package models;

public class Sight extends Location {

    private String siteName;
    private String siteAddress;
    private String siteDescription;
    private int locationId;


    public Sight(String city, String region, String siteName, String siteAddress, String siteDescription) {
        super(city, region);
        this.siteName = siteName;
        this.siteAddress = siteAddress;
        this.siteDescription = siteDescription;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteAddress() {
        return siteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress;
    }

    public String getSiteDescription() {
        return siteDescription;
    }

    public void setSiteDescription(String siteDescription) {
        this.siteDescription = siteDescription;
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
        if (!siteName.equals(sight.siteName)) return false;
        if (!siteAddress.equals(sight.siteAddress)) return false;
        return siteDescription.equals(sight.siteDescription);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + siteName.hashCode();
        result = 31 * result + siteAddress.hashCode();
        result = 31 * result + siteDescription.hashCode();
        result = 31 * result + locationId;
        return result;
    }
}
