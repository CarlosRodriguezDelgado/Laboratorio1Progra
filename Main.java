
import javax.swing.JOptionPane;

public class Main {
    
    
    public static void main(String[] args) {
        CompanyManager manager = new CompanyManager();
        int accion;
        do{
        accion = Integer.parseInt(JOptionPane.showInputDialog("Escriba la accion que desea realizar: \n"+
        "1. Crear vehiculos \n"+
        "2. Agregar cliente \n"+
        "3. Mostrar vehiculos agregados \n"+
        "4. Hacer mantenimiento de algun vehiculo \n"+
        "5. Vender vehiculo \n"+
        "6. Ver los gastos y ganancias de la compañía \n"+
        "7. Salir"));
        switch(accion){
            case 1: manager.crearVehiculos();
            break;
            case 2: manager.agregarCliente();
            break;
            case 3: manager.mostrarVehiculosAgregados();
            break;
            case 4: manager.hacerMantenimiento();
            break;
            case 5: manager.venderVehiculo();
            break;
            case 6: manager.gastosyGanancias();
            break;
            case 7: JOptionPane.showMessageDialog(null, "Gracias por su tiempo");
            break;
            default:
            JOptionPane.showMessageDialog(null, "Ha indicado una opcion no válida");
        }
    }while (accion < 7);
    }
}
