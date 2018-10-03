<html>
<head>
    <#include "import.ftlh">
</head>
<body>
<form class="form-horizontal" name="f" method="post" action="login">
    <div class="form-group">
        <label class="control-label col-sm-2" for="username">PSEUDO :</label>
        <div class="col-lg-3">
            <input type="text" class="form-control" name="username" id="username" placeholder="Pseudo">
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="password">MOT DE PASSE :</label>
        <div class="col-lg-3">
            <input type="password" class="form-control" name="password" id="password" placeholder="Mot de passe">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">SE CONNECTER</button>
        </div>
    </div>
</form>


<#include "script.ftlh">
</body>
</html>