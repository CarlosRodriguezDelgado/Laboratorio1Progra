

public class Customer {

  private  String Client_ID;
   private  String Client_Name;


      public Customer() {
        
      }

      public Customer(String  Client_ID, String Client_Name  ) {
        this.Client_ID=Client_ID;
        this.Client_Name=Client_Name;
      }


      public String getClient_ID() {
          return Client_ID;
      }

      public String getClient_Name() {
          return Client_Name;
      }

      public void setClient_ID(String client_ID) {
          Client_ID = client_ID;
      }

      public void setClient_Name(String client_Name) {
          Client_Name = client_Name;
      }

      /*Estuve investigando y para evitar errores inesperados o raros con comparaciones de objetos 
       * por ejemplo evitar que Java piense que un objeto es lo mismo solo por su posición en memoria cuando son distintos
       * o que compare algo nulo, para eso nos va ayudar el metodo equals el cual tiene como objetivo 
       * definir cuándo dos instancias de Customer se consideran son realmente iguales.
       * se coloca override por que es un metodo  propio de Java el .equals 
       */

 // método equals
 @Override
 public boolean equals(Object obj) {
     if (this == obj) return true;  // Si son el mismo objeto devuelve verdadero
     if (obj == null || getClass() != obj.getClass()) return false;  // Si el objeto es nulo o no es del mismo tipo tira falso
     /*ahora hacemos un cast  ose convertir el objeto genérico obj en un objeto Customer). 
      *  Después de verificar que obj no sea nulo y que sea una instancia de Customer
      *lo convertimos a un tipo Customer para asi poder acceder a todos los atributos
      */
     Customer customer = (Customer) obj;  
     return Client_ID.equals(customer.Client_ID);  // Compara el client_ID
 }

 /*Implementación de hashCode que basicamente es como la cedula del objeto en memoria
 El método hashCode() es bueno cuando se trabajan objetos como claves en colecciones basadas en hashing (como HashMap, HashSet).
 precisamente la clave es por asi decirlo esa cedula compas.
  */

 @Override
 public int hashCode() {
     return Client_ID.hashCode();  // Genera el hashCode basado en ID que es lo que usamos para comparar
 }









}
