<html>
<head>
    <#include "../import.ftlh">
    <title>${route.getName()}</title>
</head>
<body>
<#include "../menu.ftlh">


<center>
    <div class="card" style="width: 75rem;margin-bottom: 50px;margin-top:25px;padding-bottom: 10px;">
        <div style="height:120px;background-color: #1fc8db;background-image: linear-gradient(141deg, #9fb8ad 0%, #1fc8db 51%, #2cb5e8 75%);">
            <img style="height:200px;width:200px;margin-top:10px;" class="card-img-top rounded-circle" src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Colombus_Isle.JPG/1200px-Colombus_Isle.JPG"
                 alt="Card image cap">

        </div>
        <div style="height:100px;">
        </div>


        <div class="card-body" style="text-align: left;">
            <h5 class="card-title" style="text-align: center;"> <#if sortie.nom??>${sortie.nom}</#if></h5>
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
            <#if sortie.latitude??>${sortie.latitude}</#if></br>
            <#if sortie.longitude??>${sortie.longitude}</#if></br>
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
        <td>${participant.id.participant.pseudo}</td>
        <td>${participant.id.participant.prenom + ' ' + participant.id.participant.nom}</td>
        </#list>
                </tbody>
            </table>
        </div>



    </div>
</center>






<#include "../script.ftlh">
</body>
</html>