import javax.swing.JOptionPane;

public class BMW extends Vehicle {


    public BMW(String marca, String modelo, double precio) {
        super(marca, modelo, precio);
        
    }

    @Override
    public void WheelChange() {
        JOptionPane.showMessageDialog(null, "Se le cobro: " + 300 + " por el cambio de llantas");

    }

    @Override
    public void OilChange(double precio) {
        double aceite;
        aceite = 30 + (precio * 0.002);
        JOptionPane.showMessageDialog(null, "Se le cobro: " + aceite + " por el cambio de aceite");
    }

    @Override
    public void MotorFix(double precio) {
        double motor;
        motor = 200 + (precio * 0.002);
        JOptionPane.showMessageDialog(null, "Se le cobro: " +  motor + " por el arreglo al motor");
    }

    @Override
    public void PaintVehicle(double precio) {
        double pintura;
        pintura = 100 + (precio * 0.002);
        JOptionPane.showMessageDialog(null, "Se le cobro: " + pintura + " por el cambio de pintura");
    }
}
