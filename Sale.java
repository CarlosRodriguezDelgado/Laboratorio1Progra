public class Sale {
    private Customer client;
    private Vehicle soldVehicle;
    private double salePrice;

    public Sale() {
        
    }

    // Constructor
    public Sale(Customer cliente, Vehicle vehiculoVendido, double precioVenta) {
        this.client = cliente;
        this.soldVehicle = vehiculoVendido;
        this.salePrice = precioVenta;
    }

    // Getters
    public Customer getClient() {
        return client;
    }

    public Vehicle getSoldVehicle() {
        return soldVehicle;
    }

    public double getSalePrice() {
        return salePrice;
    }

    // Setters
    public void setClient(Customer cliente) {
        this.client = cliente;
    }

    public void setSoldVehicle(Vehicle vehiculoVendido) {
        this.soldVehicle = vehiculoVendido;
    }

    public void setSalePrice(double precioVenta) {
        this.salePrice = precioVenta;
    }
}