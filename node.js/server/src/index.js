const express = require('express');
const app = express();
const port = 3000;

let DB = [];

app.get('/', (req, res) => res.send(`Hello world, I'm runing off port ${port}!`));

app.get('/get', (req, res) => {
	if (req.query.id) {
		result = DB[req.query.id];
	} else {
		DB.filter((data) => {
			for (let query of req.query) {
				if (data[query]) {
					return true;
				} else {
					return false;
				}
			}
		});
	}

	res.send(JSON.stringify(result));
});

app.post('/add', (req, res) => {
	let data = {
		id: DB.length,
		data: req.query
	};

	DB.push(data);

	res.send(JSON.stringify({
		success: true,
		result: data
	}));
});

app.delete("/remove/:id", (req, res) => {
	delete DB[req.params.id];
});

app.listen(port, () => console.log(`Listening on port ${port}!`));
