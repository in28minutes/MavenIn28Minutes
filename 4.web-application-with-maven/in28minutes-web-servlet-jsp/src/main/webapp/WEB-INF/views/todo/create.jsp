<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jspf"%>

<div class="container">
    <div class="row">
        <div class="col-sm-3 col-md-3">
            <%@ include file="../common/sidebar.jspf"%>
        </div>
        <div class="col-sm-9 col-md-9">
            <div class="well">
                <div class="page-header">
                    <h1>Create a new todo</h1>
                </div>

                <form id="createTodoForm" action="/todos/new.do" method="post" class="form-horizontal">

                    <fieldset>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="title">Title:</label>
                            <div class="col-sm-10">
                                <input type="text" id="title" name="title" required="required" autofocus="autofocus" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="dueDate">Due date:</label>
                            <div class="col-sm-10">
                                <input type="text" id="dueDate" name="dueDate" value="${requestScope.today}" required="required" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="priority">Priority:</label>
                            <div class="col-sm-10">
                                <select id="priority" name="priority">
                                  <option value="LOW">Low</option>
                                  <option value="MEDIUM">Medium</option>
                                  <option value="HIGH">High</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-actions col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-primary"> <i class="icon-ok icon-white"></i> Create</button>
                            <button type="button" class="btn btn-danger" onclick="history.go(-1)"><i class="icon-remove"></i> Cancel</button>
                        </div>

                    </fieldset>

                    <script>
                        $('#dueDate').datepicker({
                            format : 'dd/mm/yyyy'
                        });
                    </script>

                </form>

            </div>
        </div>
    </div>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>
