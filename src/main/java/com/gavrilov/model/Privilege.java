package com.gavrilov.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "privilege")
public class Privilege extends BaseEntity {
    @NotEmpty(message = "Название привилегии недолжно быть пустым")
    @Column(name = "privilege_name", nullable = false, unique = true)
    private String privilegeName;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "role_privilege",
            joinColumns = {@JoinColumn(name = "role_id")}, //  имя столбца, связывающего с классом владельцем
            inverseJoinColumns = {@JoinColumn(name = "privilege_id")}) // имя столбца, связывающего с владеемым классом
    private List<Role> roleList;

    public Privilege() {
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
