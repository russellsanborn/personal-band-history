<html>
<head>
  <meta name="layout" content="main"/>
  <title>New Album</title>
</head>

<body>
  <div>
    <g:form url="[resource:albumInstance, action:'save']"  enctype="multipart/form-data">
        <fieldset class="form">
            <g:render template="form"/>
	</fieldset>
	<fieldset class="buttons">
            <g:submitButton name="create" class="save btn btn-success" id="create_album_button" value="Create Album" />
	</fieldset>
    </g:form>
</body>
</html>