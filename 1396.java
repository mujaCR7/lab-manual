import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    // Stores active check-ins: customer ID -> CheckInInfo(stationName, checkInTime)
    private Map<Integer, CheckInInfo> checkInMap;
    
    // Stores route statistics: routeKey ("startStation->endStation") -> RouteStats(totalTime, totalTrips)
    private Map<String, RouteStats> routeMap;

    private static class CheckInInfo {
        String stationName;
        int checkInTime;

        CheckInInfo(String stationName, int checkInTime) {
            this.stationName = stationName;
            this.checkInTime = checkInTime;
        }
    }

    private static class RouteStats {
        double totalTime;
        int count;

        RouteStats(double totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
    }

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInInfo(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckInInfo info = checkInMap.remove(id);
        String routeKey = info.stationName + "->" + stationName;
        int duration = t - info.checkInTime;

        RouteStats stats = routeMap.getOrDefault(routeKey, new RouteStats(0, 0));
        stats.totalTime += duration;
        stats.count++;
        routeMap.put(routeKey, stats);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        RouteStats stats = routeMap.get(routeKey);
        return stats.totalTime / stats.count;
    }
}
