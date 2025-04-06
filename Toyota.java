
import javax.swing.JOptionPane;

public class Toyota extends Vehicle {

    public Toyota(String marca,String modelo, double precio) {
        super(marca, modelo,  precio); {
        
    }

}

    @Override
    public void WheelChange() {
        JOptionPane.showMessageDialog(null, "Se le cobro: " + 100 + " por el cambio de llantas");

    }

    @Override
    public void OilChange(double precio) {
        double aceite;
        aceite = 50 + (precio * 0.001);
        JOptionPane.showMessageDialog(null, "Se le cobro: " + aceite + " por el cambio de aceite");
    }

    @Override
    public void MotorFix(double precio) {
        double motor;
        motor = 300 + (precio * 0.001);
        JOptionPane.showMessageDialog(null, "Se le cobro: " + motor + " por el arreglo al motor");
    }

    @Override
    public void PaintVehicle(double precio) {
        double pintura;
        pintura = 200 + (precio * 0.001);
        JOptionPane.showMessageDialog(null, "Se le cobro: " + pintura + " por el cambio de pintura");
    }

}
