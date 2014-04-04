<%@ page import="personalbandhistory.Song" %>
<%@ page import="org.joda.time.LocalDate" contentType="text/html;charset=UTF-8" %>

<div class="form-group col-md-12">
    <label for="song_name" class="col-md-2 control-label">Name</label>
    <div class="col-md-2">
        <g:textField name="name" id="song_name" placeholder="Ex. Turnpikes" value="${songInstance?.name}" class="form-control"/>
    </div>
</div>

<div class="form-group col-md-12">
    <label for="song_lyrics" class="col-md-2 control-label">Lyrics</label>
    <div class="col-md-2">
        <g:textArea name="lyrics" id="band_lyrics" rows="5" cols="40" placeholder="Ex. Lyrics" value="${songInstance?.lyrics}" class="form-control"/>
    </div>
</div>

<div class="form-group col-md-12">
    <label for="song_track_num" class="col-md-2 control-label">Track Number</label>
    <div class="col-md-2">
        <g:textField name="trackNum" id="song_track_num" placeholder="Ex. 1" value="${songInstance?.trackNum}" class="form-control"/>
    </div>
</div>
