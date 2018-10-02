<html>
<head>
    <#include "../import.ftlh">
    <title>${route.getName()}</title>
</head>
<body>
<#include "../menu.ftlh">
<#include "../breadcrumb.ftlh">

<div class="container">
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
        </table>
    </div>
<form method="post">
    <div class="form-group">
        <label for="ville">Ville</label>
        <input type="text" class="form-control" id="ville" name="ville">
    </div>
    <div class="form-group">
        <label for="codePostal">Code Postal</label>
        <input type="text" class="form-control" id="codePostal" name="codePostal">
    </div>
    <button type="submit" class="btn btn-primary">Ajouter</button>
</form>

</div>



<#include "../script.ftlh">
</body>
</html>