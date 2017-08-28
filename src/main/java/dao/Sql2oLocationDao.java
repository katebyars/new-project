package dao;
import models.Location;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import java.util.List;

public class Sql2oLocationDao implements LocationDao {


    private final Sql2o sql2o;

    public Sql2oLocationDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(Location location) {
        String sql = "INSERT INTO locations (city, region) VALUES (:city, :region)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql)
                    .bind(location)
                    .executeUpdate()
                    .getKey();
            location.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public List<Location> getAll() {
            try(Connection con = sql2o.open()){
                return con.createQuery("SELECT * FROM locations")
                        .executeAndFetch(Location.class);
            }

    }

    @Override
    public Location findById(int id) {
        try (Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM locations WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Location.class);
        }

    }

    @Override
    public void update(int id, String city, String region){
        String sql = "UPDATE locations SET city = :city, region = :region WHERE id=:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("city", city)
                    .addParameter("region", region)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from locations WHERE id=:id";
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
        String sql = "DELETE from locations";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}