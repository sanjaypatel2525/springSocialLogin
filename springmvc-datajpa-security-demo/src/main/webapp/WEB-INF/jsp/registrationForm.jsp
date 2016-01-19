<!DOCTYPE html>
<%@include file="taglib.jsp" %>
<html>
<head>
    <title></title>
<script type="text/javascript" src="${rootURL}resources/jquery/jquery-1.10.2.js"></script>
    <script >
    $(function() {
        addValidationErrorClassesToForm();

        function addValidationErrorClassesToForm() {
            $("form").find(".form-group").each(function() {
                var errorMessage = $(this).find(".help-block").text();

                if (errorMessage) {
                    $(this).addClass("has-error");
                }
            })
        }
    });
    </script>
</head>
<body>
    <div class="page-header">
        <h1>Registration Page</h1>
    </div>
    <!--
        If the user is anonymous (not logged in), show the registration form.
    -->
    <sec:authorize access="isAnonymous()">
        <div class="panel panel-default">
            <div class="panel-body">
                <!-- 
                    Ensure that when the form is submitted, a POST request is send to url
                    '/user/register'.
                -->
                <form:form action="${pageContext.request.contextPath}/user/register" commandName="user" method="POST" enctype="utf8" role="form">
                    <!-- Add CSRF token to the request. -->
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <!--
                        If the user is using social sign in, add the signInProvider
                        as a hidden field.
                    -->
                    <c:if test="${user.signInProvider != null}">
                        <form:hidden path="signInProvider"/>
                    </c:if>
                    <div class="row">
                        <div id="form-group-firstName" class="form-group col-lg-4">
                            <label class="control-label" for="user-firstName">firstname:</label>
                            <!--
                                Add the firstName field to the form and ensure 
                                that validation errors are shown.
                            -->
                            <form:input id="user-firstName" path="firstName" cssClass="form-control"/>
                            <form:errors id="error-firstName" path="firstName" cssClass="help-block"/>
                        </div>
                    </div>
                    <div class="row">
                        <div id="form-group-email" class="form-group col-lg-4">
                            <label class="control-label" for="user-email">email:</label>
                            <!-- 
                                Add the email field to the form and ensure
                                that validation errors are shown.
                            -->
                            <form:input id="user-email" path="email" cssClass="form-control"/>
                            <form:errors id="error-email" path="email" cssClass="help-block"/>
                        </div>
                    </div>
                    <!--
                        If the user is creating a normal user account, add password fields
                        to the form.
                    -->
                    <c:if test="${user.signInProvider == null}">
                        <div class="row">
                            <div id="form-group-password" class="form-group col-lg-4">
                                <label class="control-label" for="user-password">password:</label>
                                <!--
                                    Add the password field to the form and ensure 
                                    that validation errors are shown.
                                -->
                                <form:password id="user-password" path="password" cssClass="form-control"/>
                                <form:errors id="error-password" path="password" cssClass="help-block"/>
                            </div>
                        </div>
                        <div class="row">
                            <div id="form-group-passwordVerification" class="form-group col-lg-4">
                                <label class="control-label" for="user-passwordVerification">password verification:</label>
                                <!-- 
                                    Add the passwordVerification field to the form and ensure
                                    that validation errors are shown.
                                -->
                                <form:password id="user-passwordVerification" path="passwordVerification" cssClass="form-control"/>
                                <form:errors id="error-passwordVerification" path="passwordVerification" cssClass="help-block"/>
                            </div>
                        </div>
                    </c:if>
                    <!-- Add the submit button to the form. -->
                    <input type="submit" class="btn btn-default">submit</input>
                </form:form>
            </div>
        </div>
    </sec:authorize>
    <!--
        If the user is authenticated, show a help message instead
        of registration form.
    -->
    <sec:authorize access="isAuthenticated()">
        <p>help</p>
    </sec:authorize>
</body>
</html>