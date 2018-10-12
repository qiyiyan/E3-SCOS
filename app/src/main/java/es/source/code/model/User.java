package es.source.code.model;

import java.io.Serializable;

public class User implements Serializable {
    private String userName;
    private String password;
    private Boolean oldUser;

    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getUserName(){
        return this.userName;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }
    public void setOldUser(Boolean oldUser){
        this.oldUser = oldUser;
    }
    public Boolean getOldUser(){
        return this.oldUser;
    }
}
