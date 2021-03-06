<#import "parts/common.ftl" as common>

<@common.common>
New Message
<form action="/mail" method="POST">
    <div>
        <label class="col-sm-2 col-form-label"> From : </label>
        <div class="col-auto">
            <input type="text" name="usernameFrom" readonly class="form-control" value="${userAuth.username}"/>
        </div>
    </div>

    <div>
        <label class="col-sm-2 col-form-label"> To : </label>
        <div class="col-auto">
            <input type="text" name="usernameTo"  class="form-control" <#if userTo??> value="${userTo.username}"</#if> placeholder="Send to..."/>
        </div>
    </div>

    <div>
        <label class="col-sm-2 col-form-label"> Title : </label>
        <div class="col-auto">
            <input type="text" name="Title"  class="form-control" placeholder="Title"/>
        </div>
    </div>

    <div>
        <label class="col-sm-2 col-form-label"> Message : </label>
        <div class="col-auto">
            <textarea class="form-control" name="Message" rows="5"></textarea>
        </div>
    </div>

    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div>
        <button type="submit" class="btn btn-primary mt-1 col">Send</button>
    </div>
</form>


</@common.common>