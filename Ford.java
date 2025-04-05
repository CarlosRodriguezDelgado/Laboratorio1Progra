import javax.swing.JOptionPane;

import Laboratorio.Vehicle;

public class Ford implements Vehicle {

    @Override
    public void WheelChange() {
        JOptionPane.showMessageDialog(null, "Se le cobro: " + 200 + " por el cambio de llantas");

    }

    @Override
    public void OilChange(double precio) {
        double aceite;
        aceite = 45 + (precio * 0.001);
        JOptionPane.showMessageDialog(null, "Se le cobro: " + aceite + " por el cambio de aceite");
    }

    @Override
    public void MotorFix(double precio) {
        double motor;
        motor = 350 + (precio * 0.001);
        JOptionPane.showMessageDialog(null, "Se le cobro: " +  motor + " por el arreglo al motor");
    }

    @Override
    public void PaintVehicle(double precio) {
        double pintura;
        pintura = 180 + (precio * 0.001);
        JOptionPane.showMessageDialog(null, "Se le cobro: " + pintura + " por el cambio de pintura");
    }
}
