extends Camera2D
class_name Player



# Declarations
export(int, 0, 1000, 1) var Speed := 100
export(float, 0.01, 10.0, 0.01) var SpeedBoost := 1.50

var selected := []



# Core
func _process(delta) -> void:
	if current:
		var movement = Vector2()
		if Input.is_action_pressed('move_up'): movement.y -= 1
		if Input.is_action_pressed('move_right'): movement.x += 1
		if Input.is_action_pressed('move_down'): movement.y += 1
		if Input.is_action_pressed('move_left'): movement.x -= 1
		
		if Input.is_action_pressed('move_boost'): movement *= SpeedBoost
		
		translate(movement * Speed * delta)

func _unhandled_input(event : InputEvent) -> void:
	if event is InputEventMouseButton:
		if event.button_index == BUTTON_LEFT and not event.is_pressed():
			var targets = get_world_2d().direct_space_state.intersect_point(get_global_mouse_position())
			for target in targets:
				if target['collider'].is_in_group('entities'):
					if target['collider'].Selector == self:
						target['collider'].unselected()
						selected.append(target['collider'])
					else:
						target['collider'].selected(self)
						selected.append(target['collider'])
		elif event.button_index == BUTTON_WHEEL_UP and zoom.x > 0.1 and zoom.y > 0.1:
			zoom -= Vector2(0.1, 0.1)
		elif event.button_index == BUTTON_WHEEL_DOWN:
			zoom += Vector2(0.1, 0.1)