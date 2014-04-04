<html>
<head>
  <meta name="layout" content="main"/>
  <title>New Band</title>
</head>

<body>
  <div>
    <g:form url="[resource:bandInstance, action:'save']"  enctype="multipart/form-data">
        <fieldset class="form">
            <g:render template="form"/>
	</fieldset>
	<fieldset class="buttons">
            <g:submitButton name="create" class="save btn btn-success" id="create_band_button" value="Create Band" />
	</fieldset>
    </g:form>
</body>
</html>