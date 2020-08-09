package com.project.Electionapi.entity;

import com.project.Electionapi.entity.enuns.Profile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Entity
public class User implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 3)
    private String name;

    @NotNull
    @Column(unique = true)
    private String cpf;

    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="PROFILES")
    private Set<Integer> profiles = new HashSet<>();




    public User(@NotNull String name, @NotNull String cpf, @NotNull String email, @NotNull String username, @NotNull String password) {
        this.name = name;
        this.cpf = cpf;
        this.username = username;
        this.email = email;
        this.password = password;
        addProfiles(Profile.DEFAULT);

    }

    public Set<Profile>getProfiles(){
        return profiles.stream().map(x-> Profile.toEnum(x)).collect(Collectors.toSet());
    }

    public void addProfiles(Profile profile)
    {
        profiles.add(profile.getId());
    }





}
