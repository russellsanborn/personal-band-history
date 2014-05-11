<%@ page import="org.joda.time.LocalDate" contentType="text/html;charset=UTF-8" %>

<html>
<head>
  <meta name="layout" content="main"/>
  <title>Edit ${concert?.title}</title>
</head>

<body>
  <div>
    <g:form url="[resource:concertInstance, action:'update']" method="PUT"  enctype="multipart/form-data">
        <g:hiddenField name="version" value="${concertInstance?.version}" />
        <fieldset class="form">
            <g:render template="form"/>
	</fieldset>
	<fieldset class="buttons">
            <g:actionSubmit class="save btn btn-success" action="update" value="Update" />
	</fieldset>
    </g:form>
</body>
</html>