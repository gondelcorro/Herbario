package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Familia;
import modelo.Genero;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-22T23:03:51")
@StaticMetamodel(Especie.class)
public class Especie_ { 

    public static volatile SingularAttribute<Especie, String> espNumColecc;
    public static volatile SingularAttribute<Especie, String> espNomVul;
    public static volatile SingularAttribute<Especie, Familia> espIdFam;
    public static volatile SingularAttribute<Especie, String> espFecIngreso;
    public static volatile SingularAttribute<Especie, Integer> espEstado;
    public static volatile SingularAttribute<Especie, String> espRecolector;
    public static volatile SingularAttribute<Especie, Genero> espIdGen;
    public static volatile SingularAttribute<Especie, String> espLocalidad;
    public static volatile SingularAttribute<Especie, String> espDpto;
    public static volatile SingularAttribute<Especie, String> espObservaciones;
    public static volatile SingularAttribute<Especie, String> espFechaRecol;
    public static volatile SingularAttribute<Especie, String> espAcompanante;
    public static volatile SingularAttribute<Especie, byte[]> espImagen;
    public static volatile SingularAttribute<Especie, String> espDetalleDup;
    public static volatile SingularAttribute<Especie, Integer> espDuplicado;
    public static volatile SingularAttribute<Especie, String> espNombre;
    public static volatile SingularAttribute<Especie, String> espPais;
    public static volatile SingularAttribute<Especie, Integer> espId;
    public static volatile SingularAttribute<Especie, String> espDeterPor;
    public static volatile SingularAttribute<Especie, String> espProv;

}