package Laboratorio;

import java.util.ArrayList;

public interface Vehicle {
    String marca = "";
    String modelo = "";
    Integer precio = 0;
    ArrayList<vehicle> listaCostos = new ArrayList<>();

    public void OilChange(Integer precio);

    public  void MotorFix(Integer precio);

    public void PaintVehicle(Integer precio);

    public  void WheelChange(); 

}
