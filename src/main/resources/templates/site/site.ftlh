<html>
<head>
    <#include "../import.ftlh">
    <title>${route.getName()}</title>
</head>
<body>
<#include "../menu.ftlh">

<div class="container">
    <#if user.administrateur == true>
        <h3>Filtrer les sites</h3>

        <div class="col-lg-12">

        <#if filtre??>
        <span href="/site/" class="badge badge-pill badge-primary"><strong>Filtre : </strong> ${filtre} <i
                class="fa fa-times-circle fa-1x" onClick="window.location.href = '/site/'" style="cursor: pointer;"></i></span>
        </#if>

            <form action="/site/rechercher/" method="post" class="form-inline">

                <div class="form-group">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <input type="text" class="form-control" id="site" placeholder="Le nom contient..." name="site">
                </div>

                <button type="submit" class="btn btn-primary">RECHERCHER</button>
            </form>
        </div>


        <div class="col-lg-12"
        <div class="table-responsive">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>Site</th>
                    <th>Rue</th>
                    <th>Ville</th>
                    <th>Latitude</th>
                    <th>Longitude</th>
                    <th></th>

                </tr>
                </thead>
                <tbody>
    <#list sites as site>
    <tr>
        <td>${site.libelle}</td>
        <td>${site.rue}</td>
        <td>${site.ville.ville}</td>
        <td>${site.latitude?string["0.######"]}</td>
        <td>${site.longitude?string["0.######"]}</td>
        <td>

            <div style="display:flex;text-align: center;">
                <div style="flex:1">
                    <a href="/site/edit/${site.id}/"><i class="fas fa-edit" style="color:#007bff;"></i></a>
                </div>
                <div style="flex:1">
                    <a href="/site/delete/${site.id}/"><i class="fas fa-trash-alt" style="color:red;"></i></a>
                </div>
            </div>
        </td>
    </tr>
    </#list>
                </tbody>
                <tfoot>
                <form action="/site/" method="post">
                    <tr>
                        <th>

                            <input type="text" class="form-control" id="site" name="site" placeholder="Site">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                        </th>
                        <th>
                            <input type="text" class="form-control" id="rue" name="rue" placeholder="Rue">
                        </th>
                        <th>
                            <select class="form-control" id="ville" name="ville">
                                <#list villes as ville>
                                    <option value="${ville.id}">${ville.ville}</option>
                                </#list>
                            </select>
                        </th>
                        <th>
                            <input type="text" class="form-control" id="latitude" name="latitude"
                                   placeholder="Latitude">
                        </th>
                        <th>
                            <input type="text" class="form-control" id="longitude" name="longitude"
                                   placeholder="Longitude">
                        </th>


                        <th style="padding-left: 0px;padding-right: 0px;width:100px;">
                            <div style="display:flex;text-align: center;">

                                <div style="flex:1">
                                    <button type="submit" class="btn btn-primary btn-sm" style="">Ajouter</button>
                                </div>

                            </div>
                        </th>


                    </tr>
                </tfoot>
                </form>
            </table>
        </div>
    </#if>
</div>



<#include "../script.ftlh">
</body>
</html>