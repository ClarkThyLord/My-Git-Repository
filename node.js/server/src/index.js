const express = require('express');
const body_parser = require('body-parser');

const app = express();
const port = 3000;

app.use(body_parser.json());

let DB = [{
		id: 0,
		name: 'Christian'
	},
	{
		id: 1,
		name: 'ClarkThyLord'
	}
];

app.get('/', (req, res) => res.send(`Hello world, I'm runing off port ${port}!`));

app.get('/get', (req, res) => {
	let response = {
		success: false,
		data: []
	};

	if (req.query.id && DB[req.query.id]) {
		response.data.push(DB[req.query.id]);
	} else if (Object.keys(req.query).length > 0) {
		response.data = DB.filter((data) => {
			for (let [query_k, query_v] of Object.entries(req.query)) {
				if (data[query_k] == query_v) {
					return true;
				} else {
					return false;
				}
			}
		});
	}

	if (response.data.length > 0) {
		response.success = true;
	}

	res.send(JSON.stringify(response));
});

app.get('/getAll', (req, res) => {
	res.send(JSON.stringify(DB));
});

app.post('/add', (req, res) => {
	let response = {
		success: true,
		data: undefined
	};

	DB.push(Object.assign({
		id: DB.length
	}, req.body));

	response.data = DB[DB.length - 1];

	res.send(JSON.stringify(response));
});

app.delete("/remove/:id", (req, res) => {
	let response = {
		success: false,
		data: {}
	};

	if (DB[req.params.id]) {
		response.success = true;
		response.data = DB[req.params.id];

		delete DB[req.params.id];
	}

	res.send(JSON.stringify(response));
});

app.post("/update/:id", (req, res) => {
	let response = {
		success: false,
		data: {}
	};

	if (DB[req.params.id]) {
		response.success = true;
		if (req.body["id"]) delete req.body["id"];
		DB[req.params.id] = Object.assign(DB[req.params.id], req.body);
		response.data = DB[req.params.id];
	}

	res.send(JSON.stringify(response));
});

app.listen(port, () => console.log(`Listening on port ${port}!`));
