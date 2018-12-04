<#import "parts/common.ftl" as common>

<@common.common>
List of User

<#list users as customer>
<div class="input-group mb-3">
    <input type="text" class="form-control" readonly value="${customer.username}">
    <input type="text" class="form-control" readonly value="<#list customer.roles as role>${role}<#sep>, </#list>">
    <div class="input-group-append">
        <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Edit</button>
        <div class="dropdown-menu">
            <a class="dropdown-item" href="/user/${customer.row_id}">Edit</a>
            <a class="dropdown-item" href="/personalpage/${customer.row_id}">PP</a>
            <div role="separator" class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">Separated link</a>
        </div>
</div>
</#list>

</@common.common>