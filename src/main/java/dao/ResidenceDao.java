package dao;

import com.sun.org.apache.regexp.internal.RE;
import models.Location;
import models.Residence;

import java.util.List;

public interface ResidenceDao {

    //create
    void add(Residence residence);

    //read
    List<Residence> getAll();
    Residence findById(int id);
    List<Residence> getAllResidencesByLocation(int locationId);


    //update
    void update(int id, String name, String city, String region, String address, String owner, String foodiate, String description);

    //delete
    void deleteById(int id); //see above
    void deleteAll();
}
