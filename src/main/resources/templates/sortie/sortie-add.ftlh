<html>
<head>
    <#include "../import.ftlh">
    <title>${route.getName()}</title>
</head>
<body>
<#include "../menu.ftlh">

<div class="container">

    <form action="<#if sortie??>/sortie/edit/${sortie.id}/<#else>/sortie/add/</#if>" method="post">
        <div class="form-group">
            <label for="nom">Nom de la sortie</label>
            <input type="text" class="form-control" id="nom" name="nom" <#if sortie??>value="${sortie.nom}"</#if>>
        </div>
        <div class="form-group">
            <label for="date">Date et heure de la sortie</label>
            <input type="datetime-local" class="form-control" id="date" name="date" <#if sortie??>value="${sortie.dateDebut?string["yyyy-MM-dd'T'HH:mm"]}"</#if>>
        </div>
        <div class="form-group">
            <label for="limite">Date limite d'inscription</label>
            <input type="datetime-local" class="form-control" id="limite" name="limite" <#if sortie??>value="${sortie.dateLimiteInscription?string["yyyy-MM-dd'T'HH:mm"]}"</#if>>
        </div>
        <div class="form-group">
            <label for="nombre">Nombre de places</label>
            <input type="number" class="form-control" id="nombre" name="nombre" <#if sortie??>value="${sortie.nbInscriptionsMax}"</#if>>
        </div>
        <div class="form-group">
            <label for="duree">Durée</label>
            <input type="number" class="form-control" id="duree" name="duree" <#if sortie??>value="${sortie.duree}"</#if>>
        </div>
        <div class="form-group">
            <label for="description">Description & infos</label>
            <textarea class="form-control" id="description" name="description" rows="3"><#if sortie??>${sortie.infosSortie}</#if></textarea>
        </div>
        <div class="form-group">
            <label for="ville">Ville</label>
            <select class="form-control" id="ville">
                <#list villes as ville>
                <option value="${ville.id}" <#if sortie?? && sortie.lieu.ville.id==ville.id>selected</#if>>${ville.ville}</option>
                </#list>
            </select>
        </div>
        <div class="form-group">
            <label for="lieu">Lieu</label>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <select class="form-control" id="lieu" name="lieu">
                <#list lieux as lieu>
                    <option value="${lieu.id}"  <#if sortie?? && sortie.lieu.id==lieu.id>selected</#if>>${lieu.libelle}</option>
                </#list>
            </select>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="checkbox" id="publier" name="etat" <#if sortie?? && sortie.etat.id==3>checked</#if>>
            <label class="form-check-label" for="publier" >
                Publier
            </label>
        </div>
        <button type="submit" class="btn btn-primary"><#if sortie??>Modifier<#else>Ajouter</#if></button>
    </form>

</div>



<#include "../script.ftlh">
</body>
</html>