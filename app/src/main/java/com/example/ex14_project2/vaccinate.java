package com.example.ex14_project2;

public class vaccinate {
    private String vaccine_site;
    private String vaccine_date;

    public vaccinate(String vaccine_site, String vaccine_date)
    {
        this.vaccine_site = vaccine_site;
        this.vaccine_date = vaccine_date;
    }

    public void setVaccine_site(String vaccine_site)
    {
        this.vaccine_site = vaccine_site;
    }
    public void setVaccine_date(String vaccine_date)
    {
        this.vaccine_date = vaccine_date;
    }

    public String getVaccine_site()
    {
        return vaccine_site;
    }
    public String getVaccine_date()
    {
        return vaccine_date;
    }
}
