<%@ page import="personalbandhistory.Member" %>
<%@ page import="org.joda.time.LocalDate" contentType="text/html;charset=UTF-8" %>

<div class="form-group col-md-12">
    <label for="name" class="col-md-2 control-label">Name</label>
    <div class="col-md-2">
        <g:textField name="name" id="member_name" placeholder="Ex. Rusty Bobcat" value="${memberInstance?.name}" class="form-control"/>
    </div>
</div>

<div class="form-group col-md-12">
    <label for="instrument" class="col-md-2 control-label">Instrument</label>
    <div class="col-md-2">
        <g:textField name="instrument" id="member_instrument" placeholder="Ex. Guitar" value="${memberInstance?.instrument}" class="form-control"/>
    </div>
</div>


<div class="form-group col-md-12">
    <label for="start_date" class="col-md-2 control-label">Start Date</label>
    <div class="col-md-2">
        <g:textField name="startDate" id="start_date" class="form-control" value="${memberInstance?.startDate}" placeholder="YYYY-MM-DD" />
    </div>
</div>

<div class="form-group col-md-12">
    <label for="end_date" class="col-md-2 control-label">End Date</label>
    <div class="col-md-2">
        <g:textField name="endDate" id="end_date" class="form-control" value="${memberInstance?.endDate}" placeholder="YYYY-MM-DD" />
    </div>
</div>
