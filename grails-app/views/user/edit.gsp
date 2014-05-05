<%@ page import="personalbandhistory.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="edit-user" class="content scaffold-edit" role="main">
			<h1><g:message code="default.edit.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${userInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${userInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form method="post" >
				<g:hiddenField name="id" value="${userInstance?.id}" />
				<g:hiddenField name="version" value="${userInstance?.version}" />
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:actionSubmit class="save btn btn-success" action="update" value="Update" />
                                        <sec:ifAnyGranted roles="ROLE_ADMIN">
                                          <g:actionSubmit class="btn btn-danger delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" formnovalidate="" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                                          </br>
                                          <g:link class="btn btn-primary" controller="user" action="addUserRole" id="${userInstance?.id}">Add User Role</g:link>
                                          <g:link class="btn btn-primary" controller="user" action="removeUserRole" id="${userInstance?.id}">Remove User Role</g:link>
                                          <g:link class="btn btn-primary" controller="user" action="addAdminRole" id="${userInstance?.id}">Add Admin Role</g:link>
                                          <g:link class="btn btn-primary" controller="user" action="removeAdminRole" id="${userInstance?.id}">Remove Admin Role</g:link>
                                        </sec:ifAnyGranted>
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
