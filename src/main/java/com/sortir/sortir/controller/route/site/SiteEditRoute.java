package com.sortir.sortir.controller.route.site;

import com.sortir.sortir.controller.route.HomeRoute;
import com.sortir.sortir.controller.route.IRoute;

public class SiteEditRoute implements IRoute {

    public SiteEditRoute() {
    }

    @Override
    public String getName() {
        return "Modification d'un site";
    }

    @Override
    public String getTemplate() {
        return "site/site-edit";
    }

    @Override
    public String getMenu() {
        return "site";
    }

    @Override
    public String getUrl() {
        return "/site/edit/";
    }

    @Override
    public IRoute getParent() {
        return new HomeRoute();
    }
}
