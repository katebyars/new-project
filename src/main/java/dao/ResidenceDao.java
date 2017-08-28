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


    //update
    void update(int id, String city, String region, String residenceowner, String foodiate, String description, String residenceaddress);

    //delete
    void deleteById(int id); //see above
    void deleteAll();
}
