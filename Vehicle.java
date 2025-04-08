

import java.util.ArrayList;

public abstract class Vehicle {
  private   String marca;
   private  String modelo;
    private  double precio;

    public Vehicle(String marca,String modelo, double precio) {
        this.marca=marca;
        this.modelo=modelo;
        this.precio= precio;
       
    }
    ArrayList<Double> listaCostos = new ArrayList<>();

    public abstract void OilChange(double precio);

    public abstract void MotorFix(double precio);

    public abstract void PaintVehicle(double precio);

    public abstract void WheelChange(); 

    public double getPrecio() {
        return precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getModelo() {
        return modelo;
    }

}
