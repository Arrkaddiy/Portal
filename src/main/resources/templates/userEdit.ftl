<#import "parts/common.ftl" as common>

<@common.common>
User Editor

<form action="/user" method="POST">
    <input type="text" value="${customer.username}" name="customerUserName">
    <#list roles as role>
    <div>
        <label><input type="checkbox" name="${role}" ${customer.roles?seq_contains(role)?string("cheked", "")}>${role}</label>
    </div>
    </#list>
    <input type="hidden" value="${customer.row_id}" name="customerRowId">
    <input type="hidden" value="${_csrf.token}" name="_csrf">
    <button type="submit">Save</button>
</form>

</@common.common>