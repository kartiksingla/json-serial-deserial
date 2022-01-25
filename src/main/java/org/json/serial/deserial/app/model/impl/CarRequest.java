package org.json.serial.deserial.app.model.impl;

import org.json.serial.deserial.app.model.ICarRequest;

public class CarRequest extends AbstractFourWheelerRequest implements ICarRequest {

    private String fourWheelerId;

    private String carId;

    @Override
    public String getFourWheelerId() {
        return fourWheelerId;
    }

    public void setFourWheelerId(String fourWheelerId) {
        this.fourWheelerId = fourWheelerId;
    }

    @Override
    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }
}
