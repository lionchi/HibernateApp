package com.gavrilov.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "user")
public class User extends BaseEntity {

    @NotEmpty(message = "Логин недолжен быть пустым")
    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @NotEmpty(message = "Пароль недолжен быть пустым")
    @Column(name = "password", nullable = false, unique = true)
    private String password;

    @Column(name = "enabled", nullable = false)
    private Integer enabled;

    @ManyToOne
    @JoinColumn(name = "role_id") // владеемая сущность
    private Role role;

    public User() {
    }

    public User(String login, String password, Integer enabled, Role role) {
        this.login = login;
        this.password = password;
        this.enabled = enabled;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
