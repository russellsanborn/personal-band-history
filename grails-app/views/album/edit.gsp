<html>
<head>
  <meta name="layout" content="main"/>
  <title>Edit ${album?.name}</title>
</head>

<body>
  <div>
    <g:form url="[resource:albumInstance, action:'update']" method="PUT"  enctype="multipart/form-data">
        <g:hiddenField name="version" value="${albumInstance?.version}" />
        <fieldset class="form">
            <g:render template="form"/>
	</fieldset>
	<fieldset class="buttons">
            <g:actionSubmit class="save btn btn-success" action="update" value="Update" />
	</fieldset>
    </g:form>
</body>
</html>