package org.json.serial.deserial.app.model.impl;

import org.json.serial.deserial.app.model.ITyre;

public class CeatTyre implements ITyre {

    private String tyreId;

    private String tyreType;

    @Override
    public String getTyreId() {
        return tyreId;
    }

    public void setTyreId(String tyreId) {
        this.tyreId = tyreId;
    }

    @Override
    public String getTyreType() {
        return tyreType;
    }

    public void setTyreType(String tyreType) {
        this.tyreType = tyreType;
    }
}
