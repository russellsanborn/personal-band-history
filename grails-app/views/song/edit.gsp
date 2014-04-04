<html>
<head>
  <meta name="layout" content="main"/>
  <title>Song ${song?.name}</title>
</head>

<body>
  <div>
    <g:form url="[resource:songInstance, action:'update']" method="PUT"  enctype="multipart/form-data">
        <g:hiddenField name="version" value="${songInstance?.version}" />
        <fieldset class="form">
            <g:render template="form"/>
	</fieldset>
	<fieldset class="buttons">
            <g:actionSubmit class="save btn btn-success" action="update" value="Update" />
	</fieldset>
    </g:form>
</body>
</html>