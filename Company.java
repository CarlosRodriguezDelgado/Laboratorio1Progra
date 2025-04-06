import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Company {
     //instancia de listas 
    ArrayList<Vehicle> listaVehiculos= new ArrayList<>();
    ArrayList<Sale> listaVentas= new ArrayList<>();
    ArrayList<Customer> listaClientes= new ArrayList<>();

       BMWFactory fabricaBMW= new BMWFactory();
       ToyotaFactory fabricaToyota= new ToyotaFactory();
       FordFactory fabricaFord= new FordFactory();

       //Aniadir vehiculos
    public void addVehicle(String marca, String modelo, double precio){
        switch (marca.toLowerCase()) {
            case "toyota":
                listaVehiculos.add(fabricaToyota.createVehicle(marca, modelo, precio));
                break;
            case "bmw":
                listaVehiculos.add(fabricaBMW.createVehicle(marca, modelo, precio));
                break;
            case "ford":
                listaVehiculos.add(fabricaFord.createVehicle(marca, modelo, precio));
                break;
            default:
                 throw new IllegalArgumentException("Marca no soportada");
        }

}


public void addCustomer(String Client_ID, String Client_Name) {
    // Verificamos si todo esta bien con los parametros y no entro un dato vacio
    if (Client_ID == null || Client_ID.isEmpty() || Client_Name == null || Client_Name.isEmpty()) {
        JOptionPane.showMessageDialog(null, "La identificación o el nombre no pueden estar vacíos.");
        return;
    }
    
    // Comprobar si es un duplicado
    for (Customer customer : listaClientes) {
        if (customer.getClient_ID().equals(Client_ID)) {
            // Si ya existe salir y muestra que verifique 
            JOptionPane.showMessageDialog(null, "Verifique si la identificación es igual a la de un cliente existente.");
            return;
        }
    }

    // Si todo salio bien crea el cliente
    Customer newCustomer = new Customer(Client_ID, Client_Name);
    listaClientes.add(newCustomer);
}

//Metodo de venta, recordar en el manager poder darle al cliente el vehiculo que desea comprar realmente!

public void sellVehicle(Vehicle vehiculo, Customer cliente, double monto) {

    // Verifica si cliente y vehiculo existen
    if (vehiculo == null || cliente == null) {
        JOptionPane.showMessageDialog(null, "El vehículo o el cliente no existen.");
        return;
    }

    // Verificar que no metan valores negativos
    if (monto <= 0) {
        JOptionPane.showMessageDialog(null, "El monto de la venta debe ser positivo.");
        return;
    }

    //verificar que si el vehiculo ya se vendió
    if (!listaVehiculos.contains(vehiculo)) {
        JOptionPane.showMessageDialog(null, "Este vehículo ya fue vendido o no está en inventario.");
        return;
    }

    // si todo sale bien crea la venta;
    Sale newSale = new Sale(cliente, vehiculo, monto);
    listaVentas.add(newSale);

    // y si ya se vendio obvio hay que reducir inventario 
    listaVehiculos.remove(vehiculo);

    JOptionPane.showMessageDialog(null, "Venta registrada exitosamente.");
}

//metodo de ventas por cliente, de tipo array para devolver una lista temporal con las ventas de un cliente
//en especifico.

public ArrayList<Sale> getSalesByCustomerId(String id) {
    ArrayList<Sale> ventasCliente = new ArrayList<>();
    
    // este for each lo que hace es recorrer toda la lista de ventas 
    for (Sale sale : listaVentas) {
        // y compara el id de cada cliente con la que se recibio y si lo encuentra
        if (sale.getClient().getClient_ID().equals(id)) {
            ventasCliente.add(sale);
        }
    }

    return ventasCliente;
}

//metodo de ganancia para cada vehiculo:

public double getProfitForVehicle(Vehicle vehiculo){
   
        double gastos = 0.0;
        String marca = vehiculo.getMarca();
        double precioVenta = vehiculo.getPrecio();// Precio de venta
        double precioAdquisicion = precioVenta * 0.7; // 70% del precio de venta
        
        // Calculamos los gastos según la marca
        switch (marca) {
            case "Toyota":
                gastos += 50 + (precioVenta * 0.001); // Cambio aceite
                gastos += 300 + (precioVenta * 0.001); // Reparar motor
                gastos += 200 + (precioVenta * 0.001); // Pintura
                gastos += 100; // Cambio llantas
                break;
                
            case "BMW":
                gastos += 30 + (precioVenta * 0.002); // Cambio aceite
                gastos += 200 + (precioVenta * 0.002); // Reparar motor
                gastos += 100 + (precioVenta * 0.002); // Pintura
                gastos += 300; // Cambio llantas
                break;
                
            case "Ford":
                gastos += 45 + (precioVenta * 0.001); //  el de Cambio aceite
                gastos += 350 + (precioVenta * 0.001); // Reparar motor
                gastos += 180 + (precioVenta * 0.001); // Pintura
                gastos += 200; //  El Cambio de  llantas
                break;
                
            default:
            //por si meten cualquier otra cosa
                System.out.println("Marca no reconocida");
                break;
        }
        
        // aqui es donde ya calculamos la ganancia,como en el documento
        //no dice que tenga que llevar un precio de adquisicion como atributo en vehicle
        //se fija en el 70% del precio de Venta 
        double ganancia = precioVenta - (precioAdquisicion + gastos);
        return ganancia;
    }

     // Metodo Ganancias totales:
    public double getTotalProfit() {
        //lo que vamos a retornar al final
        double totalProfit = 0.0;
    
        // Recorremos la lista de ventas
        for (Sale sale : listaVentas) {
            Vehicle vehicle = sale.getSoldVehicle(); // agarra el vehiculo que esta vendido ya 
            double vehicleProfit = getProfitForVehicle(vehicle); // Calcula la ganancia con ese vehiculo que agarró
            totalProfit += vehicleProfit; // va acumulando la ganancia total 
        }
    
        return totalProfit; // Devuelve la ganancia total
    }
    
    
}






  




