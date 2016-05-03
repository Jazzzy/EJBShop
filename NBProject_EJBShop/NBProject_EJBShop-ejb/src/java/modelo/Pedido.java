package modelo;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {

    private ArrayList<LineaPedido> lineasPedido;
    private UsuarioInterfazLocal usuario;

    //To be mapped into database
    @Column
    private float precioTotal;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column
    private String nombreUsuario;

    @Column
    private Date fecha;

    public Pedido(Tienda tienda, UsuarioInterfazLocal usuario) {

        this.usuario = usuario;
        CarritoInterfazLocal carrito = usuario.getCarrito();
        /*Antes de crear el pedido actualizamos todos los datos
         del carrito para tener información correcta*/
        carrito.actualizar(tienda);

        this.lineasPedido = new ArrayList<>();

        ArrayList<LineaCarrito> lineasCarrito = carrito.getLineasCarrito();

        /*Para todas las lineas de carrito, instanciamos
         una linea de pedido y la anadimos a la lista*/
        for (LineaCarrito lc : lineasCarrito) {
            this.lineasPedido.add(new LineaPedido(lc));
        }

        
        //Poblamos los atributos a meter en la base de datos
        this.precioTotal = carrito.getPrecioTotal();
        this.nombreUsuario = usuario.getNombre();
        this.fecha = new Date();
    }

    public ArrayList<LineaPedido> getLineasPedido() {
        return lineasPedido;
    }

    public UsuarioInterfazLocal getUsuario() {
        return usuario;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

}
