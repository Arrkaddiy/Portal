<#import "parts/common.ftl" as common>

<@common.common>
List of User
<form action="/user" method="GET">
    <div class="form-inline my-2">
        <select class="custom-select mr-sm-2" name="searchfiltr">
            <option selected>Search for</option>
            <option value="User name">User Name</option>
        </select>
        <input class="form-control mr-sm-2 col-5" type="search" placeholder="Search" name="search" value="${search?ifExists}">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </div>
</form>

<#list customers as customer>
<div class="input-group mt-2">
    <div class="input-group-prepend">
        <span class="input-group-text col" >User Name :</span>
    </div>
    <input type="text" class="form-control col" readonly value="${customer.username}">

    <div class="input-group-prepend">
        <span class="input-group-text">Roles :</span>
    </div>
    <input type="text" class="form-control col" readonly value="<#list customer.roles as role>${role}<#sep>, </#list>">

    <div class="input-group-prepend">
        <span class="input-group-text">Email :</span>
    </div>
    <input type="text" class="form-control col" readonly value="${customer.email}">

    <div class="input-group-prepend">
        <span class="input-group-text">Active :</span>
    </div>
    <input type="text" class="form-control col" readonly value="<#if customer.active> Active <#else> Terminate </#if>">

    <div class="input-group-append">
        <button class="btn btn-outline-primary dropdown-toggle" type="button" data-toggle="dropdown" >Edit</button>
        <div class="dropdown-menu">
            <a class="dropdown-item" href="/user/${customer.row_id}">Edit</a>
            <a class="dropdown-item" href="/personalpage/${customer.row_id}">PP</a>
            <div role="separator" class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">Delete</a>
        </div>
    </div>
</div>
<#else>
No User
</#list>

</@common.common>