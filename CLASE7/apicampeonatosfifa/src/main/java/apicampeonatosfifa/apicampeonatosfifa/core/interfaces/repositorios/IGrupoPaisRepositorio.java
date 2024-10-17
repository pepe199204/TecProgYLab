package apicampeonatosfifa.apicampeonatosfifa.core.interfaces.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apicampeonatosfifa.apicampeonatosfifa.dominio.entidades.GrupoPais;
import apicampeonatosfifa.apicampeonatosfifa.dominio.entidades.GrupoPaisId;

@Repository
public interface IGrupoPaisRepositorio extends JpaRepository<GrupoPais, GrupoPaisId> {
}