import javax.swing.JOptionPane;

public class FordFactory extends VehicleFactory {

    @Override
    public Vehicle createVehicle(String marca,String modelo, double precio) {
          JOptionPane.showMessageDialog(null, "Se creó un ford");
                return new Ford(marca, modelo,  precio);
    }
    
}
