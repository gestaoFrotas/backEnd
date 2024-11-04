package com.example.movitech.service;

import com.example.movitech.Repository.LoginRepository;
import com.example.movitech.dto.LoginDTO;
import com.example.movitech.dto.LoginDTORetorno;
import com.example.movitech.vo.UsuarioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    LoginRepository loginRepository;

    public LoginDTORetorno verificaLogin(LoginDTO dto, LoginDTORetorno beanSaida) {

        String login = dto.getLogin();
        String senha = dto.getSenha();
        if (login == null || senha == null) {
            beanSaida.setRetorno(false);
            beanSaida.setMensagem("O login e a senha são obrigatórios!");
            return beanSaida;
        }
        UsuarioVO usuario = loginRepository.findByApelido(login);
        if (usuario == null) {
            beanSaida.setRetorno(false);
            beanSaida.setMensagem("O usuario informado não foi encontrado!");
            return beanSaida;
        }

        if (usuario.getSenha().equals(dto.getSenha())) {
            beanSaida.setRetorno(true);
            beanSaida.setMensagem("Login bem sucedido!");
            return beanSaida;
        } else {
            beanSaida.setRetorno(false);
            beanSaida.setMensagem("A senha informada está incorreta!");
            return beanSaida;
        }

    }

}


