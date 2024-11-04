package com.example.movitech.Repository;

import com.example.movitech.vo.UsuarioVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<UsuarioVO,Long> {
    UsuarioVO findByApelido(String login);
}
