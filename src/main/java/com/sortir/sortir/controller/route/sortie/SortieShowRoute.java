package com.sortir.sortir.controller.route.sortie;

import com.sortir.sortir.controller.route.HomeRoute;
import com.sortir.sortir.controller.route.IRoute;

public class SortieShowRoute implements IRoute {

    public SortieShowRoute() {
    }

    @Override
    public String getName() {
        return "Afficher une sortie";
    }

    @Override
    public String getTemplate() {
        return "sortie/sortie-show";
    }

    @Override
    public String getMenu() {
        return "sortie";
    }

    @Override
    public String getUrl() {
        return "/sortie/show/";
    }

    @Override
    public IRoute getParent() {
        return new HomeRoute();
    }
}
