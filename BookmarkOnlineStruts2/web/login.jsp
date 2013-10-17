<%@page  contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title>Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <s:form action="login" method="post">
            <s:textfield label="User" name="username" />
            <s:password label="Password" name="password"/>
            <s:submit/>
        </s:form>
    </body>
</html>
