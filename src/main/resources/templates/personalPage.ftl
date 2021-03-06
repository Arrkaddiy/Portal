<#import "parts/common.ftl" as common>

<@common.common>
Pesonal Page
<div>
    Avatar
</div>
<div>
    <#if user.avatarName??>
    <img src="/img/${user.avatarName}" />
</#if>
</div>
<div>
    Data
</div>
<div class="form-group row">
    <label class="col-sm-2 col-form-label"> Login : </label>
    <div class="col-sm-4">
        <input type="text" name="userName" readonly class="form-control" value="${user.username}"/>
    </div>
</div>
<div class="form-group row">
    <label class="col-sm-2 col-form-label"> Email : </label>
    <div class="col-sm-4">
        <input type="email" name="email" readonly class="form-control" value="${user.email}"/>
    </div>
</div>
<div class="form-group row">
    <label class="col-sm-2 col-form-label"> Firstname : </label>
    <div class="col-sm-4">
        <input type="text" name="firstName" readonly class="form-control" value="${user.firstName}"/>
    </div>
</div>
<div class="form-group row">
    <label class="col-sm-2 col-form-label"> LastName : </label>
    <div class="col-sm-4">
        <input type="text" name="lastName" readonly class="form-control" value="${user.lastName}"/>
    </div>
</div>
<div class="form-group row">
    <label class="col-sm-2 col-form-label"> Phone : </label>
    <div class="col-sm-4">
        <input type="text" name="phone" readonly class="form-control" value="${user.phone?ifExists}"/>
    </div>
</div>
<div class="form-group row">
    <label class="col-sm-2 col-form-label"> Country : </label>
    <div class="col-sm-4">
        <input type="text" name="country" readonly class="form-control" value="${user.country?ifExists}"/>
    </div>
</div>
<div class="form-group row">
    <label class="col-sm-2 col-form-label"> Sity : </label>
    <div class="col-sm-4">
        <input type="text" name="city" readonly class="form-control" value="${user.city?ifExists}"/>
    </div>
</div>
<div class="form-group row">
    <label class="col-sm-2 col-form-label"> Address : </label>
    <div class="col-sm-4">
        <input type="text" name="address" readonly class="form-control" value="${user.address?ifExists}"/>
    </div>
</div>
<div class="form-group row">
    <label class="col-sm-2 col-form-label"> Score : </label>
    <div class="col-sm-4">
        <input type="number" name="score" readonly class="form-control" value="${user.score?ifExists}"/>
    </div>
    <div>
        <button type="button" class="btn btn-primary col" data-toggle="modal" data-target="#replenishModal">
            Replenish
        </button>
        <!-- Modal -->
        <form action="personalPage/getPurse" method="GET">
        <div class="modal fade" id="replenishModal" tabindex="-1" role="dialog" aria-labelledby="replenishModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="replenishModalLabel">Modal title</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label"> Purse : </label>
                            <div class="col-sm-4">
                                <input type="number" name="purse" class="form-control" step="0.01"/>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Save changes</button>
                    </div>
                </div>
            </div>
        </div>
        </form>
    </div>
</div>
<div class="form-group row">
    <label class="col-sm-2 col-form-label"> Support : </label>
    <div class="col-sm-4">
        <input type="text" name="support" readonly class="form-control" value="${user.getSupportUserName()?ifExists}"/>
    </div>
    <div>
        <a class="btn btn-primary" href="/mail/new_message/${user.getSupportUserName()}" role="button">Write</a>
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