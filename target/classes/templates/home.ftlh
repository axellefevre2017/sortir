<html>
<head>
    <#include "import.ftlh">
    <#include "script.ftlh">
    <title>${route.getName()}</title>
</head>
<body>
<#include "menu.ftlh">

    <div class="col-lg-12"
        <div class="table-responsive">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="hidden-xs-down">Nom de la sortie</th>
                        <th>Date de la sortie</th>
                        <th>Clôture</th>
                        <th>inscrits/places</th>
                        <th>Etat</th>
                        <th>Inscrit</th>
                        <th>Organisateur</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <#list sorties as sortie>
                <tbody>
                    <tr>
                        <td class="hidden-xs-down"><#if sortie.nom??>${sortie.nom}</#if></td>
                        <td><#if sortie.dateDebut??>${sortie.dateDebut}</#if></td>
                        <td><#if sortie.dateLimiteInscription??>${sortie.dateLimiteInscription}</#if></td>
                        <td><#if sortie.nbInscriptionsMax??>à faire/${sortie.nbInscriptionsMax}</#if></td>
                        <td><#if sortie.etat??>${sortie.etat.libelle}</#if></td>
                        <td>à faire</td>
                        <td><#if sortie.organisateur??>${sortie.organisateur.nom + ' ' + sortie.organisateur.prenom}</#if></td>
                        <td>SUPPRIMER</td>
                    </tr>
                </tbody>
                </#list>
            </table>
        </div>
    </div>


<div class="container">
    <div class="row">
        <div class="col-md-3 d-none d-lg-block">
            <p class="title">Join us</p>
            <p class="subtitle">Just click on the button below</p>
            <p class="link"><a href="#" class="outstanding-link">the button below</a></p>
        </div>
    </div>
</div>




</body>
</html>