const http = require('http');

const server = http.createServer((req, res) => {

    console.log(req.url)

  res.statusCode = 200;
  res.setHeader('Content-Type', 'text/plain');
  res.end('Hello, world!');
});

server.listen(3000);