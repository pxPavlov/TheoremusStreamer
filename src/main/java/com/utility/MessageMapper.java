package com.utility;

import com.models.VehicleData;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {
    public VehicleData mapLineMsgToObject(String line) {
        line = line.replace("\\", "");
        String[] tempList = line.split(";");
        tempList[0] = tempList[0].replace("\"", "");
        String tempList2 = tempList[4].replace("\"", "");
        String[] tempList3 = tempList2.split(",");

        VehicleData vehicleData = new VehicleData();
        try {
            vehicleData.setAltitude(Double.parseDouble(tempList3[1].substring(tempList3[1].length() - 5)));
            vehicleData.setLatitude(Double.parseDouble(tempList3[4].substring(9)));
            vehicleData.setLongitude(Double.parseDouble(tempList3[5].substring(10)));
            vehicleData.setSatellite_used(Integer.parseInt(tempList3[6].substring(14)));
            vehicleData.setSpeed(Double.parseDouble(tempList3[7].substring(6)));
            vehicleData.setTimestamp(Long.parseLong(tempList[0]));
            vehicleData.setVehicle_id(Integer.parseInt(tempList3[17].substring(11)));
            vehicleData.setDevice_id(tempList3[12].substring(10));
            String tempQuality = tempList3[10].replaceAll("[^0-9]", "");
            if (!tempQuality.isEmpty()) {
                vehicleData.setSignal_quality(Integer.parseInt(tempQuality));
            }
        } catch (NumberFormatException e) {
            return new VehicleData();
        }

        return vehicleData;
    }
}

