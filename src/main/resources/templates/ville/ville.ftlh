<html>
<head>
    <#include "../import.ftlh">
    <title>${route.getName()}</title>
</head>
<body>
<#include "../menu.ftlh">

<div class="container">
    <#if user.administrateur == true>
    <h3>Filtrer les villes</h3>


    <div class="col-lg-12">
        <#if filtre??>
            <span href="/ville/" class="badge badge-pill badge-secondary"
                  style="margin-right: 15px;"><strong>Filtre : </strong> ${filtre} <i class="fa fa-times-circle fa-1x"
                                                                                      onClick="window.location.href = '/ville/'"
                                                                                      style="cursor: pointer;"></i></span>
        </#if>

        <form action="/ville/rechercher/" method="post" class="form-inline">

            <div class="form-group" style="margin-right: 15px;margin-top: 5px;">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="text" class="form-control" id="ville" placeholder="Le nom contient..." name="ville">
            </div>
            <button type="submit" class="btn btn-primary">RECHERCHER</button>
        </form>
    </div>

    <div class="col-lg-12">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Ville</th>
                <th>Code Postal</th>
                <th></th>

            </tr>
            </thead>
    <#list villes as ville>
    <tr>
        <td>${ville.ville}</td>
        <td>${ville.codePostal}</td>
        <td>

            <div style="display:flex;text-align: center;">
                <div style="flex:1">
                    <a href="/ville/edit/${ville.id}/"><i class="fas fa-edit" style="color:#007bff;"></i></a>
                </div>
                <div style="flex:1">
                    <a href="/ville/delete/${ville.id}/"><i class="fas fa-trash-alt" style="color:red;"></i></a>
                </div>
            </div>
        </td>

    </tr>
    </#list>
            <tfoot>
            <form action="/ville/" method="post">
                <tr>
                    <th>


                            <input type="text" class="form-control" id="ville" name="ville" placeholder="Ville">

                    </th>
                    <th>


                            <input type="text" class="form-control" id="codePostal" name="codePostal" placeholder="Code postal">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                    </th>






                    <th style="padding-left: 0px;padding-right: 0px;">
                        <div style="display:flex;text-align: center;">
                             <div style="flex:1">
                                <button type="submit" class="btn btn-primary btn-sm">Ajouter</button>
                            </div>
                        </div>
                    </th>








                </tr>
            </tfoot>
            </form>
        </table>

    <#else>
<p style="margin-left:50px;margin-top:10px;color:red;font-size: 17px">Vous n'êtes pas autorisé à accéder à cette page</p>
    </#if>
</div>



<#include "../script.ftlh">
</body>
</html>