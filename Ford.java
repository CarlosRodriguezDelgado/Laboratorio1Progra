import javax.swing.JOptionPane;

public class Ford extends Vehicle {
  

    public Ford(String marca,String modelo, double precio) {
        super(marca, modelo,  precio);
    }

    @Override
    public void WheelChange() {
       
        JOptionPane.showMessageDialog(null, "Se le cobro: " + 200 + " por el cambio de llantas");
      
    }

    @Override
    public void OilChange(double precio) {
        double aceiteCosto;
        aceiteCosto = 45 + (precio * 0.001);
        JOptionPane.showMessageDialog(null, "Se le cobro: " + aceiteCosto + " por el cambio de aceite");
    }

    @Override
    public void MotorFix(double precio) {
        double motorCosto;
        motorCosto = 350 + (precio * 0.001);
        JOptionPane.showMessageDialog(null, "Se le cobro: " +  motorCosto + " por el arreglo al motor");
    }

    @Override
    public void PaintVehicle(double precio) {
        double pinturaCosto;
        pinturaCosto = 180 + (precio * 0.001);
        JOptionPane.showMessageDialog(null, "Se le cobro: " + pinturaCosto + " por el cambio de pintura");
    }
}
