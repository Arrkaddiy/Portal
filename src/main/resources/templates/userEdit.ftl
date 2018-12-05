<#import "parts/common.ftl" as common>

<@common.common>
User Editor
<form action="/user" method="POST">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Login : </label>
        <div class="col-sm-4">
            <input type="text" name="UserName" class="form-control" value="${customer.username}"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Password : </label>
        <div class="col-sm-4">
            <input type="password" name="password" class="form-control" value="${customer.password}"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Email : </label>
        <div class="col-sm-4">
            <input type="email" name="email" class="form-control" value="${customer.email}"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Firstname : </label>
        <div class="col-sm-4">
            <input type="text" name="firstname" class="form-control" value="${customer.firstname}"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> LastName : </label>
        <div class="col-sm-4">
            <input type="text" name="lastname" class="form-control" value="${customer.lastname}"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Phone : </label>
        <div class="col-sm-4">
            <input type="text" name="phone" class="form-control" value="${customer.phone?ifExists}"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Country : </label>
        <div class="col-sm-4">
            <input type="text" name="country" class="form-control" value="${customer.country?ifExists}"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Sity : </label>
        <div class="col-sm-4">
            <input type="text" name="sity" class="form-control" value="${customer.sity?ifExists}"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Address : </label>
        <div class="col-sm-4">
            <input type="text" name="address" class="form-control" value="${customer.address?ifExists}"/>
        </div>
    </div>

    <div class="btn-group btn-group-toggle" data-toggle="buttons">
        <#list roles as role>
        <label class="btn btn-secondary <#list customer.roles as custmrole> <#if role == custmrole> active </#if> </#list>">
            <input type="radio" name="${role}" autocomplete="off" <#list customer.roles as custmrole> <#if role == custmrole> cheeked </#if> </#list>> ${role}
        </label>
        </#list>
    </div>



    <input type="hidden" value="${customer.row_id}" name="customerRowId">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div>
        <button type="submit" class="btn btn-primary mt-1">Save</button>
    </div>

</form>

</@common.common>