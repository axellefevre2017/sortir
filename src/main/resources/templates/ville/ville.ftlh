<html>
<head>
    <#include "../import.ftlh">
    <title>${route.getName()}</title>
</head>
<body>
<#include "../menu.ftlh">
<#include "../breadcrumb.ftlh">

<div class="container">
    <h3>Filtrer les villes</h3>


    <div class="col-lg-12">
        <#if filtre??>
            <span href="/ville/" class="badge badge-pill badge-secondary" style="margin-right: 15px;"><strong>Filtre : </strong> ${filtre} <i class="fa fa-times-circle fa-1x" onClick="window.location.href = '/ville/'" style="cursor: pointer;"></i></span>
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
    <div class="table-responsive">
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
                    <a href="/ville/edit/${ville.id}/"><i class="fas fa-edit"></i></a>
                </div>
                <div style="flex:1">
                    <a href="/ville/delete/${ville.id}/"><i class="fas fa-trash-alt"></i></a>
                </div>
            </div>

    </tr>
    </#list>
            <tfoot>
            <form action="/ville/" method="post">
                <tr>
                    <th>
                        <div class="form-group">
                            <label for="ville">Ville</label>
                            <input type="text" class="form-control" id="ville" name="ville">
                        </div>
                    </th>
                    <th>
                        <div class="form-group">
                            <label for="codePostal">Code Postal</label>
                            <input type="text" class="form-control" id="codePostal" name="codePostal">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </div>
                    </th>
                    <th>

                        <button type="submit" class="btn btn-primary">Ajouter</button>

                    </th>
                </tr>
            </tfoot>
            </form>
        </table>
    </div>

</div>



<#include "../script.ftlh">
</body>
</html>