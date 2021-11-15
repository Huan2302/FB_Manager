package com.FB.Model;

public class FBAccount implements Comparable<FBAccount>{
    private String facebook_id;
    private String phone;
    private Integer stt;
    private String name;
    private String gender;
    private String birthday;
    private String email;
    private String location;

    public Integer getStt() {
        return stt;
    }

    public void setStt(Integer stt) {
        this.stt = stt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFacebook_id() {
        return facebook_id;
    }

    public void setFacebook_id(String facebook_id) {
        this.facebook_id = facebook_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public int compareTo(FBAccount o) {
        return this.getFacebook_id().compareTo(o.getFacebook_id());
    }

    @Override
    public String toString() {
        return "FBAccount{" +
                "facebook_id='" + facebook_id + '\'' +
                ", phone='" + phone + '\'' +
                ", stt=" + stt +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
