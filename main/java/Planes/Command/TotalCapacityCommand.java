package Planes.Command;

import Planes.PlaneService;

public class TotalCapacityCommand implements Command {
    public TotalCapacityCommand(PlaneService planeService) {
    }
    @Override
    public void execute() {
        PlaneService.totalCapacity();
    }

    @Override
    public String getDescription(){
        return "Total Capacity of Planes";
    }
}
