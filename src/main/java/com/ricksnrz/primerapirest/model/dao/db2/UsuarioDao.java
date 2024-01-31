package com.ricksnrz.primerapirest.model.dao.db2;

import com.ricksnrz.primerapirest.model.entity.db2.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@EnableJpaRepositories
@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findOneByEmailAndPassword(String email, String password);

    Usuario findByEmail(String email);

}
