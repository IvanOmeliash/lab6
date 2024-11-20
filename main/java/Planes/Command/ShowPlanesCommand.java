package Planes.Command;

import Planes.PlaneService;

public class ShowPlanesCommand implements Command {
    public ShowPlanesCommand(PlaneService planeService) {
    }
    @Override
    public void execute() {
        PlaneService.showPlanes();
    }

    @Override
    public String getDescription(){
        return "Show Planes";
    }
}

