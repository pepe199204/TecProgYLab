package apicampeonatosfifa.apicampeonatosfifa.core.interfaces.servicios;

import java.util.List;

import apicampeonatosfifa.apicampeonatosfifa.dominio.entidades.Seleccion;

public interface ISeleccionServicio {

    public List<Seleccion> listar();

    public Seleccion obtener(int id);

    public List<Seleccion> buscar(String nombre);

    public Seleccion agregar(Seleccion pais);

    public Seleccion modificar(Seleccion pais);

    public boolean eliminar(int id);

}
