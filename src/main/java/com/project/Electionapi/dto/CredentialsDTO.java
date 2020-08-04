package com.project.Electionapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CredentialsDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    private String login;
    private String password;
}
