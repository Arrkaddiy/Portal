<#import "parts/common.ftl" as common>

<@common.common>
User Editor
<form action="/user" method="POST">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Login : </label>
        <div class="col-sm-4">
            <input type="text" name="username" class="form-control" value="${user.username}"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Password : </label>
        <div class="col-sm-4">
            <input type="password" name="password" class="form-control" value="${user.password}"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Email : </label>
        <div class="col-sm-4">
            <input type="email" name="email" class="form-control" value="${user.email}"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Firstname : </label>
        <div class="col-sm-4">
            <input type="text" name="firstName" class="form-control" value="${user.firstName}"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> LastName : </label>
        <div class="col-sm-4">
            <input type="text" name="lastName" class="form-control" value="${user.lastName}"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Phone : </label>
        <div class="col-sm-4">
            <input type="text" name="phone" class="form-control" value="${user.phone?ifExists}"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Country : </label>
        <div class="col-sm-4">
            <input type="text" name="country" class="form-control" value="${user.country?ifExists}"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> City : </label>
        <div class="col-sm-4">
            <input type="text" name="city" class="form-control" value="${user.city?ifExists}"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Address : </label>
        <div class="col-sm-4">
            <input type="text" name="address" class="form-control" value="${user.address?ifExists}"/>
        </div>
    </div>

    <div class="btn-group btn-group-toggle" data-toggle="buttons">
        <#list roles as role>
        <label class="btn btn-secondary <#list user.roles as userRole> <#if role == userRole> active </#if> </#list>">
            <input type="radio" name="${role}" autocomplete="off" <#list user.roles as userRole> <#if role == userRole> cheeked </#if> </#list>> ${role}
        </label>
        </#list>
    </div>



    <input type="hidden" value="${user.row_id}" name="userRowId">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div>
        <button type="submit" class="btn btn-primary mt-1">Save</button>
    </div>

</form>

</@common.common>