<html>
<head th:include="layout :: head(title=~{::title},links=~{})">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- Bootstrap core CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.5.11/css/mdb.min.css" rel="stylesheet">
</head>
<body>
<div style="display:flex;margin-top:10%;">
    <div style="flex: 3"></div>
    <div style="flex: 2">
        <form class="text-center border border-light p-5" method="post" action="/login">

            <p class="h4 mb-4">Connexion</p>
            <#if RequestParameters.error??>
            <div class="alert alert-danger" role="alert">
                Identifiants incorrects.
            </div>
            </#if>

            <!-- Email -->
            <input type="text" name="username" id="defaultLoginFormEmail" class="form-control mb-4"
                   placeholder="Identifiant">

            <!-- Password -->
            <input type="password" name="password" id="defaultLoginFormPassword" class="form-control mb-4"
                   placeholder="Mot de Passe">

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <div class="d-flex justify-content-around">
                <div>
                    <!-- Remember me -->
                    <div class="custom-control custom-checkbox">
                        <input type="checkbox" class="custom-control-input" id="defaultLoginFormRemember">
                        <label class="custom-control-label" for="defaultLoginFormRemember">Se souvenir moi</label>
                    </div>
                </div>
            </div>

            <!-- Sign in button -->
            <button class="btn btn-info btn-block my-4" type="submit">Se connecter</button>

        </form>
    </div>
    <div style="flex: 3"></div>
</div>
</body>
</html>