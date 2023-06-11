package com.example.lastterms.service;

import com.example.lastterms.dto.SignInResultDto;
import com.example.lastterms.dto.SignUpResultDto;

public interface SignService {

    SignUpResultDto signUp(String id, String password, String name, String email, String role);

    SignInResultDto signIn(String id, String password) throws RuntimeException;

}