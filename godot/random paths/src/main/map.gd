extends TileMap

export (int) var columns = 10
export (int) var rows = 10

var map = []

func _ready():
	map = generate_map(columns, rows)
	setup_map(map)
	generate_path(map)

func generate_map(columns, rows):
	var new_map = []
	for row in rows:
		new_map.append([])
		for column in columns:
			new_map[row].append((randi() % 2))
	
	return new_map

func generate_path(map):
	var height = map.size()
	var width = 0
	if height > 0:
		width = map[0].size()

func setup_map(map):
	var position = Vector2()
	for row in map:
		for cell in row:
			self.set_cell(position.x, position.y, cell)
			position.x += 1
		position.x = 0
		position.y += 1
