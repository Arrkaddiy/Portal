<#macro login path>
<form action="${path}" method="post" id="login">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Login : </label>
        <div class="col-sm-6">
            <input type="text" name="username" class="form-control" placeholder="User Name..."/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Password : </label>
        <div class="col-sm-6">
            <input type="password" name="password" class="form-control" placeholder="Password..."/>
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit" class="btn btn-primary">Sign In</button>
</form>
</#macro>

<#macro logout>
<div>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary">Sign Out</button>
    </form>
</div>
</#macro>