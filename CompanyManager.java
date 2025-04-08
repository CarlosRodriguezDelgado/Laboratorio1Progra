import javax.swing.JOptionPane;
public class CompanyManager {
    Company compannia = new Company();

    public void agregarCliente() {
        if (compannia.listaVehiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null,"No hay Autos a los que asociarle un cliente"+"\n"
                                                                +"registre uno para utilizar este apartado");
            return;
        }
        String Client_ID = JOptionPane.showInputDialog("Esciba el ID del cliente:");
        if (Client_ID.length()<4) {
            JOptionPane.showMessageDialog(null, new Exception("el id debe tener al menos 4 digitos"));
            return;
        }
        String Client_Name = JOptionPane.showInputDialog("Escriba el nombre del cliente:");
        if (Client_Name==null|| Client_Name.isBlank()) {
            JOptionPane.showMessageDialog(null, new Exception("nombre del cliente no puede estar vacio intente de nuevo"));
            return;
        }
        compannia.addCustomer(Client_ID, Client_Name);
    }

    public void crearVehiculos(){
        String cantidadError = JOptionPane.showInputDialog("Escriba la cantidad de vehículos que desea crear");

        if (cantidadError == null || cantidadError.isBlank()) {
            JOptionPane.showMessageDialog(null, "La cantidad no puede estar vacía. Intente de nuevo.");
            return;
        }
    
        int cantidad = 0;
        try {
            cantidad = Integer.parseInt(cantidadError);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un número válido. Intente de nuevo.");
            return;
        }
    
        if (cantidad <= 0) {
            JOptionPane.showMessageDialog(null, "La cantidad no puede ser negativa o 0. Intente de nuevo.");
            return;
        }
    
        for (int i = 0; i < cantidad; i++) {
            String marca = JOptionPane.showInputDialog("Escriba la marca del vehículo");
    
            if (marca == null || marca.isBlank()) {
                JOptionPane.showMessageDialog(null, "La marca no puede estar vacía. Intente de nuevo.");
                return;
            }

        if (marca.compareToIgnoreCase("Toyota" )!=0 && marca.compareToIgnoreCase("Ford")!=0 && marca.compareToIgnoreCase("BMW")!=0){
            JOptionPane.showMessageDialog(null, "Ha introducido una marca incorrecta, intente de nuevo");
        }else{
            String modelo = JOptionPane.showInputDialog("Escriba el modelo del " + marca);
            if (modelo==null|| modelo.isBlank()) {
                JOptionPane.showMessageDialog(null, new Exception("modelo  no puede estar vacio intente de nuevo"));
                return;
            }
    
            
            String precio = JOptionPane.showInputDialog("Escriba el precio del " + marca);
            if (precio==null|| precio.isBlank()) {
                JOptionPane.showMessageDialog(null, new Exception("precio  no puede estar vacio intente de nuevo"));
                return;
            }
            
            if (precio.chars().filter(ch-> ch== '.').count()>1) {
              JOptionPane.showMessageDialog(null, new NumberFormatException("muchos puntos en el numero"));
              return;
            }
            Double preciof= Double.valueOf(precio);

            compannia.addVehicle(marca, modelo, preciof);
        }
        }
    }

    public void mostrarVehiculosAgregados() {
        if (compannia.listaVehiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null,"No hay Autos a mostrar"+"\n"
            +"registre uno para utilizar este apartado");
                return;
        }
        String vehiculosAgregados = "Estos son los vehículos agregados: \n";
        
        for (int i = 0; i < compannia.listaVehiculos.size(); i++) {
            Vehicle vehiculo = compannia.listaVehiculos.get(i);
            vehiculosAgregados += vehiculo.getMarca() + " " + vehiculo.getModelo() + " - $" + vehiculo.getPrecio() + "\n";
        }
        JOptionPane.showMessageDialog(null, vehiculosAgregados);
    }

    public void hacerMantenimiento(){
        String vehiculosAgregados="";
       
        for (int i = 0; i < compannia.listaVehiculos.size(); i++) {
            Vehicle vehiculo = compannia.listaVehiculos.get(i);
            vehiculosAgregados += (i + 1) + ". " + vehiculo.getMarca() + " " + vehiculo.getModelo() + " - $" + vehiculo.getPrecio() + "\n";
        }

        if (vehiculosAgregados.isBlank()) {
            JOptionPane.showMessageDialog(null,"No se han agregado vehiculos"+"\n"
                                                                + "Adicione uno para usar este apartado");
            return;
        }
        String mensaje = "Seleccione a cual vehículo le desea realizar mantenimiento ingrese número en la lista: \n" + vehiculosAgregados;
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, mensaje));
        String opcionError= String.valueOf(opcion);        

        if (opcionError.isEmpty()|| opcion>compannia.listaVehiculos.size()) {
            JOptionPane.showMessageDialog(null,"ingrese una posicion de la lista valida"+"\n"
            + (" para usar este apartado"));
            return;
        }
        Vehicle vehiculo = compannia.listaVehiculos.get(opcion - 1);
    int opcionMantenimiento = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el tipo de mantenimiento que desea realizar \n" + 
    "1. Cambiar aceite \n"+
    "2. Reparar motor \n"+
    "3. Pintar \n"+
    "4. Cambiar llantas"));
    
    switch (opcionMantenimiento) {
        case 1:
            vehiculo.OilChange(vehiculo.getPrecio());
            break;
        case 2:
            vehiculo.MotorFix(vehiculo.getPrecio());
            break;
        case 3:
            vehiculo.PaintVehicle(vehiculo.getPrecio());
            break;
        case 4:
            vehiculo.WheelChange();
            break;
        default:
            JOptionPane.showMessageDialog(null, "Ha indicado una opcion no válida");
            return;
    }
    }



    public void venderVehiculo(){

        if (compannia.listaVehiculos.isEmpty()) {
            JOptionPane.showMessageDialog(null,"No hay Autos disponibles para su venta"+"\n"
            +"registre uno para utilizar este apartado");
                return;
        }
        String vehiculosAgregados = "Seleccione el vehículo que desea vender: \n";
        for (int i = 0; i < compannia.listaVehiculos.size(); i++) {
            Vehicle vehiculo = compannia.listaVehiculos.get(i);
            vehiculosAgregados += (i + 1) + ". " + vehiculo.getMarca() + " " + vehiculo.getModelo() + " - $" + vehiculo.getPrecio() + "\n";
        }
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, vehiculosAgregados));
        Vehicle vehiculo = compannia.listaVehiculos.get(opcion - 1); 

        String ID_Cliente = JOptionPane.showInputDialog("Escriba el ID del cliente al que le desea vender el vehiculo");
        boolean clienteExiste = false;
        Customer cliente = null;
        for (int i = 0; i < compannia.listaClientes.size(); i++) {
        cliente = compannia.listaClientes.get(i);
        
        if (cliente.getClient_ID().equals(ID_Cliente)) {
            clienteExiste = true;
            
            JOptionPane.showMessageDialog(null, "Cliente encontrado: " + cliente.getClient_Name());
        }
    }

    if (!clienteExiste) {
        JOptionPane.showMessageDialog(null, "El cliente con el ID " + ID_Cliente + " no fue encontrado");
        return;
    }

    compannia.sellVehicle(vehiculo, cliente, vehiculo.getPrecio());

    }

    public void gastosyGanancias(){
        double gastosTotales = 0;
        for (int i = 0; i < compannia.listaVehiculos.size(); i++) {
        Vehicle vehiculo = compannia.listaVehiculos.get(i);
        gastosTotales += compannia.getProfitForVehicle(vehiculo);
        }
        JOptionPane.showMessageDialog(null, "Gastos totales: " + gastosTotales);
        JOptionPane.showMessageDialog(null, "Ganancias totales: " + compannia.getTotalProfit());

    }

}
