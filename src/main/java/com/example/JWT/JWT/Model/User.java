package com.example.JWT.JWT.Model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    private  String userName;
    private String password;
    private boolean isEnabled;
    private String Authorites;


    //fun. for authorities

    public User(String userName, String password, boolean isEnabled, String authorites) {
        this.userName = userName;
        this.password = password;
        this.isEnabled = isEnabled;
        this.Authorites = authorites;
    }

    public User() {
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> roles = new ArrayList<>();
        String[] arr = Authorites.split(",");
        for (int i = 0; i < arr.length; i++) {
            GrantedAuthority obj = new SimpleGrantedAuthority(arr[i]);
            roles.add(obj);
        }
        return roles;
    }
    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }


}
