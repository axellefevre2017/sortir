<html>
<head>
    <#include "../import.ftlh">
    <title>${route.getName()}</title>
</head>
<body>
<#include "../menu.ftlh">
<#include "../breadcrumb.ftlh">

<div class="container">
    <h3>Filtrer les sites</h3>

    <div class="col-lg-12">

        <#if filtre??>
        <span href="/site/" class="badge badge-pill badge-primary"><strong>Filtre : </strong> ${filtre} <i class="fa fa-times-circle fa-1x" onClick="window.location.href = '/site/'" style="cursor: pointer;"></i></span>
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
                <th></th>

            </tr>
            </thead>
    <#list sites as site>
    <tr>
        <td>${site.libelle}</td>
        <td>

            <div style="display:flex;text-align: center;">
                <div style="flex:1">
                    <a href="/site/edit/${site.id}/"><i class="fas fa-edit"></i></a>
                </div>
                <div style="flex:1">
                    <a href="/site/delete/${site.id}/"><i class="fas fa-trash-alt"></i></a>
                </div>
            </div>
        </td>
    </tr>
    </#list>
            <tfoot>
            <form action="/site/" method="post">
                <tr>
                    <th>
                        <div class="form-group">
                            <label for="site">Site</label>
                            <input type="text" class="form-control" id="site" name="site">
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