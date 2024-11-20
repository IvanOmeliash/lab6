package Planes.Command;

import Planes.PlaneService;

public class AddPlaneCommand implements Command {
    private PlaneService planeService;

    public AddPlaneCommand(PlaneService planeService) {
        this.planeService = planeService;
    }

    @Override
    public void execute() {
        PlaneService.addPlane();
    }

    @Override
    public String getDescription(){
        return "Add Plane";
    }
}
