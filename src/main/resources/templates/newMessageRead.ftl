<#import "parts/common.ftl" as common>

<@common.common>
<form>
    <div>
        <label class="col-sm-2 col-form-label"> From : </label>
        <div class="col-auto">
            <input type="text" name="usernameFrom" readonly class="form-control" value="${mail.userFrom.username}"/>
        </div>
    </div>

    <div>
        <label class="col-sm-2 col-form-label"> To : </label>
        <div class="col-auto">
            <input type="text" name="usernameTo" readonly class="form-control"  value="${mail.userTo.username}"/>
    </div>
    </div>

    <div>
        <label class="col-sm-2 col-form-label"> Title : </label>
        <div class="col-auto">
            <input type="text" name="Title" readonly class="form-control" placeholder="Title" value="${mail.getTitle()}"/>
        </div>
    </div>

    <div>
        <label class="col-sm-2 col-form-label"> Message : </label>
        <div class="col-auto">
            <textarea class="form-control" readonly name="Message" rows="5">${mail.getBody()}</textarea>
        </div>
    </div>

    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div>
        <a href="/mail/new_message/${mail.getUserNameFrom()}" class="btn btn-primary mt-1 col" role="button" aria-pressed="true">Answer</a>
    </div>
</form>


</@common.common>