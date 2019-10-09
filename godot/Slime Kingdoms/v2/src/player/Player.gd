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
		var direction = Vector2()
		if Input.is_action_pressed('move_up'): direction.y -= 1
		if Input.is_action_pressed('move_right'): direction.x += 1
		if Input.is_action_pressed('move_down'): direction.y += 1
		if Input.is_action_pressed('move_left'): direction.x -= 1
		
		if Input.is_action_pressed('move_boost'): direction *= SpeedBoost
		
		translate(direction * Speed * delta)

func _unhandled_input(event : InputEvent) -> void:
	if event is InputEventMouseMotion:
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