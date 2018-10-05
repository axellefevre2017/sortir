<html>
<head>
    <#include "import.ftlh">
    <#include "script.ftlh">
    <title>${route.getName()}</title>
</head>
<body>
<#include "menu.ftlh">
<center>
    <div class="card" style="width: 35rem;margin-bottom: 50px;margin-top:25px;padding-bottom: 10px;">
        <div style="height:120px;background-color: #1fc8db;background-image: linear-gradient(141deg, #9fb8ad 0%, #1fc8db 51%, #2cb5e8 75%);">

            <img style="height:200px;width:200px;margin-top:10px;" class="card-img-top rounded-circle" src="<#if profil.photo??>${profil.photo}<#else>https://i1.wp.com/www.winhelponline.com/blog/wp-content/uploads/2017/12/user.png</#if>"
                 alt="Card image cap">
        </div>


        <div style="height:100px;">
        </div>


        <div class="card-body" style="text-align: left;">
            <h5 class="card-title" style="text-align: center;">${profil.prenom + ' ' + profil.nom}</h5>
            <hr>
            <form method="post">


                <div class="form-group">
                    <label for="pseudo">Pseudo :</label>
                    <input type="text" class="form-control" id="pseudo" name="pseudo" value="${profil.pseudo}" disabled>
                </div>


                <div class="form-group">
                    <label for="prenom">Prénom :</label>
                    <input type="text" class="form-control" id="prenom" name="prenom" value="${profil.prenom}" disabled>
                </div>


                <div class="form-group">
                    <label for="nom">Nom :</label>
                    <input type="text" class="form-control" id="nom" name="nom" value="${profil.nom}" disabled>
                </div>


                <div class="form-group">
                    <label for="telephone">Télephone :</label>
                    <input type="text" pattern= "[0-9]+" class="form-control" id="telephone" name="telephone" value="${profil.telephone}" maxlength="10" disabled>
                </div>


                <div class="form-group">
                    <label for="email">Email :</label>
                    <input type="email" class="form-control" id="email" name="mail" value="${profil.mail}" disabled>
                </div>

                <div class="form-group">
                    <label for="ville">Ville de ratachement :</label>
                    <select class="form-control" id="ville" name="ville" disabled>
                     <#list villes as ville>
                        <option value="${ville.id}" <#if ville.id== profil.ville.id>selected</#if>>${ville.ville}</option>
                    </#list>
                    </select>
                </div>
        </div>
        </form>


    </div>
</center>


</body>
</html>