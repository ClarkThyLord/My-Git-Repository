extends Camera2D
class_name Player



# Declarations
export(int, 0, 1000, 1) var Speed := 100
export(float, 0.01, 10.0, 0.01) var SpeedBoost := 1.50

var selected := []

export(Color) var PlayerColor := Color(1, 1, 1)



# Core
func _process(delta) -> void:
	if current:
		if selected.size() == 0:
			var direction := Vector2()
			if Input.is_action_pressed('move_up') or (Input.is_mouse_button_pressed(BUTTON_LEFT) and position.y > get_global_mouse_position().y): direction.y -= 1
			if Input.is_action_pressed('move_right') or (Input.is_mouse_button_pressed(BUTTON_LEFT) and position.x < get_global_mouse_position().x): direction.x += 1
			if Input.is_action_pressed('move_down') or (Input.is_mouse_button_pressed(BUTTON_LEFT) and position.y < get_global_mouse_position().y): direction.y += 1
			if Input.is_action_pressed('move_left') or (Input.is_mouse_button_pressed(BUTTON_LEFT) and position.x > get_global_mouse_position().x): direction.x -= 1
			
			if Input.is_action_pressed('move_boost'): direction *= SpeedBoost
			
			translate(direction * Speed * delta)
		elif selected.size() == 1: position = selected[0].position
		else:
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

func _unhandled_input(event : InputEvent) -> void:
	if event is InputEventMouseMotion:
		if Input.is_mouse_button_pressed(BUTTON_LEFT):
			for select in selected:
				select = select as Node
				if select.is_in_group('slimes'):
					select.Target = get_global_mouse_position()
	elif event is InputEventMouseButton:
		if event.button_index == BUTTON_LEFT and not event.is_pressed():
			var targets = get_world_2d().direct_space_state.intersect_point(get_global_mouse_position())
			for target in targets:
				if target['collider'].is_in_group('entities'):
					if target['collider'].Selector == self:
						target['collider'].unselected()
						selected.erase(target['collider'])
					else:
						target['collider'].selected(self)
						selected.append(target['collider'])
		elif event.button_index == BUTTON_WHEEL_UP and zoom.x > 0.1 and zoom.y > 0.1:
			zoom -= Vector2(0.1, 0.1)
		elif event.button_index == BUTTON_WHEEL_DOWN:
			zoom += Vector2(0.1, 0.1)