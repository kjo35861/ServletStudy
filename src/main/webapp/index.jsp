<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        table {
            border: 1px solid #dbdbdb;
            border-collapse: collapse;
        }
        th, td {
            box-sizing: border-box;
            border: 1px solid #dbdbdb;
            padding: 5px 10px;
        }
    </style>
</head>
<body>
    <h1>계좌 생성</h1>
    <button type="button" class="create-button">생성하기</button>
    <table>
        <tr>
            <th>ID</th>
            <th>AccountNo</th>
            <th>Dwner</th>
            <th>Balance</th>
        </tr>

        <tr>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
        </tr>
    </table>
    <script>
        main();
        function main() {
            const createButton = document.querySelector(".create-button");
            createButton.onclick = () => {
                const inputs = document.querySelectorAll("input");
                const accountObj = {
                    id : inputs[0].value,
                    accountNo: inputs[1].value,
                    owner: inputs[2].value,
                    balance: inputs[3].value,
                };
                fetch("http://localhost:8080/servlet_study_war_exploded/api/accounts", {
                    method: "post",
                    body: JSON.stringify(accountObj),
                    headers: {
                        "Content-Type": "application/json",
                    }
                })

            }
        }
    </script>
</body>
</html>