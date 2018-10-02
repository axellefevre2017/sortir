<html>
<head>
    <#include "../import.ftlh">
    <title>${route.getName()}</title>
</head>
<body>
<#include "../menu.ftlh">
<#include "../breadcrumb.ftlh">

<div class="container">
    <form action="/ville/rechercher/" method="post">
        <h3>Filtrer les villes</h3>
        <#if filtre??>
        <span href="/ville/" class="badge badge-pill badge-primary"><strong>Filtre : </strong> ${filtre}</span>
        </#if>
        <div class="form-group">
            <input type="text" class="form-control" id="ville" placeholder="Le nom contient..." name="ville">
        </div>
        <button type="submit" class="btn btn-primary">RECHERCHER</button>
    </form>
    <div class="col-lg-12"
    <div class="table-responsive">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Ville</th>
                <th>Code Postal</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
    <#list villes as ville>
    <tr>
        <td>${ville.ville}</td>
        <td>${ville.codePostal}</td>
        <td>MODIFIER</td>
        <td>SUPPRIMER</td>
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