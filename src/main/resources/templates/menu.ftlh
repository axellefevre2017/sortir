<nav class="mb-1 navbar navbar-expand-lg navbar-dark blue lighten-1">
    <a class="navbar-brand" href="javascript:;;">SORTIR.COM</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-5" aria-controls="navbarSupportedContent-5" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent-5">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item <#if route.getMenu()=='accueil'>active</#if>">
                <a class="nav-link waves-effect waves-light" href="/">ACCUEIL
                    <span class="sr-only">(current)</span>
                </a>
            </li>
            <#if user.administrateur == true>
            <li class="nav-item <#if route.getMenu()=='ville'>active</#if>">
                <a class="nav-link waves-effect waves-light" href="/ville/">VILLES</a>
            </li>
            <li class="nav-item <#if route.getMenu()=='site'>active</#if>">
                <a class="nav-link waves-effect waves-light" href="/site/">SITES</a>
            </li>
            <li class="nav-item <#if route.getMenu()=='utilisateur'>active</#if>">
                <a class="nav-link waves-effect waves-light" href="/participant/">UTILISATEURS</a>
            </li>
            </#if>
        </ul>
        <ul class="navbar-nav ml-auto nav-flex-icons">
                <span class="navbar-text white-text" style="margin-top:7px">
                ${user.prenom + ' ' + user.nom}
                </span>
            <li class="nav-item avatar dropdown">
                <a class="nav-link dropdown-toggle waves-effect waves-light" id="navbarDropdownMenuLink-5" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                    <img style="height:35px;" src="${user.photo}" class="img-fluid rounded-circle z-depth-0">
                </a>
                <div class="dropdown-menu dropdown-menu-right dropdown-purple" aria-labelledby="navbarDropdownMenuLink-5">
                    <a class="dropdown-item waves-effect waves-light" href="/profil/">MON PROFIL</a>
                    <a class="dropdown-item waves-effect waves-light" href="/logout/">DECONNEXION</a>
                </div>
            </li>
        </ul>
    </div>
</nav>

<#include "breadcrumb.ftlh">

<#if errors?? >
    <div class="col-offset-2 col-lg-10 alert alert-danger" style="margin:0 auto;margin-top:10px;margin-bottom:10px;">
        <#list errors as error>
            <strong>Erreur !</strong> ${error}</br>
        </#list>
    </div>
</#if>
<#if success?? >
    <div class="col-offset-2 col-lg-10 alert alert-success" style="margin:0 auto;margin-top:10px;margin-bottom:10px;">
        <#list success as succes>
            <strong>Succès !</strong> ${succes}</br>
        </#list>
    </div>
</#if>