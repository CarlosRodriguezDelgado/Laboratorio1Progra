import javax.swing.JOptionPane;

import Laboratorio.Vehicle;

public class FordFactory extends VehicleFactory {

    @Override
    public Vehicle createVehicle() {
          JOptionPane.showMessageDialog(null, "Se vendio un ford");
                return null;
    }
    
}
