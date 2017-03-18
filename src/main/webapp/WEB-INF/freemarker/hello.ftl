<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>test</title>
</head>
<body>
<h1>hello,welcome to my world!${base}---${haha}</h1>


    <#list blist as book>
        <#if book.name ="数据结构">
            <p>${book.number}</p>
        </#if>
        <p>${book.name}</p>

    </#list>


</body>
</html>