package com.home.model;

public class EarningMemberEntity {
    private String id;
    private String earningmember_name;
    private String earningmember_occupation;
    private String earningmember_income;
    private String log_in_id;

    public String getLog_in_id() {
        return log_in_id;
    }

    public void setLog_in_id(String log_in_id) {
        this.log_in_id = log_in_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEarningmember_name() {
        return earningmember_name;
    }

    public void setEarningmember_name(String earningmember_name) {
        this.earningmember_name = earningmember_name;
    }

    public String getEarningmember_occupation() {
        return earningmember_occupation;
    }

    public void setEarningmember_occupation(String earningmember_occupation) {
        this.earningmember_occupation = earningmember_occupation;
    }

    public String getEarningmember_income() {
        return earningmember_income;
    }

    public void setEarningmember_income(String earningmember_income) {
        this.earningmember_income = earningmember_income;
    }
    
    
}
