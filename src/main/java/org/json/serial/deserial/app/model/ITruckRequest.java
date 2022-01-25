package org.json.serial.deserial.app.model;

import java.util.Map;

public interface ITruckRequest extends IFourWheelerRequest {

    String getTruckId();

    Map<String, ITyre> getTyres();
}
