package com.gavrilov.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "role")
public class Role extends BaseEntity {

    @NotEmpty(message = "Название роли недолжно быть пустым")
    @Column(name = "name_role", nullable = false, unique = true)
    private String nameRole;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<User> users;

    @ManyToMany(mappedBy = "roleList")
    private List<Privilege> privileges;

    public Role() {
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }
}
