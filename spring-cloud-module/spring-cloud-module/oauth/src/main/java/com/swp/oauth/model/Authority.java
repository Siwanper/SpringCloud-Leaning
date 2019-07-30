package com.swp.oauth.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-07-30 10:24 AM
 */
@Entity
public class Authority {

    @Id
    @NotNull
    @Size(min = 0, max = 50)
    private String  name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "name='" + name + '\'' +
                '}';
    }
}
