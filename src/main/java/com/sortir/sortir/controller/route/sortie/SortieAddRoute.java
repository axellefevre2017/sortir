package com.sortir.sortir.controller.route.sortie;

import com.sortir.sortir.controller.route.HomeRoute;
import com.sortir.sortir.controller.route.IRoute;

public class SortieAddRoute implements IRoute {

    public SortieAddRoute() {
    }

    @Override
    public String getName() {
        return "Ajouter une sortie";
    }

    @Override
    public String getTemplate() {
        return "sortie/sortie-add";
    }

    @Override
    public String getMenu() {
        return "sortie";
    }

    @Override
    public String getUrl() {
        return "/sortie/add/";
    }

    @Override
    public IRoute getParent() {
        return new HomeRoute();
    }
}
