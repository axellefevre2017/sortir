package com.sortir.sortir.controller.route.site;

import com.sortir.sortir.controller.route.HomeRoute;
import com.sortir.sortir.controller.route.IRoute;

public class SiteRoute implements IRoute {

    public SiteRoute() {
    }

    @Override
    public String getName() {
        return "Gestion des sites";
    }

    @Override
    public String getTemplate() {
        return "site/site";
    }

    @Override
    public String getMenu() {
        return "site";
    }

    @Override
    public String getUrl() {
        return "/site/";
    }

    @Override
    public IRoute getParent() {
        return new HomeRoute();
    }
}
