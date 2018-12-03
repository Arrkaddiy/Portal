<#import "parts/common.ftl" as common>

<@common.common>
List of User

<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Role</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <#list users as customer>
            <tr>
                <td>${customer.username}</td>
                <td><#list customer.roles as role>${role}<#sep>, </#list></td>
                <td><a href="/user/${customer.row_id}">Edit</a> </td>
            </tr>

        </#list>
    </tbody>
</table>
<div>
    <a href="/main">Return</a>
</div>
</@common.common>