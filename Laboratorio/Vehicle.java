package Laboratorio;

import java.util.ArrayList;

public interface Vehicle {
    String marca = "";
    String modelo = "";
    double precio = 0;
    ArrayList listaCostos = new ArrayList<>();

    public abstract void OilChange(double precio);

    public abstract void MotorFix(double precio);

    public abstract void PaintVehicle(double precio);

    public abstract void WheelChange(); 

}
