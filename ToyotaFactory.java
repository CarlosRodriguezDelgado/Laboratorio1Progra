import javax.swing.JOptionPane;

import Laboratorio.Vehicle;

public class ToyotaFactory extends VehicleFactory{

    @Override
    public Vehicle createVehicle() {
        JOptionPane.showMessageDialog(null, "Se vendio un toyota");
                return null;
            
        
    }
    
}
