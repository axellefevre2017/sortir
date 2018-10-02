package com.sortir.sortir.controller.route;

public interface IRoute {


    public String getName();
    public String getTemplate();
    public String getMenu();
    public String getUrl();
    public IRoute getParent();



}
