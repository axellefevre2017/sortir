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
        <div class="form-group">
            <label for="rue">Rue</label>
            <input type="text" class="form-control" id="rue" name="rue"  <#if site??>value="${site.rue}"</#if>>
        </div>
        <div class="form-group">
            <label for="ville">Ville</label>
            <select class="form-control" id="ville" name="ville">
                                <#list villes as ville>
                                    <option value="${ville.id}" <#if ville.id== site.ville.id>selected</#if>>${ville.ville}</option>
                                </#list>
            </select>
        </div>
        <div class="form-group">
            <label for="latitude">Latitude</label>
            <input type="text" class="form-control" id="latitude" name="latitude"  <#if site??>value="${site.latitude?string["0.######"]}"</#if>>
        </div>
        <div class="form-group">
            <label for="longitude">Rue</label>
            <input type="text" class="form-control" id="longitude" name="longitude"  <#if site??>value="${site.longitude?string["0.######"]}"</#if>>
        </div>
        <button type="submit" class="btn btn-primary">Modifier</button>
    </form>
    <#else>
<p style="margin-left:50px;margin-top:10px;color:red;font-size: 17px">Vous n'êtes pas autorisé à accéder à cette page</p>
    </#if>
</div>



<#include "../script.ftlh">
</body>
</html>