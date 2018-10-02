package com.sortir.sortir.controller.route.ville;

import com.sortir.sortir.controller.route.HomeRoute;
import com.sortir.sortir.controller.route.IRoute;

public class VilleEditRoute implements IRoute {

    public VilleEditRoute() {
    }

    @Override
    public String getName() {
        return "Modifier une ville";
    }

    @Override
    public String getTemplate() {
        return "ville/ville-edit";
    }

    @Override
    public String getMenu() {
        return "ville";
    }

    @Override
    public String getUrl() {
        return "/ville/edit/";
    }

    @Override
    public IRoute getParent() {
        return new HomeRoute();
    }
}
