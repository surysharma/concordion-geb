<html>
<head>
    <title>Welcome to Grails</title>
    %{--<meta name="layout" content="main"/>--}%
    <style type="text/css" media="screen">
    </style>
</head>

<body>
<table border="1">
    <thead>
    <tr>
        <th>select me</th>
        <th>Employee name</th>
        <th>Pension package</th>
        <th>Salary</th>
        <th>NI Number</th>
    </tr>
    </thead>
    <form name="inputfrm" action="/testwebapp/home/result" method="POST">

        <tr>
            <td><input type="radio"/></td>
            <td>Suresh Sharma</td>
            <td>Pkg1</td>
            <td>23000</td>
            <td>L98354L</td>
        </tr>
        <tr><td><input type="radio"/></td><td>Ricky Teot</td><td>Pkg3</td><td>24000</td><td>L37654L</td></tr>
        <tr><td><input type="radio"/></td><td>Sandra toods</td><td>Pkg1</td><td>5000</td><td>L3754L</td></tr>
        <tr><td><input type="radio"/></td><td>Peter timoty</td><td>Pkg1</td><td>23070</td><td>L6354L</td></tr>
        <tr><td><input type="radio"/></td><td>Jarry Maguire</td><td>Pkg3</td><td>2700</td><td>L3354L</td></tr>
        <tr><td><input type="radio"/></td><td>Skiles johnson</td><td>Pkg5</td><td>23809</td><td>L3454L</td></tr>
        <br/>
        <input type="submit" value="auto-enroll"/>
    </form>
</table>
</body>
</html>
