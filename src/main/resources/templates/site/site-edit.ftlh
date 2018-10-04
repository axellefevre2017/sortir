<html>
<head>
    <#include "../import.ftlh">
    <title>${route.getName()}</title>
</head>
<body>
<#include "../menu.ftlh">

<div class="container">
    <#if user.administrateur == true>
    <form action="/site/edit/${site.id}/" method="post">
        <div class="form-group">
            <label for="site">Site</label>

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="text" class="form-control" id="site" name="site"  <#if site??>value="${site.libelle}"</#if>>
        </div>
        <button type="submit" class="btn btn-primary">Modifier</button>
    </form>
    </#if>
</div>



<#include "../script.ftlh">
</body>
</html>