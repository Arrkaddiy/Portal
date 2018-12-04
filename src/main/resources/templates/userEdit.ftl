<#import "parts/common.ftl" as common>

<@common.common>
User Editor
<form action="/user" method="POST">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Login : </label>
        <div class="col-sm-4">
            <input type="text" name="customerUserName" class="form-control" value="${customer.username}"/>
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
            <input type="text" name="phone" class="form-control" value="${customer.phone}"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Country : </label>
        <div class="col-sm-4">
            <input type="text" name="country" class="form-control" value="${customer.country}"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Sity : </label>
        <div class="col-sm-4">
            <input type="text" name="sity" class="form-control" value="${customer.sity}"/>
        </div>
    </div>

    <#list roles as role>
    <div>
        <label><input type="checkbox" name="${role}" ${customer.roles?seq_contains(role)?string("cheked","")}>${role} </label>
    </div>
    </#list>


    <input type="hidden" value="${customer.row_id}" name="customerRowId">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit" class="btn btn-primary mt-1">Save</button>
</form>

</@common.common>