package com.amarsoft.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "user")
public class User implements Serializable {
    @Id
    private Integer id;
    private String name;
    private String password;
    private String company;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public User(Integer id, String name, String password, String company) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.company = company;
    }
}
