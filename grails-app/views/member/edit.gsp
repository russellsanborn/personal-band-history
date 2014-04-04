<html>
<head>
  <meta name="layout" content="main"/>
  <title>Edit ${member?.name}</title>
</head>

<body>
  <div>
    <g:form url="[resource:memberInstance, action:'update']" method="PUT"  enctype="multipart/form-data">
        <g:hiddenField name="version" value="${memberInstance?.version}" />
        <fieldset class="form">
            <g:render template="form"/>
	</fieldset>
	<fieldset class="buttons">
            <g:actionSubmit class="save btn btn-success" action="update" value="Update" />
	</fieldset>
    </g:form>
</body>
</html>