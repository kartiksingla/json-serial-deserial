package org.json.serial.deserial.app.model.impl;

import org.json.serial.deserial.app.model.IFourWheelerRequest;

public abstract class AbstractFourWheelerRequest implements IFourWheelerRequest {

    private String id;
    
    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
