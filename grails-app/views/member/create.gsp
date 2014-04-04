<html>
<head>
  <meta name="layout" content="main"/>
  <title>New Member</title>
</head>

<body>
  <div>
    <g:form url="[resource:memberInstance, action:'save']"  enctype="multipart/form-data">
        <fieldset class="form">
            <g:render template="form"/>
	</fieldset>
	<fieldset class="buttons">
            <g:submitButton name="create" class="save btn btn-success" id="create_member_button" value="Create Member" />
	</fieldset>
    </g:form>
</body>
</html>