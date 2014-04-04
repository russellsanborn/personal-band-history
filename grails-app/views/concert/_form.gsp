<%@ page import="personalbandhistory.Concert" %>
<%@ page import="org.joda.time.LocalDate" contentType="text/html;charset=UTF-8" %>

<div class="form-group col-md-12">
    <label for="concert_title" class="col-md-2 control-label">Title</label>
    <div class="col-md-2">
        <g:textField name="title" id="concert_title" placeholder="Ex. Christmas Giveaway" value="${concertInstance?.title}" class="form-control"/>
    </div>
</div>

<div class="form-group col-md-12">
    <label for="concert_venue_name" class="col-md-2 control-label">Venue Name</label>
    <div class="col-md-2">
        <g:textField name="venueName" id="concert_venue_name" placeholder="Ex. Flint Local 432" value="${concertInstance?.venueName}" class="form-control"/>
    </div>
</div>

<div class="form-group col-md-12">
    <label for="concert_location" class="col-md-2 control-label">Location</label>
    <div class="col-md-2">
        <g:textField name="location" id="concert_location" placeholder="Ex. Flint, MI" value="${concertInstance?.location}" class="form-control"/>
    </div>
</div>

<div class="form-group col-md-12">
    <label for="event_date" class="col-md-2 control-label">Event Date</label>
    <div class="col-md-2">
        <g:textField name="eventDate" id="event_date" class="form-control" value="${concertInstance?.eventDate}" placeholder="YYYY-MM-DD" />
    </div>
</div>