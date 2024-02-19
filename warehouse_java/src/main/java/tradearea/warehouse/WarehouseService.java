package tradearea.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tradearea.model.WarehouseData;

@Service
public class WarehouseService {

    private WarehouseService service;

    public String getGreetings( String inModule ) {
        return "Greetings from " + inModule;
    }

    public WarehouseData getWarehouseData( String inID ) {
    	
    	WarehouseSimulation simulation = new WarehouseSimulation();
        return simulation.generateRandomWarehouseData();
        
    }
    public static WarehouseData getWarehouseData() {

        WarehouseSimulation simulation = new WarehouseSimulation();
        return simulation.generateRandomWarehouseData();

    }
    
}