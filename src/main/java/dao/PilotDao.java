package dao;

import model.Pilot;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PilotDao {
    private static PilotDao entity;
    /**
     * HashMap pilots <identificationCode, Pilot>
     * */
    private Map<Integer, Pilot> mapPilots = new HashMap<>();
    /**
     * List pilots <Pilot>
     * */
    private List<Pilot> listPilots = new ArrayList<>();

    public static PilotDao getEntity() {
        if (entity == null) {
            entity = new PilotDao();
        }
        return entity;
    }

    private PilotDao() {
        String sql = "SELECT * FROM pilots inner join planes pl on pilots.id_planes = pl.id;";
        try (Connection connection = ConnectionManager.get();
             Statement statement = connection.createStatement();) {
            var exucuteResult = statement.executeQuery(sql);
            while (exucuteResult.next()) {
                Pilot pilot = new Pilot();
                pilot.setId(exucuteResult.getInt("id"));
                int identificationCode = exucuteResult.getInt("identification_code");
                pilot.setIdentificationCode(identificationCode);
                pilot.setAge(exucuteResult.getInt("age"));
                pilot.setName(exucuteResult.getString("name"));
                int idPlanes = exucuteResult.getInt("id_planes");
                if (mapPilots.get(identificationCode) == null) {
                    pilot.setNamePlaneList(PlaneDao.getEntity().getPlaneById(idPlanes));
                    mapPilots.put(identificationCode, pilot);
                    listPilots.add(pilot);
                } else {
                    mapPilots.get(identificationCode).setNamePlaneList(PlaneDao.getEntity().getPlaneById(idPlanes));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ;
    }

    public List<Pilot> getListPilots() {
        return listPilots;
    }

    public Map<Integer, Pilot> getListPilot() {
        return mapPilots;
    }

}
