package dao;
import models.Location;
import models.Residence;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oResidenceDao implements ResidenceDao {

    private final Sql2o sql2o;

    public Sql2oResidenceDao (Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(Residence residence) {
        String sql = "INSERT INTO residences (city, region, residenceowner, foodiate, description, residenceAddress) VALUES (:city, :region, :residenceowner, :foodiate, :description, :residenceAddress)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql)
                    .bind(residence)
                    .executeUpdate()
                    .getKey();
            residence.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public List<Residence> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM residences")
                    .executeAndFetch(Residence.class);
        }

    }

    @Override
    public Residence findById(int id) {
        try (Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM residences WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Residence.class);
        }

    }

    @Override
    public List<Residence> getAllResidencesByLocation(int locationId) {
        return null;
    }

    @Override
    public void update(int id, String residenceowner, String foodiate, String description, String residenceaddress) {
        String sql = "UPDATE residences residenceowner = :residenceowner, foodiate = :foodiate, description = :description, residenceaddress = :residenceaddress, locationid = :locationid WHERE id=:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("residenceOwner", residenceowner)
                    .addParameter("foodiate", foodiate)
                    .addParameter("description", description)
                    .addParameter("residenceaddress", residenceaddress)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from residences WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }

    }

    @Override
    public void deleteAll() {
        String sql = "DELETE from residences";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }




}
