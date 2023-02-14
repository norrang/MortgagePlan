package com.norrang.mortgageplan;

public class Estimate {

    private String prospectName;
    private double loanSize;
    private double yearlyInterest;
    private int duration;
    private double monthlyMortgage;

    public Estimate() {}

    public Estimate(String prospectName, double loanSize, double yearlyInterest, int duration) {
        this.prospectName = prospectName;
        this.loanSize = loanSize;
        this.yearlyInterest = yearlyInterest;
        this.duration = duration;
        this.monthlyMortgage = Utils.round(Utils.calculateMortgage(loanSize, yearlyInterest, duration) * 100) / 100;
    }

    public void calculateMonthlyMortgage() {
        monthlyMortgage = Utils.round(Utils.calculateMortgage(loanSize, yearlyInterest, duration) * 100) / 100;
    }

    public String getProspectName() {
        return prospectName;
    }

    public double getLoanSize() {
        return loanSize;
    }

    public double getYearlyInterest() {
        return yearlyInterest;
    }

    public int getDuration() {
        return duration;
    }

    public double getMonthlyMortgage() {
        return monthlyMortgage;
    }

    public void setProspectName(String prospectName) {
        this.prospectName = prospectName;
    }

    public void setLoanSize(double loanSize) {
        this.loanSize = loanSize;
    }

    public void setYearlyInterest(double yearlyInterest) {
        this.yearlyInterest = yearlyInterest;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}
