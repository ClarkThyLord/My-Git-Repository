extends Camera2D

export (int) var speed = 200
var movement = Vector2()

func _ready():
	pass

func _process(delta):
	movement = Vector2()
	if Input.is_action_pressed('right'):
		movement.x += 1
	if Input.is_action_pressed('left'):
		movement.x -= 1
	if Input.is_action_pressed('down'):
		movement.y += 1
	if Input.is_action_pressed('up'):
		movement.y -= 1
	
	movement = (movement.normalized() * speed) * delta
	
	if Input.is_action_pressed('shift'):
		movement *= 1.75
	
	self.translate(movement)
