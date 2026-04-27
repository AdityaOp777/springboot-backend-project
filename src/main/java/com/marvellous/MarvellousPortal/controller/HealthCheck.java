package com.marvellous.MarvellousPortal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck
{
    @GetMapping("HealthCheck")  // this is end point
    public String HealthCheck()
    {
        return "Everything Is OK";
    }
}
