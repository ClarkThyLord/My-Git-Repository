extends Camera

export (int) var turn_speed = 1
var turn = Vector2()

export (int) var move_speed = 25
export (float) var move_boost = 2
var movement = Vector3()

func _ready():
	pass

func _process(delta):
	# Turn
	if Input.is_action_pressed('right_m'):
		var towards = turn - get_viewport().get_mouse_position()
		turn = get_viewport().get_mouse_position()
		rotation.x += (clamp(towards.y, -1, 1) * turn_speed) * delta
		rotation.y += (clamp(towards.x, -1, 1) * turn_speed) * delta
	
	# Movement
	movement = Vector3()
	if Input.is_action_pressed('right'):
		movement.x += 1
	if Input.is_action_pressed('left'):
		movement.x -= 1
	if Input.is_action_pressed('down'):
		movement.z += 1
	if Input.is_action_pressed('up'):
		movement.z -= 1
	
	movement = (movement.normalized() * move_speed) * delta
	
	if Input.is_action_pressed('shift'):
		movement *= move_boost
	
	translate(movement)
