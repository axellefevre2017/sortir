<html>
<head>
    <#include "import.ftlh">
    <#include "script.ftlh">
    <title>${route.getName()}</title>
</head>
<body>
<#include "menu.ftlh">
<div style="height:20%; background-color: #1fc8db; background-image: linear-gradient(141deg, #9fb8ad 0%, #1fc8db 51%, #2cb5e8 75%);">

</div>

    <form method="post">


                <div class="col-lg-2">
                    <div class="form-group">
                        <label for="pseudo">Pseudo :</label>
                        <input type="text" class="form-control" id="pseudo" name="pseudo">
                    </div>
                </div>




                <div class="col-lg-2">
                    <div class="form-group">
                        <label for="prenom">Prénom :</label>
                        <input type="text" class="form-control" id="prenom" name="prenom">
                    </div>
                </div>

        <div class="col-lg-2">
            <div class="form-group">
                <label for="nom">Nom :</label>
                <input type="text" class="form-control" id="nom" name="nom">
            </div>
        </div>

        <div class="col-lg-2">
            <div class="form-group">
                <label for="telephone">Télephone :</label>
                <input type="text" class="form-control" id="telephone" name="telephone">
            </div>
        </div>

        <div class="col-lg-2">
            <div class="form-group">
                <label for="email">Email :</label>
                <input type="text" class="form-control" id="email" name="email">
            </div>
        </div>

        <div class="col-lg-2">
            <div class="form-group">
                <label for="password">Mot de passe :</label>
                <input type="password" class="form-control" id="password" name="password">
            </div>
        </div>

        <div class="col-lg-2">
            <div class="form-group">
                <label for="confirmation_password">Confirmation</label>
                <input type="password" class="form-control" id="confirmation_password" name="confirmation_password">
            </div>
        </div>


        <div style="flex:1">
            <div class="col-lg-2">
                <div class="form-group">
                    <label for="ville">Ville de ratachement :</label>
                    <select class="form-control" id="ville" name="ville">

                    </select>
                </div>
            </div>
        </div>

        <div class="col-lg-2">
            <div class="form-group">
                <label for="photo">Ma photo</label>
                <input type="file" class="form-control" id="photo" name="photo">
            </div>
        </div>



         <button type="submit" class="btn btn-primary">Enregistrer</button>

        <button type="submit" class="btn btn-primary">Annuler</button>

    </form>
</div>
</body>
</html>