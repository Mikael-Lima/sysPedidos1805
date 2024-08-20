package br.com.itilh.bdpedidos.sistemaspedidos.repository;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.itilh.bdpedidos.sistemaspedidos.model.Municipio;

@Repository
public interface MunicipioRepository extends CrudRepository<Municipio, BigInteger> {

}
