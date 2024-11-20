package Planes.Command;

import Planes.PlaneService;

public class DeletePlaneCommand implements Command {
    public DeletePlaneCommand(PlaneService planeService) {
    }
    @Override
    public void execute() {
        PlaneService.deletePlane();
    }

    @Override
    public String getDescription(){
        return "Delete Plane By Model";
    }
}




