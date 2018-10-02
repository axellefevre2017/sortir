<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">SORTIR.COM</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item <#if route.getMenu()=='accueil'>active</#if>">
                <a class="nav-link" href="/">ACCUEIL <#if route.getMenu()=='accueil'><span class="sr-only">(current)</span></#if></a>
            </li>
            <li class="nav-item <#if route.getMenu()=='ville'>active</#if>">
                <a class="nav-link" href="/ville/">VILLES <#if route.getMenu()=='ville'><span class="sr-only">(current)</span></#if></a>
            </li>
            <li class="nav-item <#if route.getMenu()=='site'>active</#if>">
                <a class="nav-link" href="/site/">SITES <#if route.getMenu()=='site'><span class="sr-only">(current)</span></#if></a>
            </li>
            <li class="nav-item <#if route.getMenu()=='profil'>active</#if>">
                <a class="nav-link" href="/profil/">MON PROFIL <#if route.getMenu()=='profil'><span class="sr-only">(current)</span></#if></a>
            </li>
        </ul>
        <a href="/login" class="btn btn-outline-success my-2 my-sm-0" style="margin-right:15px;" type="submit">CONNEXION</a>
        <a href="/logout" class="btn btn-outline-success my-2 my-sm-0" type="submit">DECONNEXION</a>
    </div>
</nav>