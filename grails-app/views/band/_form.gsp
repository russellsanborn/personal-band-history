<%@ page import="personalbandhistory.Band" %>
<%@ page import="org.joda.time.LocalDate" contentType="text/html;charset=UTF-8" %>

<div class="form-group col-md-12">
    <label for="name" class="col-md-2 control-label">Name</label>
    <div class="col-md-2">
        <g:textField name="name" id="band_name" placeholder="Ex. Death By Bobcat" value="${bandInstance?.name}" class="form-control"/>
    </div>
</div>

<div class="form-group col-md-12">
    <label for="bio" class="col-md-2 control-label">Bio</label>
    <div class="col-md-2">
        <g:textField name="bio" id="band_bio" placeholder="Ex. Flint Punk Rock" value="${bandInstance?.bio}" class="form-control"/>
    </div>
</div>

<div class="form-group col-md-12">
    <label for="location" class="col-md-2 control-label">Location</label>
    <div class="col-md-2">
        <g:textField name="location" id="band_location" placeholder="Ex. Flint, MI" value="${bandInstance?.location}" class="form-control"/>
    </div>
</div>

<div class="form-group col-md-12">
    <label for="start_date" class="col-md-2 control-label">Start Date</label>
    <div class="col-md-2">
        <g:textField name="startDate" id="start_date" class="form-control" value="${bandInstance?.startDate}" placeholder="YYYY-MM-DD" />
    </div>
</div>

<div class="form-group col-md-12">
    <label for="end_date" class="col-md-2 control-label">End Date</label>
    <div class="col-md-2">
        <g:textField name="endDate" id="end_date" class="form-control" value="${bandInstance?.endDate}" placeholder="YYYY-MM-DD" />
    </div>
</div>

<div class="form-group col-md-12">
    <label for="band_image" class="col-md-2 control-label">Band Image</label>
    <div class="col-md-2">
        <input type="file" id="bandImage" name="bandImage" />
    </div>
</div>

<div class="form-group col-md-12">
    <label for="band_albums" class="col-md-2 control-label">Albums</label>
    <div class="col-md-2 list-group">
        <g:each in="${bandInstance?.albums}" var="a">
            <g:link controller="album" action="show" id="${a.id}" class="list-group-item">${a?.name}</g:link>
        </g:each>
        <g:link controller="album" action="create" params="['band.id': bandInstance?.id]" class="list-group-item list-group-item-success">Add New Album</g:link>
    </div>
</div>


<div class="form-group col-md-12">
    <label for="band_members" class="col-md-2 control-label">Members</label>
    <div class="col-md-2">       
        <g:select name="members" from="${personalbandhistory.Member.list().sort{it?.name}}" multiple="multiple" optionKey="id" size="5" value="${bandInstance?.members*.id}" class="many-to-many"/><br/>
    </div>
</div>