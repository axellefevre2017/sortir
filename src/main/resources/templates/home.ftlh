<html>
<head>
    <#include "import.ftlh">
    <#include "script.ftlh">
    <title>${route.getName()}</title>
</head>
<body>
<#include "menu.ftlh">

<div style="margin-left:15px;margin-top:20px;margin-bottom: 15px;">
    <h4 style="display:inline;">Filtrer les sorties</h4>
    <i class="fas fa-angle-down fa-2x" data-toggle="collapse" data-target="#demo" style="display:inline; position :relative;top : 5px;"></i>
</div>

<div id="demo" class="collapse">
    <form method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div style="display:flex;text-align:left;">

            <div style="flex:1">
                <div class="col-lg-10">
                     <div class="form-group">
                        <label for="ville">Site :</label>
                         <select class="form-control" id="site">
                         <#list sites as site>
                             <option value="${site.id}">${site.libelle}</option>
                         </#list>
                        </select>
                    </div>
                </div>
            </div>


            <div style="flex:1">
                <div class="col-lg-10">
                    <div class="form-group">
                        <label for="date">Le nom de la sortie :</label>
                        <input type="text" class="form-control" id="name_sortie" name="name_sortie">
                    </div>
                </div>
            </div>


            <div style="flex:1">
                <div class="col-lg-10">
                    <div class="form-group">
                        <label for="limite">Entre :</label>
                        <input type="datetime-local" class="form-control" id="date_debut" name="date_debut">
                    </div>
                </div>
            </div>

            <div style="flex:1">
                <div class="col-lg-10">
                    <div class="form-group">
                        <label for="nombre">et :</label>
                        <input type="datetime-local" class="form-control" id="date_fin" name="date_fin">
                    </div>
                </div>
            </div>

            <div style="flex:2">

                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="publier" name="etat">
                        <label class="form-check-label" for="publier" >
                        Sorties dont je suis l'organisateur/trice
                        </label>
                </div>

                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="publier" name="etat">
                    <label class="form-check-label" for="publier" >
                        Sorties auxquelles je suis inscrit/e
                    </label>
                </div>

                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="publier" name="etat">
                        <label class="form-check-label" for="publier" >
                        Sorties auxquelles je ne suis pas inscrit/e
                        </label>
                </div>

                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="publier" name="etat">
                    <label class="form-check-label" for="publier" >
                        Sorties passées
                    </label>
                </div>

            </div>

            <div style="flex:1">
                <button type="submit" class="btn btn-primary">Rechercher</button>
            </div>

        </div>
    </form>
</div>

</div>

    <div class="col-lg-12" style="margin-top:30px;">
        <div class="table-responsive">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="hidden-xs-down">Nom de la sortie</th>
                        <th>Date de la sortie</th>
                        <th class="d-none d-lg-table-cell">Clôture</th>
                        <th class="">inscrits/places</th>
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
                        <td class="d-none d-lg-table-cell"><#if sortie.dateLimiteInscription??>${sortie.dateLimiteInscription}</#if></td>
                        <td class=""><#if sortie.nbInscriptionsMax??>à faire/${sortie.nbInscriptionsMax}</#if></td>
                        <td><#if sortie.etat??>${sortie.etat.libelle}</#if></td>
                        <td>à faire</td>
                        <td><#if sortie.organisateur??>${sortie.organisateur.nom + ' ' + sortie.organisateur.prenom}</#if></td>
                        <td>
                            <div style="display:flex;text-align: center;">
                                <div style="flex:1">
                                    <a href="/sortie/edit/${sortie.id}/"><i class="fas fa-edit"></i></a>
                                </div>
                                <div style="flex:1">
                                    <a href="/sortie/delete/${sortie.id}/"><i class="fas fa-trash-alt"></i></a>
                                </div>
                            </div>

                        </td>
                    </tr>
                </tbody>
                </#list>
            </table>
        </div>
    </div>



</body>
</html>