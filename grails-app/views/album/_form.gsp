<%@ page import="personalbandhistory.Album" %>
<%@ page import="org.joda.time.LocalDate" contentType="text/html;charset=UTF-8" %>

<div class="form-group col-md-12">
    <label for="album_name" class="col-md-2 control-label">Name</label>
    <div class="col-md-2">
        <g:textField name="name" id="album_name" placeholder="Ex. We Got A Nuke" value="${albumInstance?.name}" class="form-control"/>
    </div>
</div>

<div class="form-group col-md-12">
    <label for="album_band" class="col-md-2 control-label">Band</label>
    <div class="col-md-2">       
        <g:select name="band" from="${personalbandhistory.Band.list().sort{it?.name}}" optionKey="id" value="${albumInstance?.band?.id}"/><br/>
    </div>
</div>

<div class="form-group col-md-12">
    <label for="release_date" class="col-md-2 control-label">Release Date</label>
    <div class="col-md-2">
        <g:textField name="releaseDate" id="release_date" class="form-control" value="${albumInstance?.releaseDate}" placeholder="YYYY-MM-DD" />
    </div>
</div>

<div class="form-group col-md-12">
    <label for="album_image" class="col-md-2 control-label">Album Image</label>
    <div class="col-md-2">
        <input type="file" id="bandImage" name="albumImage" />
    </div>
</div>


<div class="form-group col-md-12">
    <label for="album_members" class="col-md-2 control-label">Members</label>
    <div class="col-md-2">       
        <g:select name="members" from="${personalbandhistory.Member.list().sort{it?.name}}" multiple="multiple" optionKey="id" size="5" value="${albumInstance?.members*.id}" class="many-to-many"/><br/>
    </div>
</div>

<div class="form-group col-md-12">
    <label for="album_songs" class="col-md-2 control-label">Songs</label>
    <div class="col-md-2">       
        <g:select name="songs" from="${personalbandhistory.Song.list().sort{it?.name}}" multiple="multiple" optionKey="id" size="5" value="${albumInstance?.songs*.id}" class="many-to-many"/><br/>
    </div>
</div>