<html>
<head>
    <#include "../import.ftlh">
    <title>${route.getName()}</title>
</head>
<body>
<#include "../menu.ftlh">
<#include "../breadcrumb.ftlh">

<div class="container">

    <div style="display:flex;">
        <div style="flex:1;">

        </div>
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
        <div style="flex:1;"></div>
    </div>
    <h3>Liste des participants</h3>
    <table>
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
<#include "../script.ftlh">
</body>
</html>