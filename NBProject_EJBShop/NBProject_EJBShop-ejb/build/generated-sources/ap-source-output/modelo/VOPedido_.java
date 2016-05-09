package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-09T18:09:58")
@StaticMetamodel(VOPedido.class)
public class VOPedido_ { 

    public static volatile SingularAttribute<VOPedido, Integer> id;
    public static volatile SingularAttribute<VOPedido, Float> precioTotal;
    public static volatile SingularAttribute<VOPedido, Date> fecha;
    public static volatile SingularAttribute<VOPedido, String> nombreUsuario;

}