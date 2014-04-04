<html>
<head>
  <meta name="layout" content="main"/>
  <title>Edit ${band?.name}</title>
</head>

<body>
  <div>
    <g:form url="[resource:bandInstance, action:'update']" method="PUT"  enctype="multipart/form-data">
        <g:hiddenField name="version" value="${bandInstance?.version}" />
        <fieldset class="form">
            <g:render template="form"/>
	</fieldset>
	<fieldset class="buttons">
            <g:actionSubmit class="save btn btn-success" action="update" value="Update" />
	</fieldset>
    </g:form>
</body>
</html>