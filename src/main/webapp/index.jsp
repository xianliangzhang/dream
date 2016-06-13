<html ng-app>
<head>
    <script src="js/angular-1.5.0.js"></script>
    <script src="js/jquery-2.1.4.js"></script>
    <script src="js/sockjs-1.1.1.min.js"></script>

    <script>
        var websocket;
        if ('WebSocket' in window) {
            websocket = new WebSocket("ws://localhost:8080/dream/echo");
        } else if ('MozWebSocket' in window) {
            websocket = new MozWebSocket("ws://localhost:8080/dream/echo");
        } else {
            websocket = new SockJS("http://localhost:8080/dream/echo/");
        }
        websocket.onopen = function (evnt) {
            alert('open');
        };
        websocket.onmessage = function (evnt) {
            alert('message');
        };
        websocket.onerror = function (evnt) {
            alert('error');
        };
        websocket.onclose = function (evnt) {
            alert('close');
        }

    </script>
</head>
<body>
<h2>Hello World! {{'sss'}}</h2>

</body>
</html>
