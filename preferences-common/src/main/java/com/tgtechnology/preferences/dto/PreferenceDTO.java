package com.tgtechnology.preferences.dto;

import java.util.Objects;

public class PreferenceDTO {

    private boolean email;
    private boolean post;
    private boolean sms;

    public PreferenceDTO(){
        // NoOp
    }
    public PreferenceDTO(boolean email, boolean post, boolean sms) {
        this.email = email;
        this.post = post;
        this.sms = sms;
    }

    public boolean isEmail() {
        return email;
    }

    public void setEmail(boolean email) {
        this.email = email;
    }

    public boolean isPost() {
        return post;
    }

    public void setPost(boolean post) {
        this.post = post;
    }

    public boolean isSms() {
        return sms;
    }

    public void setSms(boolean sms) {
        this.sms = sms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        var that = (PreferenceDTO) o;
        return email == that.email && post == that.post && sms == that.sms;
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, post, sms);
    }
}