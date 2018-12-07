<#import "parts/common.ftl" as common>

<@common.common>

<h5>My Invoice In Progress</h5>

<div class="accordion" id="InvoicesInProgress">
    <#list invoicesinprogress as invoices>
    <div class="card">

        <div class="card-header" id="heading${invoices.row_id}">
            <h5 class="mb-0">
                <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapse${invoices.row_id}" aria-expanded="false" aria-controls="collapse${invoices.row_id}">
                    ${invoices.row_id}
                </button>
            </h5>
        </div>

        <div id="collapse${invoices.row_id}" class="collapse show" aria-labelledby="heading${invoices.row_id}" data-parent="#InvoicesInProgress">
            <div class="card-body border-bottom">
                <p class="card-text"> Anim/ ${invoices.row_id}</p>
            </div>
        </div>

    </div>
    </#list>
</div>


</@common.common>