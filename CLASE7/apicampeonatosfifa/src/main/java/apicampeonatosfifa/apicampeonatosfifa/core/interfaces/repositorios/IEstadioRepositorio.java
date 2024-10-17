package apicampeonatosfifa.apicampeonatosfifa.core.interfaces.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apicampeonatosfifa.apicampeonatosfifa.dominio.entidades.Estadio;

@Repository
public interface IEstadioRepositorio extends JpaRepository<Estadio, Integer> {
}
