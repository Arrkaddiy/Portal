<#import "parts/common.ftl" as common>

<@common.common>
<div>
    <form method="POST" id="add">
        <input type="text" name="date" placeholder="Дата" size="20" />
        <input type="text" name="point" placeholder="Место" size="20" />
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Добавить</button>
    </form>
</div>
<div>
    Список Invoices
</div>
<div>
    <form method="GET" action="/main" id="filtr">
        <input type="text" name="filter" placeholder="${filter?ifExists}">
        <button type="submit">Фильтр</button>
    </form>
</div>

<#list invoices as invoice>
    <div>
        <b>${invoice.row_id}</b>
        <b>${invoice.invoice_date}</b>
        <b>${invoice.billing_address}</b>
        <b>${invoice.userName}</b>
    </div>
<#else>
No invoices
</#list>
</@common.common>