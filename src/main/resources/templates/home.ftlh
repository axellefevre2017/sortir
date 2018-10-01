<html>
<head>
    <#include "import.ftlh">
    <title>${route.getName()}</title>
</head>
<body>
<#include "menu.ftlh">

<#list participants as participant>
    ${participant.nom}
</#list>


<#include "script.ftlh">
</body>
</html>