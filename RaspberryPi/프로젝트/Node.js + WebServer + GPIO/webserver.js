var Gpio = require('onoff').Gpio,led = new Gpio(17, 'out');
var http = require('http');
http.createServer(
        function (request, response) {
                response.writeHead(200, {'Content-Type': 'text/html'});
                if(request.url=='/go') {
                        led.writeSync(1);
                }else if(request.url=='/stop') {
                        led.writeSync(0);
                }
                console.log(request.url);
                response.end("*LED Control WebPage*<br/><br/><h1><a href='./go'>LED ON</a></h1> <br/><br/><br/>  <h1><a href='./stop'>LED OFF</a></h1>");
                }
        ).listen(8000);

console.log('Server running at http://localhost:8000/');

