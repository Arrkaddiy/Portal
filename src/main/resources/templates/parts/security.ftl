<#assign
    know = Session.SPRING_SECURITY_CONTEXT??
>

<#if know>
    <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = user.getUsername()
        isAdmin = user.isAdmin()
        row_id = user.getRow_id()
    >
<#else>
    <#assign
        name = "Guest"
        isAdmin = false
    >
</#if>

