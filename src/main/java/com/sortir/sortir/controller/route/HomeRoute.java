package com.sortir.sortir.controller.route;

public class HomeRoute implements IRoute {

    public HomeRoute() {
    }

    @Override
    public String getName() {
        return "Accueil";
    }

    @Override
    public String getTemplate() {
        return "home";
    }

    @Override
    public String getMenu() {
        return "accueil";
    }

    @Override
    public IRoute getParent() {
        return null;
    }
}
