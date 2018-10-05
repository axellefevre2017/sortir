<html>
<head>
    <#include "../import.ftlh">
    <#include "../script.ftlh">
    <title>${route.getName()}</title>
</head>
<body>
<#include "../menu.ftlh">
<center>
    <div class="card" style="width: 35rem;margin-bottom: 50px;margin-top:25px;padding-bottom: 10px;">
        <div class="card-body" style="text-align: left;">
            <form method="post">


                <div class="form-group">
                    <label for="pseudo">Pseudo :</label>
                    <input type="text" class="form-control" id="pseudo" name="pseudo" >
                </div>


                <div class="form-group">
                    <label for="prenom">Prénom :</label>
                    <input type="text" class="form-control" id="prenom" name="prenom" >
                </div>


                <div class="form-group">
                    <label for="nom">Nom :</label>
                    <input type="text" class="form-control" id="nom" name="nom" >
                </div>


                <div class="form-group">
                    <label for="telephone">Télephone :</label>
                    <input type="text" pattern= "[0-9]+" class="form-control" id="telephone" name="telephone" maxlength="10">
                </div>


                <div class="form-group">
                    <label for="email">Email :</label>
                    <input type="email" class="form-control" id="email" name="mail" >
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
                        <option value="${ville.id}">${ville.ville}</option>
                    </#list>
                    </select>
                </div>

                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="admin" name="admin" >
                    <label class="form-check-label" for="admin" >
                        Administrateur
                    </label>
                </div>

                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="actif" name="actif" >
                    <label class="form-check-label" for="actif" >
                        Actif
                    </label>
                </div>
        </div>


        <div style="display:flex;text-align:center;">

            <div style="flex:1">
                <button type="submit" class="btn btn-primary">Ajouter</button>
            </div>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>


    </div>
</center>


</body>
</html>