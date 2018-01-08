package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Especie;
import modelo.Genero;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-22T23:03:51")
@StaticMetamodel(Familia.class)
public class Familia_ { 

    public static volatile SingularAttribute<Familia, String> famNombre;
    public static volatile SingularAttribute<Familia, Integer> famId;
    public static volatile ListAttribute<Familia, Especie> especieList;
    public static volatile ListAttribute<Familia, Genero> generoList;
    public static volatile SingularAttribute<Familia, Integer> artEstado;

}