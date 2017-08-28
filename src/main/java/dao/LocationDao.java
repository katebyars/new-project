package dao;
import models.Location;
import models.Residence;

import java.util.List;

public interface LocationDao {
    //create
    void add(Location location);
    void addResidenceToLocation(Residence residence, Location location);

    //read
    List<Location> getAll();
    Location findById(int id);
    List<Residence> getResidencebyLocation(int locationId);

    //update
    void update(int id, String city, String region);

    //delete
    void deleteById(int id);
    void deleteAll();
}
