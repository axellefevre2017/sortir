<html>
<head>
    <#include "../import.ftlh">
    <title>${route.getName()}</title>
</head>
<body>
<#include "../menu.ftlh">
<#include "../breadcrumb.ftlh">

<div class="container">

    <form action="/sortie/add/" method="post">
        <div class="form-group">
            <label for="nom">Nom de la sortie</label>
            <input type="text" class="form-control" id="nom" name="nom">
        </div>
        <div class="form-group">
            <label for="date">Date et heure de la sortie</label>
            <input type="datetime-local" class="form-control" id="date" name="date">
        </div>
        <div class="form-group">
            <label for="limite">Date limite d'inscription</label>
            <input type="datetime-local" class="form-control" id="limite" name="limite">
        </div>
        <div class="form-group">
            <label for="nombre">Nombre de places</label>
            <input type="number" class="form-control" id="nombre" name="nombre">
        </div>
        <div class="form-group">
            <label for="duree">Durée</label>
            <input type="number" class="form-control" id="duree" name="duree">
        </div>
        <div class="form-group">
            <label for="description">Description & infos</label>
            <textarea class="form-control" id="description" name="description" rows="3"></textarea>
        </div>
        <div class="form-group">
            <label for="ville">Ville</label>
            <select class="form-control" id="ville">
                <#list villes as ville>
                <option value="${ville.id}">${ville.ville}</option>
                </#list>
            </select>
        </div>
        <div class="form-group">
            <label for="lieu">Lieu</label>
            <select class="form-control" id="lieu" name="lieu">
                <#list lieux as lieu>
                    <option value="${lieu.id}">${lieu.libelle}</option>
                </#list>
            </select>
        </div>
        <div class="form-group">
            <label for="latitude">Latitude</label>
            <input type="text" class="form-control" id="latitude" name="latitude">
        </div>
        <div class="form-group">
            <label for="longitude">Longitude</label>
            <input type="text" class="form-control" id="longitude" name="longitude">
        </div>
        <div class="form-check">
            <input class="form-check-input" type="checkbox" id="publier" name="etat">
            <label class="form-check-label" for="publier" >
                Publier
            </label>
        </div>
        <button type="submit" class="btn btn-primary">Ajouter</button>
    </form>

</div>



<#include "../script.ftlh">
</body>
</html>