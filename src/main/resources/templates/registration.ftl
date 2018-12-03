<#import "parts/common.ftl" as common>

<@common.common>
ADD NEW USER
<div>${message?ifExists}<div>
<form action="/registration" method="post" id="2">
    <div><label> User Name : <input type="text" name="username"/></label></div>
    <div><label> Password: <input type="password" name="password"/></label></div>
    <div><label> Email: <input type="text" name="email"/></label></div>
    <div><label> FirstName: <input type="text" name="firstname"/></label></div>
    <div><label> LastName: <input type="text" name="lastname"/></label></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div><input type="submit" value="Sign Up"/></div>
</form>
</@common.common>