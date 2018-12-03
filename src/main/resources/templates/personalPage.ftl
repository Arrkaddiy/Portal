<#import "parts/common.ftl" as common>

<@common.common>
Pesonal Page
<table>

    <thead>

    <tr>
        <th>
            Avatar
            <div>
                <#if customer.avatarname??>
                    <img src="/img/${customer.avatarname}" />
                </#if>
            </div>
        </th>
    </tr>

    </thead>
    <tbody>
        <tr>
            <td>UserName</td>
            <td><input type="text" value="${customer.username}" /></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="text" value="${customer.password}" /></td>
        </tr>
        <tr>
            <td>Firstname</td>
            <td><input type="text" value="${customer.firstname?ifExists}" /></td>
        </tr>
        <tr>
            <td>Lastname</td>
            <td><input type="text" value="${customer.lastname?ifExists}" /></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" value="${customer.email}" /></td>
        </tr>
        <tr>
            <td>Roles</td>
            <td><#list customer.roles as role>${role}<#sep>, </#list></td>
        </tr>
    </tbody>

</table>
<div>
    <form method="POST" enctype="multipart/form-data">
        <input type="file" name="file" />
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Отправить</button>
    </form>
</div>
<div>
    <a href="/main">Return</a>
</div>
</@common.common>