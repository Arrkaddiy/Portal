<#import "parts/common.ftl" as common>

<@common.common>
<#list mailsIn as mails>
<div class="card mt-1">
    <div class="card-body">
        <p class="card-text"><a href="/mail/new_message/${mails.getUserNameFrom()}" class="card-link">From :${mails.getUserNameFrom()}</a> ,<a href="/mail/new_message/" class="card-link"> Title : ${mails.title}</a></p>
    </div>
</div>
</#list>
</@common.common>