package com.sortir.sortir.controller.route;

public class ProfilRoute implements IRoute {

    public ProfilRoute() {
    }

    @Override
    public String getName() {
        return "Mon Profil";
    }

    @Override
    public String getTemplate() {
        return "profil";
    }

    @Override
    public String getMenu() {
        return "profil";
    }

    @Override
    public String getUrl() {
        return "/profil/";
    }

    @Override
    public IRoute getParent() {
        return new HomeRoute();
    }
}
