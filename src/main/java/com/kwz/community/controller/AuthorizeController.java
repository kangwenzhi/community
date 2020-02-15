package com.kwz.community.controller;


import com.kwz.community.dto.AccessTokenDTO;
import com.kwz.community.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GitHubProvider gitHubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam String state ){

        AccessTokenDTO accessTokenDTO=new AccessTokenDTO();
        accessTokenDTO.setClient_id("0820b1848342ce0da279");
        accessTokenDTO.setClient_secret("5a59f599a22c8f72d1b2dc0ba8b6c8a002470877");
        accessTokenDTO.setState(state);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8887/callback");
        gitHubProvider.GetAccessToken(accessTokenDTO);

        return "index";
    }
}
