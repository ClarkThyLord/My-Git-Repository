extends Camera2D
class_name Player



# Declarations
export(String) var Name : String = ''

export(int) var Speed : int = 200
export(int) var SpeedBoost : int = 2

export(String) var KingdomName : String = ''
export(Color) var KingdomColor : Color = Color(0, 0, 0)

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

var target



# Core
func _process(delta):
	if Input.is_action_just_released('deselect'):
		for entity in selected:
			if entity.is_in_group('slimes'):
				entity.Selected = false
		selected.clear()
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
		if target and position.distance_to(target) > 32: selected[0].target_position = target
		set_position(selected[0].position)
	elif current and selected.size() > 1:
		var x1 = selected[0].position.x
		var x2 = selected[0].position.x
		var y1 = selected[0].position.y
		var y2 = selected[0].position.y
		for node in selected:
			if node.is_in_group('slimes'):
				if target: node.target_position = target
				elif (Input.is_action_just_pressed('regroup') or node.position.distance_to(position) > 32 + 4 * selected.size()): node.target_position = position
			if node.position.x < x1: x1 = node.position.x
			if node.position.x > x1: x2 = node.position.x
			if node.position.y < y1: y1 = node.position.y
			if node.position.y > y2: y2 = node.position.y
		set_position(Vector2((x2 + x1) / 2, (y2 + y1) / 2))

func _input(event):
	if event is InputEventMouseMotion:
		target = event.position
	elif event is InputEventMouseButton:
		if event.button_index == BUTTON_WHEEL_UP and zoom.x > 0.1 and zoom.y > 0.1:
			zoom -= Vector2(0.1, 0.1)
		elif event.button_index == BUTTON_WHEEL_DOWN:
			zoom += Vector2(0.1, 0.1)