<#include "security.ftl">
<#import "login.ftl" as login>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Portal</a>
    <div class="collapse navbar-collapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item mr-1">
                <a class="btn btn-primary" href="/main" role="button">MainPage</a>
            </li>
            <#if isAdmin>
            <li class="nav-item mr-1">
                <a class="btn btn-primary" href="/user" role="button">User List</a>
            </li>
            </#if>
            <#if user??>
            <li class="nav-item mr-1">
                <div class="btn-group" role="group">
                    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                        My Mail
                        <#if invoicessize != 0>
                        <span class="badge badge-light">${invoicessize}new</span>
                    </#if>
                    </button>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="/mail/input">
                            Inbox
                            <#if invoicessize != 0>
                            <span class="badge badge-primary">${invoicessize}new</span>
                            <span class="sr-only">Active invoice</span>
                        </#if>
                        </a>
                        <a class="dropdown-item" href="/mail/output">Sent</a>
                    </div>
                </div>
            </li>
            <li class="nav-item mr-1">
                <div class="btn-group" role="group">
                    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                        My invoice
                        <#if invoicessize != 0>
                        <span class="badge badge-light">${invoicessize}</span>
                        <span class="sr-only">Active invoice</span>
                        </#if>
                    </button>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="/invoices/inprogress">In Progress
                            <#if invoicessize != 0>
                            <span class="badge badge-primary">${invoicessize}</span>
                            <span class="sr-only">Active invoice</span>
                            </#if>
                        </a>
                        <a class="dropdown-item" href="#">Done</a>
                    </div>
                </div>
            </li>
            </#if>
        </ul>
        <div class="navbar-text mr-3">Hello, ${name}!</div>
        <#if user??>
            <div> <a class="btn btn-primary mr-1" href="/personalpage" role="button">Personal Page</a></div>
            <@login.logoutB />
        <#else>
            <@login.loginB />
        </#if>
    </div>
</nav>