import javax.swing.JOptionPane;

public class ToyotaFactory extends VehicleFactory{

    @Override
    public Vehicle createVehicle(String marca,String modelo, double precio) {
        JOptionPane.showMessageDialog(null, "Se creó un toyota");
                return new Toyota(marca, modelo, precio);
            
        
    }
    
}
