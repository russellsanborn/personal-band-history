<html>
<head>
  <meta name="layout" content="main"/>
  <title>New Song</title>
</head>

<body>
  <div>
    <g:form url="[resource:songInstance, action:'save']"  enctype="multipart/form-data">
        <fieldset class="form">
            <g:render template="form"/>
	</fieldset>
	<fieldset class="buttons">
            <g:submitButton name="create" class="save btn btn-success" id="create_song_button" value="Create Song" />
	</fieldset>
    </g:form>
</body>
</html>