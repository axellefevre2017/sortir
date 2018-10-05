<html>
<head>
    <#include "../import.ftlh">
    <#include "../script.ftlh">
    <title>${route.getName()}</title>
</head>
<body>
<#include "../menu.ftlh">

<#if user.administrateur == true>
    <div class="col-lg-12" style="margin-top:30px;">

            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Pseudo</th>
                        <th>Nom</th>
                        <th class="d-none d-lg-table-cell">Prénom</th>
                        <th class="d-none d-lg-table-cell">Téléphone</th>
                        <th class="d-none d-lg-table-cell">Mail</th>
                        <th class="d-none d-lg-table-cell">Administrateur</th>
                        <th class="d-none d-lg-table-cell">Actif</th>
                        <th class="d-none d-lg-table-cell">Action</th>
                    </tr>
                </thead>
                <#list participants as p>
                <tbody>
                    <tr onclick="window.location.href = '/participant/${p.id}/';" style="cursor: pointer;">
                        <td><#if p.pseudo??>${p.pseudo}</#if></td>
                        <td><#if p.nom??>${p.nom}</#if></td>
                        <td class="d-none d-lg-table-cell"><#if p.prenom??>${p.prenom}</#if></td>
                        <td class="d-none d-lg-table-cell"><#if p.telephone??>${p.telephone}</#if></td>
                        <td class="d-none d-lg-table-cell"><#if p.mail??>${p.mail}</#if></td>
                        <td class="d-none d-lg-table-cell" style="text-align: center;"><#if p.administrateur == true><i class="fas fa-check" style="color:green;"></i><#else></#if></td>
                        <td class="d-none d-lg-table-cell" style="text-align: center;"><#if p.actif == true><i class="fas fa-check" style="color:green;"></i><#else></#if></td>
                        <td class="d-none d-lg-table-cell">
                            <div style="display:flex;text-align: center;">
                                <div style="flex:1">
                                    <a href="/participant/edit/${p.id}/"><i class="fas fa-edit"  style="color:#007bff;"></i></a>
                                </div>
                                <div style="flex:1">
                                    <a href="/participant/delete/${p.id}/"><i class="fas fa-trash-alt"  style="color:red;"></i></a>
                                </div>
                            </div>

                        </td>
                    </tr>
                </tbody>
                </#list>
            </table>
            <a href="/participant/add/" class="btn btn-primary d-none d-lg-table-cell">Ajouter</a>

    </div>
<#else>
<p style="margin-left:50px;margin-top:10px;color:red;font-size: 17px">Vous n'êtes pas autorisé à accéder à cette page</p>
</#if>
</body>
</html>