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
public class EmergencyContactsEntity {
    private String emergency_id;
    private String emergency_criteria;
    private String emergency_contact;

    public String getEmergency_id() {
        return emergency_id;
    }

    public void setEmergency_id(String emergency_id) {
        this.emergency_id = emergency_id;
    }

    public String getEmergency_criteria() {
        return emergency_criteria;
    }

    public void setEmergency_criteria(String emergency_criteria) {
        this.emergency_criteria = emergency_criteria;
    }

    public String getEmergency_contact() {
        return emergency_contact;
    }

    public void setEmergency_contact(String emergency_contact) {
        this.emergency_contact = emergency_contact;
    }
    
    
    
}
