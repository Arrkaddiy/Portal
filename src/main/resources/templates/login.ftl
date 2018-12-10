<#import "parts/common.ftl" as common>
<#import "parts/login.ftl" as login>

<@common.common>
LOGIN CUSTOMER
<@login.login "/login" />
<a href="/registration">Add new user</a>
</@common.common>