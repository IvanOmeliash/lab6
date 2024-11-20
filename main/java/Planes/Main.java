package Planes;

public class Main {
    public static void main(String[] args) {
        PlaneService planeService = new PlaneService();

        Menu menu = new Menu(planeService);
        menu.menu();
    }
}
