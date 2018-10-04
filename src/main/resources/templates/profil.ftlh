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

            <img style="height:200px;width:200px;margin-top:10px;" class="card-img-top rounded-circle" src="${user.photo}"
                 alt="Card image cap">
        </div>


        <div style="height:100px;">
        </div>


        <div class="card-body" style="text-align: left;">
            <h5 class="card-title" style="text-align: center;">${user.prenom + ' ' + user.nom}</h5>
            <hr>
            <form method="post">


                <div class="form-group">
                    <label for="pseudo">Pseudo :</label>
                    <input type="text" class="form-control" id="pseudo" name="pseudo" value="${user.pseudo}">
                </div>


                <div class="form-group">
                    <label for="prenom">Prénom :</label>
                    <input type="text" class="form-control" id="prenom" name="prenom" value="${user.prenom}">
                </div>


                <div class="form-group">
                    <label for="nom">Nom :</label>
                    <input type="text" class="form-control" id="nom" name="nom" value="${user.nom}">
                </div>


                <div class="form-group">
                    <label for="telephone">Télephone :</label>
                    <input type="text" pattern= "[0-9]+" class="form-control" id="telephone" name="telephone" value="${user.telephone}" maxlength="10">
                </div>


                <div class="form-group">
                    <label for="email">Email :</label>
                    <input type="email" class="form-control" id="email" name="mail" value="${user.mail}">
                </div>


                <div class="form-group">
                    <label for="password">Mot de passe :</label>
                    <input type="password" class="form-control" id="password" name="password">
                </div>


                <div class="form-group">
                    <label for="confirmation_password">Confirmation</label>
                    <input type="password" class="form-control" id="confirmation_password" name="confirmPassword">
                </div>


                <div class="form-group">
                    <label for="ville">Ville de ratachement :</label>
                    <select class="form-control" id="ville" name="ville">
                     <#list villes as ville>
                        <option value="${ville.id}" <#if ville.id== user.ville.id>selected</#if>>${ville.ville}</option>
                    </#list>
                    </select>
                </div>
        </div>


        <div class="form-group">
            <label for="photo">Ma photo :</label>
            <div class="col-lg-5">
                <input type="file" class="form-control" id="photo" name="photo">
            </div>
        </div>


        <div style="display:flex;text-align:center;">


            <div style="flex:1">
                <button type="submit" class="btn btn-primary">Annuler</button>
            </div>
            <div style="flex:1">
                <button type="submit" class="btn btn-primary">Enregistrer</button>
            </div>
        </div>
        <input type="hidden" class="form-control" id="pseudo" name="id" value="${user.id}">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>


    </div>
</center>


</body>
</html>