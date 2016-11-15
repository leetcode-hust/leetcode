package thread.p4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/31.
 */
public class MonitorVehicleTracker {
    private final Map<String, MutablePoint> locations;

    /**构造器*/
    public MonitorVehicleTracker(Map<String, MutablePoint> locations){
        this.locations = deepCopy(locations);
    }

    public  synchronized Map<String, MutablePoint> getLocations(){
        return deepCopy(locations);
    }

    public synchronized MutablePoint getLocation(String id){
        MutablePoint loc = locations.get(id);
        return loc == null ? null :new MutablePoint(loc);
    }

    public synchronized void setLocations(String id, int x, int y){
        MutablePoint loc = locations.get(id);
        if(loc == null)
            throw new IllegalArgumentException("没有该id" + id);

        loc.x = x;
        loc.y = y;

    }

    /**
     *
     */
    private static Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> m) {

        Map<String, MutablePoint> result = new HashMap<String, MutablePoint>();

        for (String id : m.keySet()) {
            result.put(id, new MutablePoint(m.get(id)));
        }

        return Collections.unmodifiableMap(result);
    }


}















