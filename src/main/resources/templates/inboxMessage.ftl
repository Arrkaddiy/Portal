<#import "parts/common.ftl" as common>

<@common.common>
<#list mailsIn as mail>
<div class="card mt-1">
    <div class="card-body">
        <p class="card-text"><a href="/mail/new_message/${mail.getUserNameFrom()}" class="card-link">From :${mail.getUserNameFrom()}</a> ,<a href="/mail/new_message/read/${mail.row_id}" class="card-link"> Title : ${mail.title}</a>
            <#if !mail.read>
                <span class="badge badge-primary">new</span>
                <span class="sr-only">Active invoice</span>
            </#if>
        </p>
    </div>
</div>
</#list>
</@common.common>