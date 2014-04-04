<html>
<head>
  <meta name="layout" content="main"/>
  <title>New Concert</title>
</head>

<body>
  <div>
    <g:form url="[resource:concertInstance, action:'save']"  enctype="multipart/form-data">
        <fieldset class="form">
            <g:render template="form"/>
	</fieldset>
	<fieldset class="buttons">
            <g:submitButton name="create" class="save btn btn-success" id="create_concert_button" value="Create Concert" />
	</fieldset>
    </g:form>
</body>
</html>