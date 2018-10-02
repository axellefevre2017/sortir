<html>
<head>
    <#include "../import.ftlh">
    <title>${route.getName()}</title>
</head>
<body>
<#include "../menu.ftlh">
<#include "../breadcrumb.ftlh">

<div class="container">
    <form action="/ville/edit/${ville.id}/" method="post">
        <div class="form-group">
            <label for="ville">Ville</label>
            <input type="text" class="form-control" id="ville" name="ville" <#if ville??>value="${ville.ville}"</#if>>
        </div>
        <div class="form-group">
            <label for="codePostal">Code Postal</label>
            <input type="text" class="form-control" id="codePostal" name="codePostal" <#if ville??>value="${ville.codePostal}"</#if>>
        </div>
        <button type="submit" class="btn btn-primary">Modifier</button>
        </tfoot>
    </form>

</div>



<#include "../script.ftlh">
</body>
</html>