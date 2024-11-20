package Planes.Command;

import Planes.PlaneService;

public class SortCommand implements Command {
    public SortCommand(PlaneService planeService) {
    }
    @Override
    public void execute() {
        PlaneService.sortByRange();
    }

    @Override
    public String getDescription(){
        return "Sort Planes by Max Range";
    }
}
