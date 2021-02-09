package com.learning.quack;

public class model {
    String account_id, email, family_name, given_name, image, name, post;

    public model() {

    }

    public model(String account_id, String email, String family_name, String given_name, String image, String name, String post) {
        this.account_id = account_id;
        this.email = email;
        this.family_name = family_name;
        this.given_name = given_name;
        this.image = image;
        this.name = name;
        this.post = post;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public String getGiven_name() {
        return given_name;
    }

    public void setGiven_name(String given_name) {
        this.given_name = given_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

}
