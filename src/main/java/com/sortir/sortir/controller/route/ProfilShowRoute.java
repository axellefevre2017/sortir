package com.sortir.sortir.controller.route;

public class ProfilShowRoute implements IRoute {

    public ProfilShowRoute() {
    }

    @Override
    public String getName() {
        return "Consulter un profil";
    }

    @Override
    public String getTemplate() {
        return "profil-show";
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
