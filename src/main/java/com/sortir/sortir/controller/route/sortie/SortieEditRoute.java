package com.sortir.sortir.controller.route.sortie;

import com.sortir.sortir.controller.route.HomeRoute;
import com.sortir.sortir.controller.route.IRoute;

public class SortieEditRoute implements IRoute {

    public SortieEditRoute() {
    }

    @Override
    public String getName() {
        return "Modifier une sortie";
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
        return "/sortie/edit/";
    }

    @Override
    public IRoute getParent() {
        return new HomeRoute();
    }
}
