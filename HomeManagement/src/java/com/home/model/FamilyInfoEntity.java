/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.model;

/**
 *
 * @author UrMeEe
 */
public class FamilyInfoEntity {
    private String log_in_id;
    private String member_id;
    private String family_location;
    private String member_name;

    public String getMember_location() {
        return member_location;
    }

    public void setMember_location(String member_location) {
        this.member_location = member_location;
    }
    private String member_gender;
    private String member_age;
    private String member_occupation;
    private String member_income;
    private String member_blood_group;
    private String member_contact_no;
    private String member_location;
    

    
    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }
    public String getMember_gender() {
        return member_gender;
    }

    public void setMember_gender(String member_gender) {
        this.member_gender = member_gender;
    }

    public String getMember_age() {
        return member_age;
    }

    public void setMember_age(String member_age) {
        this.member_age = member_age;
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
    public String getLog_in_id() {
        return log_in_id;
    }

    public String getFamily_location() {
        return family_location;
    }

    public void setFamily_location(String family_location) {
        this.family_location = family_location;
    }


    public void setLog_in_id(String log_in_id) {
        this.log_in_id = log_in_id;
    }
    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getMember_occupation() {
        return member_occupation;
    }

    public void setMember_occupation(String member_occupation) {
        this.member_occupation = member_occupation;
    }

    public String getMember_income() {
        return member_income;
    }

    public void setMember_income(String member_income) {
        this.member_income = member_income;
    }
 
}
