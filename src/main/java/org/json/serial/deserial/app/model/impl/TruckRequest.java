package org.json.serial.deserial.app.model.impl;

import org.json.serial.deserial.app.model.ITruckRequest;
import org.json.serial.deserial.app.model.ITyre;

import java.util.HashMap;
import java.util.Map;

public class TruckRequest extends AbstractFourWheelerRequest implements ITruckRequest {

    private String fourWheelerId;

    private String truckId;

    private Map<String, ITyre> tyres = new HashMap<>();

    @Override
    public String getFourWheelerId() {
        return fourWheelerId;
    }

    public void setFourWheelerId(String fourWheelerId) {
        this.fourWheelerId = fourWheelerId;
    }

    public String getTruckId() {
        return truckId;
    }

    @Override
    public Map<String, ITyre> getTyres() {
        return tyres;
    }

    public void setTruckId(String truckId) {
        this.truckId = truckId;
    }

    public void addLegTerm(ITyre legTerm) {
        this.tyres.put("tyreId-" + legTerm.getTyreId(), legTerm);
    }

    public void setTyres(Map<String, ITyre> tyres) {
        this.tyres = tyres;
    }

}
