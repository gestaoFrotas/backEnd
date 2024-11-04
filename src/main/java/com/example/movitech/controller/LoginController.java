package com.example.movitech.controller;

import com.example.movitech.dto.LoginDTO;
import com.example.movitech.dto.LoginDTORetorno;
import com.example.movitech.service.LoginService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movitech")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public LoginDTORetorno validaLogin(@RequestBody LoginDTO beanEntrada) {

        LoginDTORetorno beanSaida = new LoginDTORetorno();

        beanSaida = loginService.verificaLogin(beanEntrada, beanSaida);



        return beanSaida;
    }

}
