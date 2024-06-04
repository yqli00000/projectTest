package com.hit.edu.projectnew.pojo;

public class teacher {
    private String TID;
    private String name;
    private Integer gender;
    private Integer telephone;
    private String email;
    private String code;

    public teacher() {
    }

    public teacher(String TID, String name, Integer gender, Integer telephone, String email, String code) {
        this.TID = TID;
        this.name = name;
        this.gender = gender;
        this.telephone = telephone;
        this.email = email;
        this.code = code;
    }

    public String getTID() {
        return TID;
    }

    public String getName() {
        return name;
    }

    public Integer getGender() {
        return gender;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public String getCode() {
        return code;
    }

    public void setTID(String TID) {
        this.TID = TID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCode(String code) {
        this.code = code;
    }



    @Override
    public String toString() {
        return "teacher{" +
                "TID='" + TID + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", telephone=" + telephone +
                ", email='" + email + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
