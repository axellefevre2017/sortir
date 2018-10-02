<html>
<head>
    <#include "../import.ftlh">
    <title>${route.getName()}</title>
</head>
<body>
<#include "../menu.ftlh">
<#include "../breadcrumb.ftlh">

<div class="container">
    <form action="/site/edit/${site.id}/" method="post">
        <div class="form-group">
            <label for="site">Site</label>
            <input type="text" class="form-control" id="site" name="site"  <#if site??>value="${site.libelle}"</#if>>
        </div>
        <button type="submit" class="btn btn-primary">Modifier</button>
    </form>
</div>



<#include "../script.ftlh">
</body>
</html>