package org.json.serial.deserial.app.main;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.json.serial.deserial.app.deserializer.CommonDeserializer;
import org.json.serial.deserial.app.dto.TransferDTO;
import org.json.serial.deserial.app.json.ClassTypePropertyMixIn;
import org.json.serial.deserial.app.model.ITyre;
import org.json.serial.deserial.app.model.IVehicle;
import org.json.serial.deserial.app.model.impl.BridgeStoneTyre;
import org.json.serial.deserial.app.model.impl.CarRequest;
import org.json.serial.deserial.app.model.impl.CeatTyre;
import org.json.serial.deserial.app.model.impl.TruckRequest;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("Main Class");
        TransferDTO transferDto = createRequestAndJson();
        ObjectMapper mapperSer = new ObjectMapper();
        mapperSer.addMixIn(IVehicle.class, ClassTypePropertyMixIn.class);
        mapperSer.addMixIn(ITyre.class, ClassTypePropertyMixIn.class);
        String json = mapperSer.writeValueAsString(transferDto);
        System.out.println(json);
        String jsonToParse = json;

        ObjectMapper mapper = new ObjectMapper();
        SimpleModule sModule = new SimpleModule();
        sModule.addDeserializer(IVehicle.class, CommonDeserializer.build(IVehicle.class, "org"));
        sModule.addDeserializer(ITyre.class, CommonDeserializer.build(ITyre.class, "org"));
        mapper.registerModule(sModule);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        TransferDTO iRequest = mapper.readValue(jsonToParse, TransferDTO.class);
        System.out.println(iRequest);
    }

    private static TransferDTO createRequestAndJson() throws JsonProcessingException {
        CarRequest carRequest = new CarRequest();
        carRequest.setFourWheelerId("carDealId");
        carRequest.setCarId("carSecId");
        carRequest.setId("carId");

        TruckRequest truckRequest = new TruckRequest();
        truckRequest.setFourWheelerId("truckDealId");
        truckRequest.setTruckId("truckSecId");
        truckRequest.setId("truckId");

        BridgeStoneTyre bsTyre = new BridgeStoneTyre();
        bsTyre.setTyreHealth("bsTyreHealth");
        bsTyre.setTyreId("bsTyreId");
        bsTyre.setTyreType("bsTyreType");

        truckRequest.addLegTerm(bsTyre);

        CeatTyre ceatTyre = new CeatTyre();
        ceatTyre.setTyreId("ceatTyreId");

        truckRequest.addLegTerm(ceatTyre);

        TransferDTO tDto = new TransferDTO();
        tDto.addVehicle(truckRequest);
        tDto.addVehicle(carRequest);

        return tDto;
    }

}
