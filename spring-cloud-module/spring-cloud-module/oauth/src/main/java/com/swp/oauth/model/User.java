package com.swp.oauth.model;

import javax.persistence.*;
import java.util.Set;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-07-30 10:17 AM
 */
@Entity
public class User {

    @Id
    @Column(updatable = false, nullable = false)
    private String username;

    private String email;

    private String password;

    private Boolean activated;

    private String activationkey;

    private String  resetpasswordkey;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "authority"))
    private Set<Authority> authorities;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public String getActivationkey() {
        return activationkey;
    }

    public void setActivationkey(String activationkey) {
        this.activationkey = activationkey;
    }

    public String getResetpasswordkey() {
        return resetpasswordkey;
    }

    public void setResetpasswordkey(String resetpasswordkey) {
        this.resetpasswordkey = resetpasswordkey;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", activated=" + activated +
                ", activationkey='" + activationkey + '\'' +
                ", resetpasswordkey='" + resetpasswordkey + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}
