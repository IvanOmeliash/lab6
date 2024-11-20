package Planes.Command;

import Planes.PlaneService;

public class TotalPayloadCommand implements Command {
    public TotalPayloadCommand(PlaneService planeService) {
    }
    @Override
    public void execute() {
        PlaneService.totalPayload();
    }

    @Override
    public String getDescription(){
        return "Total Payload of Planes";
    }
}
