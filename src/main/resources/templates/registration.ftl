<#import "parts/common.ftl" as common>

<@common.common>
ADD NEW USER
<div>${message?ifExists}<div>
<form action="/registration" method="post" id="2">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Login : </label>
        <div class="col-sm-4">
            <input type="text" name="username" class="form-control" placeholder="Login"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Password : </label>
        <div class="col-sm-4">
            <input type="password" name="password" class="form-control" placeholder="Password"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Email : </label>
        <div class="col-sm-4">
            <input type="email" name="email" class="form-control" placeholder="Email"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> FirstName : </label>
        <div class="col-sm-4">
            <input type="text" name="firstName" class="form-control" placeholder="FirstName"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> LastName : </label>
        <div class="col-sm-4">
            <input type="text" name="lastName" class="form-control" placeholder="LastName"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Phone : </label>
        <div class="col-sm-4">
            <input type="text" name="phone" class="form-control" placeholder="Phone"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Country : </label>
        <div class="col-sm-4">
            <input type="text" name="country" class="form-control" placeholder="Country"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> City : </label>
        <div class="col-sm-4">
            <input type="text" name="city" class="form-control" placeholder="City"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Address : </label>
        <div class="col-sm-4">
            <input type="text" name="address" class="form-control" placeholder="Address"/>
        </div>
    </div>

    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit" class="btn btn-primary">Sign Up</button>
</form>
</@common.common>