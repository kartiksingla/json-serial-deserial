package org.json.serial.deserial.app.dto;

import lombok.Data;
import org.json.serial.deserial.app.model.IVehicle;

import java.util.ArrayList;
import java.util.List;

@Data
public class TransferDTO {

    public TransferDTO() {
    }

    private List<IVehicle> vehicles = new ArrayList<>();

    public void addVehicle(IVehicle request){
        this.vehicles.add(request);
    }
    public List<IVehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<IVehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "TransferDTO{" +
                ", vehicles=" + vehicles +
                '}';
    }
}
