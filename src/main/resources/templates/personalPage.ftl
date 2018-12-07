<#import "parts/common.ftl" as common>

<@common.common>
Pesonal Page

<div>
    Avatar
</div>
<div>
    <#if customer.avatarname??>
    <img src="/img/${customer.avatarname}" />
</#if>
</div>
<div>
    Data
</div>
<div class="form-group row">
    <label class="col-sm-2 col-form-label"> Login : </label>
    <div class="col-sm-4">
        <input type="text" name="UserName" readonly class="form-control" value="${customer.username}"/>
    </div>
</div>
<div class="form-group row">
    <label class="col-sm-2 col-form-label"> Email : </label>
    <div class="col-sm-4">
        <input type="email" name="email" readonly class="form-control" value="${customer.email}"/>
    </div>
</div>
<div class="form-group row">
    <label class="col-sm-2 col-form-label"> Firstname : </label>
    <div class="col-sm-4">
        <input type="text" name="firstname" readonly class="form-control" value="${customer.firstname}"/>
    </div>
</div>
<div class="form-group row">
    <label class="col-sm-2 col-form-label"> LastName : </label>
    <div class="col-sm-4">
        <input type="text" name="lastname" readonly class="form-control" value="${customer.lastname}"/>
    </div>
</div>
<div class="form-group row">
    <label class="col-sm-2 col-form-label"> Phone : </label>
    <div class="col-sm-4">
        <input type="text" name="phone" readonly class="form-control" value="${customer.phone?ifExists}"/>
    </div>
</div>
<div class="form-group row">
    <label class="col-sm-2 col-form-label"> Country : </label>
    <div class="col-sm-4">
        <input type="text" name="country" readonly class="form-control" value="${customer.country?ifExists}"/>
    </div>
</div>
<div class="form-group row">
    <label class="col-sm-2 col-form-label"> Sity : </label>
    <div class="col-sm-4">
        <input type="text" name="sity" readonly class="form-control" value="${customer.sity?ifExists}"/>
    </div>
</div>
<div class="form-group row">
    <label class="col-sm-2 col-form-label"> Address : </label>
    <div class="col-sm-4">
        <input type="text" name="address" readonly class="form-control" value="${customer.address?ifExists}"/>
    </div>
</div>
<div class="form-group row">
    <label class="col-sm-2 col-form-label"> Score : </label>
    <div class="col-sm-4">
        <input type="text" name="score" readonly class="form-control" value="${customer.score?ifExists}"/>
    </div>
</div>

<div>
    <a href="/main">Return</a>
</div>

<div>
    <form method="POST" enctype="multipart/form-data">
        <div class="custom-file">
            <input type="file" class="custom-file-input" id="customFile" name="file">
            <label class="custom-file-label" for="customFile">Choose file</label>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button class="btn btn-secondary mt-1" type="submit">Send</button>
        </div>
    </form>
</div>
</@common.common>