extends Camera2D
class_name Player



# Declarations
export(String) var Name : String = ''

export(int) var Speed : int = 200
export(int) var SpeedBoost : int = 2

var selected : Array = []
func set_selected(nodes : Array) -> void: selected = nodes
func add_selected(node : Node) -> void:
	if not selected.has(node):
		selected.append(node)
		node.connect('died', self, 'remove_selected')
func remove_selected(node : Node) -> void:
	if selected.has(node):
		selected.erase(node)
		node.disconnect('died', self, 'remove_selected')



# Core
func _process(delta):
	if current and selected.size() == 0:
		var movement = Vector2()
		if Input.is_action_pressed('move_up'): movement.y = -1
		if Input.is_action_pressed('move_right'): movement.x = 1
		if Input.is_action_pressed('move_down'): movement.y = 1
		if Input.is_action_pressed('move_left'): movement.x = -1
		
		if Input.is_action_pressed('move_boost') and not Input.is_action_pressed('attack'):
			movement *= SpeedBoost
		
		translate((movement * Speed) * delta)
	elif current and selected.size() == 1:
		set_position(selected[0].position)
	elif current and selected.size() > 1:
		var x1 = selected[0].position.x
		var x2 = selected[0].position.x
		var y1 = selected[0].position.y
		var y2 = selected[0].position.y
		for node in selected:
			if node.position.x < x1: x1 = node.position.x
			if node.position.x > x1: x2 = node.position.x
			if node.position.y < y1: y1 = node.position.y
			if node.position.y > y2: y2 = node.position.y
		set_position(Vector2((x2 + x1) / 2, (y2 + y1) / 2))
