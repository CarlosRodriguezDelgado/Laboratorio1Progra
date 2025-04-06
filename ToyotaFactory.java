import javax.swing.JOptionPane;

public class ToyotaFactory extends VehicleFactory{

    @Override
    public Vehicle createVehicle() {
        JOptionPane.showMessageDialog(null, "Se vendio un toyota");
                return null;
            
        
    }
    
}
