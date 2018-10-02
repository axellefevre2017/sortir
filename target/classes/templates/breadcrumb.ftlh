<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <#if route.getParent()??>
        <li class="breadcrumb-item"><a href="${route.getParent().getUrl()}">${route.getParent().getName()}</a></li>
        </#if>
        <li class="breadcrumb-item active" aria-current="page">${route.getName()}</li>
    </ol>
</nav>