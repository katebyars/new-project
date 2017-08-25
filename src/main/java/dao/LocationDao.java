package dao;
import models.Location;
import java.util.List;

public interface LocationDao {
    //create
    void add(Location location);

    //read
    List<Location> getAll();
    Location findById(int id);

    //update
    void update(int id, String name, String ciyt, String region, String address);

    //delete
    void deleteById(int id);
    void deleteAll();
}
