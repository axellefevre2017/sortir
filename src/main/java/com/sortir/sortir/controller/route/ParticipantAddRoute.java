package com.sortir.sortir.controller.route;

public class ParticipantAddRoute implements IRoute {

    public ParticipantAddRoute() {
    }

    @Override
    public String getName() {
        return "Ajouter un utilisateur";
    }

    @Override
    public String getTemplate() {
        return "participant/participant-add";
    }

    @Override
    public String getMenu() {
        return "utilisateur";
    }

    @Override
    public String getUrl() {
        return "/participants/add/";
    }

    @Override
    public IRoute getParent() {
        return new ParticipantRoute();
    }
}
