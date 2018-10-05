<html>
<head>
    <#include "import.ftlh">
    <#include "script.ftlh">
    <title>${route.getName()}</title>
</head>
<body>
<#include "menu.ftlh">
<div style="margin-left:15px;margin-top:20px;margin-bottom: 15px;" class="d-none d-lg-table-cell">
    <h4 style="margin-left:15px;display:inline;" data-toggle="collapse" data-target="#demo">Filtrer les sorties</h4>
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
                         <select class="form-control" id="site" name="site">
                             <option value="0">CHOISIR</option>
                         <#list sites as site>
                             <option value="${site.id}">${site.ville}</option>
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
                    <input class="form-check-input" type="checkbox" id="organisateur" name="organisateur">
                        <label class="form-check-label" for="organisateur" >
                        Sorties dont je suis l'organisateur/trice
                        </label>
                </div>

                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="inscrit" name="inscrit">
                    <label class="form-check-label" for="inscrit" >
                        Sorties auxquelles je suis inscrit/e
                    </label>
                </div>

                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="noninscrit" name="noninscrit">
                        <label class="form-check-label" for="noninscrit" >
                        Sorties auxquelles je ne suis pas inscrit/e
                        </label>
                </div>

                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="passees" name="passees">
                    <label class="form-check-label" for="passees" >
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

            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Nom de la sortie</th>
                        <th>Date de la sortie</th>
                        <th class="d-none d-lg-table-cell">Clôture</th>
                        <th class="d-none d-lg-table-cell">Inscrits/Places</th>
                        <th class="d-none d-lg-table-cell">Etat</th>
                        <th class="d-none d-lg-table-cell">Inscrit</th>
                        <th class="d-none d-lg-table-cell">Organisateur</th>
                        <th class="d-none d-lg-table-cell">Action</th>
                    </tr>
                </thead>
                <#list sorties as sortie>
                <tbody>
                    <tr onclick="window.location.href = '/sortie/show/${sortie.id}/';" style="cursor: pointer;">
                        <td><#if sortie.nom??>${sortie.nom}</#if></td>
                        <td><#if sortie.date??>${sortie.date}</#if></td>
                        <td class="d-none d-lg-table-cell"><#if sortie.cloture??>${sortie.cloture}</#if></td>
                        <td class="d-none d-lg-table-cell" style="text-align: center;"><#if sortie.nb??>${sortie.nb}/${sortie.max}</#if></td>
                        <td class="d-none d-lg-table-cell"><#if sortie.etat??>${sortie.etat.libelle}</#if></td>
                        <td class="d-none d-lg-table-cell" style="text-align: center;"><#if sortie.inscrit == true><i class="fas fa-check" style="color:green;"></i><#else></#if></td>
                        <td class="d-none d-lg-table-cell"><#if sortie.participant??>${sortie.participant.nom + ' ' + sortie.participant.prenom}</#if></td>
                        <td class="d-none d-lg-table-cell">
                            <div style="display:flex;text-align: center;">
                                <div style="flex:1">
                                    <a href="/sortie/edit/${sortie.id}/"><i class="fas fa-edit"  style="color:#007bff;"></i></a>
                                </div>
                                <div style="flex:1">
                                    <a href="/sortie/delete/${sortie.id}/"><i class="fas fa-trash-alt"  style="color:red;"></i></a>
                                </div>
                            </div>

                        </td>
                    </tr>
                </tbody>
                </#list>
            </table>
            <a href="/sortie/add/" class="btn btn-primary d-none d-lg-table-cell">Ajouter</a>

    </div>
</body>
</html>