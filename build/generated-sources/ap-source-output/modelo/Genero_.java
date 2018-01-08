package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Especie;
import modelo.Familia;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-22T23:03:51")
@StaticMetamodel(Genero.class)
public class Genero_ { 

    public static volatile SingularAttribute<Genero, Integer> genId;
    public static volatile SingularAttribute<Genero, Integer> genEstado;
    public static volatile ListAttribute<Genero, Especie> especieList;
    public static volatile SingularAttribute<Genero, String> genNombre;
    public static volatile SingularAttribute<Genero, Familia> idFam;

}