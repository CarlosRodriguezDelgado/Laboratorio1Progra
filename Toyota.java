

import javax.swing.JOptionPane;

import Laboratorio.Vehicle;

public class Toyota implements Vehicle {

    @Override
    public void OilChange(Integer precio) {
        Integer cambioAceite;
        cambioAceite = 50 + (precio * 0.001);
        JOptionPane.showMessageDialog(null, "Se le cobro: " + cambioAceite + " por el cambio de aceite");
    }

    @Override
    public void MotorFix(Integer precio) {
        Integer arregloMotor;
        arregloMotor = 300 + (precioVehiculo * 0.001);
        JOptionPane.showMessageDialog(null, "Se le cobro: " + arregloMotor + " por arreglo del motor");

    }

    @Override
    public void PaintVehicle(Integer precio) {
        Integer pintura;
        pintura = 200 + (precioVehiculo * 0.001);
        JOptionPane.showMessageDialog(null, "Se le cobro: " + pintura + " por el cambio de pintura");

    }

    @Override
    public void WheelChange() {
        JOptionPane.showMessageDialog(null, "Se le cobro: " + 100  + " por el cambio de llantas");

    }

}
