<html>
<head>
    <#include "import.ftlh">
    <title>${route.getName()}</title>
</head>
<body>
<#include "menu.ftlh">

<table>
<#list sorties as sortie>
    <tr>
        <td><#if sortie.nom??>${sortie.nom}</#if></td>
        <td><#if sortie.dateDebut??>${sortie.dateDebut}</#if></td>
        <td><#if sortie.dateLimiteInscription??>${sortie.dateLimiteInscription}</#if></td>
        <td><#if sortie.nbInscriptionsMax??>à faire/${sortie.nbInscriptionsMax}</#if></td>
        <td><#if sortie.etat??>${sortie.etat.libelle}</#if></td>
        <td>à faire</td>
        <td><#if sortie.organisateur??>${sortie.organisateur.nom + ' ' + sortie.organisateur.prenom}</#if></td>
        <td>SUPPRIMER</td>
    </tr>
</#list>
</table>

<#include "script.ftlh">
</body>
</html>