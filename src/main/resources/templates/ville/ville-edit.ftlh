<html>
<head>
    <#include "../import.ftlh">
    <title>${route.getName()}</title>
</head>
<body>
<#include "../menu.ftlh">

<div class="container">
    <#if user.administrateur == true>
        <form action="/ville/edit/${ville.id}/" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <div class="form-group">
                <label for="ville">Ville</label>
                <input type="text" class="form-control" id="ville" name="ville"
                       <#if ville??>value="${ville.ville}"</#if>>
            </div>
            <div class="form-group">
                <label for="codePostal">Code Postal</label>
                <input type="text" class="form-control" id="codePostal" name="codePostal"
                       <#if ville??>value="${ville.codePostal}"</#if>>
            </div>
            <button type="submit" class="btn btn-primary">Modifier</button>
            </tfoot>
        </form>
    <#else>
<p style="margin-left:50px;margin-top:10px;color:red;font-size: 17px">Vous n'êtes pas autorisé à accéder à cette page</p>
    </#if>
</div>



<#include "../script.ftlh">
</body>
</html>