<html>
<head>
    <#include "../import.ftlh">
    <title>${route.getName()}</title>
    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.3.4/dist/leaflet.css" integrity="sha512-puBpdR0798OZvTTbP4A8Ix/l+A4dHDD0DGqYW6RQ+9jxkRFclaxxQb/SJAWZfWAkuyeQUytO7+7N4QKrDh+drA==" crossorigin=""/>
    <script src="https://unpkg.com/leaflet@1.3.4/dist/leaflet.js" integrity="sha512-nMMmRyTVoLYqjP9hrbed9S+FzjZHW5gY1TWCHA5ckwXZBadntCNs8kEqAWdrb9O7rxbCaA4lKTIWjDXZxflOcA==" crossorigin=""></script>
    <style>
        #mapid { height: 300px; }
    </style>
</head>
<body>
<#include "../menu.ftlh">


<center>
    <div class="card col-lg-8 col-lg-offset-2 col-sm-9 col-sm-offset-1" style="margin-bottom: 50px;margin-top:25px;padding-bottom: 10px;padding-left: 0px;padding-right: 0px;">

        <div style="height:120px;background-color: #1fc8db;background-image: linear-gradient(141deg, #9fb8ad 0%, #1fc8db 51%, #2cb5e8 75%);">

            <img style="height:200px;width:200px;margin-top:10px;" class="card-img-top rounded-circle" src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Colombus_Isle.JPG/1200px-Colombus_Isle.JPG"
                 alt="Card image cap">

        </div>
        <div style="height:100px;">
        </div>


        <div class="card-body" style="text-align: left;">
            <div style="display: flex">
                <div style="flex: 1"></div>
                <div style="flex: 2">
                    <h5 class="card-title" style="text-align: center;"> <#if sortie.nom??>${sortie.nom}</#if></h5>
                </div>
                <div style="flex: 1">
                    <#if inscrit == true>
                        <a href="/sortie/show/${sortie.id}/desinscription/" class="btn btn-danger">Se Désinscrire</a>
                        <#else>
                        <a href="/sortie/show/${sortie.id}/inscription/" class="btn btn-primary">S'Inscrire</a>
                    </#if>
                </div>
            </div>
            <hr>

            <div style="display:flex;">
                <div style="flex:3;">
                    Nom de la sortie :</br>
                    Date et Heure :</br>
                    Date limite d'inscription :</br>
                    Nombre de place :</br>
                    Durée :</br>
                    Description et infos :</br>
                </div>
                <div style="flex:2;">
            <#if sortie.nom??>${sortie.nom}</#if></br>
            <#if sortie.dateDebut??>${sortie.dateDebut}</#if></br>
            <#if sortie.dateLimiteInscription??>${sortie.dateLimiteInscription}</#if></br>
            <#if sortie.nbInscriptionsMax??>${sortie.nbInscriptionsMax}</#if></br>
            <#if sortie.duree??>${sortie.duree}</#if></br>
            <#if sortie.infosSortie??>${sortie.infosSortie}</#if></br>
                </div>
                <div style="flex:1;"></div>
                <div style="flex:3;">
                    Ville organisatrice :</br>
                    Lieu :</br>
                    Rue :</br>
                    Code Postal :</br>
                    Latitude :</br>
                    Longitude :</br>
                </div>
                <div style="flex:2;">
            <#if sortie.lieu.ville.ville??>${sortie.lieu.ville.ville}</#if></br>
            <#if sortie.lieu.libelle??>${sortie.lieu.libelle}</#if></br>
            <#if sortie.lieu.rue??>${sortie.lieu.rue}</#if></br>
            <#if sortie.lieu.ville.codePostal??>${sortie.lieu.ville.codePostal}</#if></br>
            <#if sortie.lieu.latitude??>${sortie.lieu.latitude?string["0.#######"]}</#if></br>
            <#if sortie.lieu.longitude??>${sortie.lieu.longitude?string["0.#######"]}</#if></br>
                </div>






        </div>
</center>





<center>
    <div class="card" style="width: 35rem;margin-bottom: 50px;margin-top:25px;padding-bottom: 10px;">

        <div class="card-body" style="text-align: left;">
            <h5 class="card-title" style="text-align: center;">Liste des participants</h5>
            <hr>
<table class="table table-bordered">
                <thead>
                <th>Pseudo</th>
                <th>Nom</th>
                </thead>
                <tbody>
        <#list participants as participant>
        <tr onclick="window.location.href = '/profil/${participant.id.participant.id}/';">
        <td>${participant.id.participant.pseudo}</td>
        <td>${participant.id.participant.prenom + ' ' + participant.id.participant.nom}</td>
        </tr>
        </#list>
                </tbody>
            </table>
        </div>
        <#if sortie.lieu.latitude?? && sortie.lieu.longitude??>
        <div id="mapid" style="width: 600px; height: 400px;"></div>
        <script>

            var mymap = L.map('mapid').setView([${sortie.lieu.latitude?string["0.#######"]?replace(",", ".")}, ${sortie.lieu.longitude?string["0.#######"]?replace(",", ".")}], 13);
            var marker = L.marker([${sortie.lieu.latitude?string["0.#######"]?replace(",", ".")}, ${sortie.lieu.longitude?string["0.#######"]?replace(",", ".")}]).addTo(mymap);

            L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw', {
                maxZoom: 18,
                id: 'mapbox.streets'
            }).addTo(mymap);

        </script>
        </#if>

    </div>
</center>






<#include "../script.ftlh">
</body>
</html>