package com.sortir.sortir.controller.route.ville;

import com.sortir.sortir.controller.route.HomeRoute;
import com.sortir.sortir.controller.route.IRoute;

public class VilleRoute implements IRoute {

    public VilleRoute() {
    }

    @Override
    public String getName() {
        return "Gestion des villes";
    }

    @Override
    public String getTemplate() {
        return "ville/ville";
    }

    @Override
    public String getMenu() {
        return "ville";
    }

    @Override
    public String getUrl() {
        return "/ville/";
    }

    @Override
    public IRoute getParent() {
        return new HomeRoute();
    }
}
