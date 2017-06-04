/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.model;

/**
 *
 * @author Nipu
 */
public class BloodGroupEntity {
    private String member_id;
    private String member_name;
    private String member_blood_group;

    public String getMember_location() {
        return member_location;
    }

    public void setMember_location(String member_location) {
        this.member_location = member_location;
    }
    private String member_location;
    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }
    private String member_contact_no;

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getMember_blood_group() {
        return member_blood_group;
    }

    public void setMember_blood_group(String member_blood_group) {
        this.member_blood_group = member_blood_group;
    }

    public String getMember_contact_no() {
        return member_contact_no;
    }

    public void setMember_contact_no(String member_contact_no) {
        this.member_contact_no = member_contact_no;
    }
    
}
