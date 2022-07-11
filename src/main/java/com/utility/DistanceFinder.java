package com.utility;

import com.models.BusStop;
import com.models.VehicleData;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DistanceFinder {

    public VehicleData mapClosestBusStop(VehicleData vehicleData, List<BusStop> busStops) {
        BusStop closestBusStop = null;
        double minDist = Integer.MAX_VALUE;
        double tempDist = 0;
        for (BusStop busStop : busStops
        ) {
            tempDist = getDistance(vehicleData.getLatitude(), vehicleData.getLongitude(), busStop.getLatitude(), busStop.getLongitude());
            if (tempDist < minDist) {
                minDist = tempDist;
                closestBusStop = busStop;
            }
        }
        if (closestBusStop != null) {
            vehicleData.setClosest_stop_code(closestBusStop.getCode());
            vehicleData.setClosest_stop_distance_meters(minDist * 1000);
        }
        return vehicleData;
    }

    private double getDistance(double lat1, double lng1, double lat2, double lng2) {

        double earthRadius = 6371;

        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);

        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);

        double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return earthRadius * c;
    }
}
