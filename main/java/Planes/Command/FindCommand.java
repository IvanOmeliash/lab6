package Planes.Command;

import Planes.PlaneService;

public class FindCommand implements Command {
    public FindCommand(PlaneService planeService) {
    }

    @Override
    public void execute() {
        PlaneService.findPlaneByFuel();
    }

    @Override
    public String getDescription(){
        return "Find Plane By Fuel";
    }
}
