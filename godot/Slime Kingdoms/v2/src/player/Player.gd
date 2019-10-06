extends Camera2D
class_name Player

export(int, 0, 1000, 1) var Speed := 100
export(float, 0.01, 10.0, 0.01) var SpeedBoost := 1.50

# Core
func _process(delta):
	if current:
		var movement = Vector2()
		if Input.is_action_pressed('move_up'): movement.y -= 1
		if Input.is_action_pressed('move_right'): movement.x += 1
		if Input.is_action_pressed('move_down'): movement.y += 1
		if Input.is_action_pressed('move_left'): movement.x -= 1
		
		if Input.is_action_pressed('move_boost'): movement *= SpeedBoost
		
		translate(movement * Speed * delta)
