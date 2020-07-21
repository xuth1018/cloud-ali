package com.xx.cloud.body;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 5481141254395218107L;

    @NotNull(message = "用户不存在")
    @Length(max=11)
    private Long id;
    private String name;
    private Integer gender;

    public User() {
    }

    public User(Long id, String name, Integer gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
