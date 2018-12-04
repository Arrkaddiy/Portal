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
        <label class="col-sm-2 col-form-label"> Firstname : </label>
        <div class="col-sm-4">
            <input type="text" name="firstname" class="form-control" placeholder="Firstname"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> LastName : </label>
        <div class="col-sm-4">
            <input type="text" name="lastname" class="form-control" placeholder="LastName"/>
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit" class="btn btn-primary">Sign Up</button>
</form>
</@common.common>