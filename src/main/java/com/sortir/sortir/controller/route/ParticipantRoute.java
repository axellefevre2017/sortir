package com.sortir.sortir.controller.route;

public class ParticipantRoute implements IRoute {

    public ParticipantRoute() {
    }

    @Override
    public String getName() {
        return "Liste des utilisateurs";
    }

    @Override
    public String getTemplate() {
        return "participant/participant";
    }

    @Override
    public String getMenu() {
        return "utilisateur";
    }

    @Override
    public String getUrl() {
        return "/participants/";
    }

    @Override
    public IRoute getParent() {
        return new HomeRoute();
    }
}
