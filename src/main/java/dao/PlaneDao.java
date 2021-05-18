package dao;

import model.Plane;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlaneDao {

    private static PlaneDao entity;
    /**
     * List all planes
     * */
    private List<Plane> planes = new ArrayList<>();
    /**
     * HashMap planes <id, model>
     * */
    private Map<Integer, String> listNamePlanes = new HashMap<>();

    private PlaneDao() {
        String sql = "SELECT * FROM planes inner join planes_in_airport plans on planes.id = plans.id_planes;";
        try (Connection connection = ConnectionManager.get();
             Statement statement = connection.createStatement();) {
            var exucuteResult = statement.executeQuery(sql);
            while (exucuteResult.next()) {
                Plane plane = new Plane();
                plane.setModel(exucuteResult.getString("model"));
                plane.setSeats(exucuteResult.getInt("seats"));
                plane.setSerialNumber(exucuteResult.getString("serial_number"));
                plane.setId(exucuteResult.getInt("id"));
                planes.add(plane);
                listNamePlanes.put(exucuteResult.getInt("id"), exucuteResult.getString("model"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ;
    }

    public static PlaneDao getEntity() {
        if (entity == null) {
            entity = new PlaneDao();
        }
        return entity;
    }

    public String getPlaneById(int id) {
        return listNamePlanes.get(id);
    }

    public List<Plane> getPlanes() {
        return planes;
    }

    public Map<Integer, String> getListNamePlanes() {
        return listNamePlanes;
    }

}
