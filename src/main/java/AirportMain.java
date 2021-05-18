import dao.PilotDao;
import dao.PlaneDao;
import model.Pilot;
import model.Plane;

import java.util.List;
import java.util.stream.Collectors;

public class AirportMain {
    public static void main(String[] args) {
        /**
         * Counting seats
         */
        int countSeats = getListPlanesWithPilots().stream()
                .map(Plane::getSeats)
                .reduce(Integer::sum)
                .orElse(0);
        System.out.println("Total seats: " + countSeats);
    }

    /**
     * Returns list planes with pilots
     */
    private static List<Plane> getListPlanesWithPilots() {
        return PlaneDao.getEntity().getPlanes()
                .stream()
                .filter(plane -> isLandingOfAvailablePilotsOnPlanes(plane, PilotDao.getEntity().getListPilots()))
                .collect(Collectors.toList());
    }

    /**
     * Landing of available pilots on the planes
     */
    private static boolean isLandingOfAvailablePilotsOnPlanes(Plane plane, List<Pilot> pilots) {
        List<Pilot> pilotList = pilots.stream()
                .filter(pilot -> pilot.getNamePlaneList().contains(plane.getModel()))
                .limit(2)
                .collect(Collectors.toList());
        if (pilotList.size() != 2) {
            return false;
        }
        pilots.removeAll(pilotList);
        System.out.println("Plane model:" + plane.getModel() + " Pilots:" + pilotList.toString());
        return true;
    }

}
