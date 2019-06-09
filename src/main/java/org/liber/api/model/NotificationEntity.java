/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.liber.api.model;

/**
 *
 * @author prashant
 */
public class NotificationEntity {
private String NId;
private String NText;
private String NMob;
private String NUser;
private String NDate;
private String NDelete;

    public String getNId() {
        return NId;
    }

    public void setNId(String NId) {
        this.NId = NId;
    }

    public String getNText() {
        return NText;
    }

    public void setNText(String NText) {
        this.NText = NText;
    }

    public String getNMob() {
        return NMob;
    }

    public void setNMob(String NMob) {
        this.NMob = NMob;
    }

    public String getNUser() {
        return NUser;
    }

    public void setNUser(String NUser) {
        this.NUser = NUser;
    }

    public String getNDate() {
        return NDate;
    }

    public void setNDate(String NDate) {
        this.NDate = NDate;
    }

    public String getNDelete() {
        return NDelete;
    }

    public void setNDelete(String NDelete) {
        this.NDelete = NDelete;
    }


}
