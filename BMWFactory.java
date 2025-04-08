import javax.swing.JOptionPane;

public class BMWFactory extends VehicleFactory {

    @Override
    public Vehicle createVehicle(String marca,String modelo, double precio) {
        JOptionPane.showMessageDialog(null, "Se creó un BMW");
        
        return new BMW(marca, modelo,  precio); 
    }
    
}
