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
    void update(int id, String city, String region);

    //delete
    void deleteById(int id);
    void deleteAll();
}