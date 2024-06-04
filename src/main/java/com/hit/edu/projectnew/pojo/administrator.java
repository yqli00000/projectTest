package com.hit.edu.projectnew.pojo;

public class administrator {
    private Integer AID;
    private Integer telephone;
    private String name;
    private String code;
    private String email;

    public administrator() {
    }

    public administrator(Integer AID, Integer telephone, String name, String code, String email) {
        this.AID = AID;
        this.telephone = telephone;
        this.name = name;
        this.code = code;
        this.email = email;
    }

    public Integer getAID() {
        return AID;
    }

    public void setAID(Integer AID) {
        this.AID = AID;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "administrator{" +
                "AID=" + AID +
                ", telephone=" + telephone +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
