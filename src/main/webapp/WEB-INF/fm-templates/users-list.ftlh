<html>
<head>
    <title>List users</title>
</head>
<body>
<h1> list of users:</h1>
<hr>
<p>
    <#list users as user>
        User:<br/>
        ID: ${user.id}<br/>
        Name: ${user.name}<br/>
        Login: ${user.login}<br/>
        Age: ${user.age}<br/>
        <#sep><hr></#sep>
    </#list>
</p>

</body>
</html>