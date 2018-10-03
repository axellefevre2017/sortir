<html>
<head>
    <#include "../import.ftlh">
    <title>${route.getName()}</title>
</head>
<body>
<#include "../menu.ftlh">
<#include "../breadcrumb.ftlh">

<div class="container">
    <form action="/site/rechercher/" method="post">
        <h3>Filtrer les sites</h3>
        <#if filtre??>
        <span href="/site/" class="badge badge-pill badge-primary"><strong>Filtre : </strong> ${filtre}</span>
        </#if>
        <div class="form-group">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="text" class="form-control" id="site" placeholder="Le nom contient..." name="site">
        </div>
        <button type="submit" class="btn btn-primary">RECHERCHER</button>
    </form>
    <div class="col-lg-12"
    <div class="table-responsive">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Site</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
    <#list sites as site>
    <tr>
        <td>${site.libelle}</td>
        <td>MODIFIER</td>
        <td>SUPPRIMER</td>
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
                    <th colspan="2">
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