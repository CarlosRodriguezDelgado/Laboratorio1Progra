import javax.swing.JOptionPane;

import Laboratorio.Vehicle;

public class BMWFactory extends VehicleFactory{

    @Override
    public Vehicle createVehicle() {
        JOptionPane.showMessageDialog(null, "Se vendio un BMW");
                return null;
    }
    
}
