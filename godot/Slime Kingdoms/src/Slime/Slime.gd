extends KinematicBody2D



# Declarations
export(bool) var Selected : bool = false setget set_selected
func set_selected(selected : bool) -> void:
	Selected = selected
	if Selected:
		$Sprite.scale = Vector2(1.15, 1.15)
		if get_node('/root/Core').player: get_node('/root/Core').player.add_selected(self)
	else:
		$Sprite.scale = Vector2(1, 1)
		if get_node('/root/Core').player: get_node('/root/Core').player.remove_selected(self)

export(String) var Name = ''
export(int) var Health : int = 25 

export(int) var Defense : int = 3

export(int) var Speed : int = 15
export(float) var SpeedBoost : float = 2.0

export(int) var Attack : int = 3
enum AttackMode { SingleAttack, AreaAttack }
export(AttackMode) var SlimeAttackMode = AttackMode.SingleAttack

export(Color) var SlimeColor : Color = Color(1, 1, 1) setget set_slime_color
func set_slime_color(color : Color):
	modulate = color
	SlimeColor = color



# Core
func _process(delta):
	if Selected:
		var movement = Vector2()
		if Input.is_action_pressed('move_up'): movement.y = -1
		if Input.is_action_pressed('move_right'): movement.x = 1
		if Input.is_action_pressed('move_down'): movement.y = 1
		if Input.is_action_pressed('move_left'): movement.x = -1
		
		if movement.x < 0:
			$AttackRange.cast_to.x = -17
			$Sprite.flip_h = false
		elif movement.x > 0:
			$Sprite.flip_h = true
			$AttackRange.cast_to.x = 17
		
		if Input.is_action_pressed('move_boost') and not Input.is_action_pressed('attack'):
			movement *= SpeedBoost
		
		if Input.is_action_pressed('attack'):
			if not $AnimationPlayer.current_animation == 'attacking': $AnimationPlayer.play('attacking')
		elif Input.is_action_pressed('move_boost'): $AnimationPlayer.play('jumping')
		elif movement.length() != 0: $AnimationPlayer.play('moving')
		else: $AnimationPlayer.play('idle')
		
		translate((movement * Speed) * delta)

func _on_input_event(viewport, event, shape_idx):
	if event is InputEventMouseButton and event.pressed:
		print('selected')
		set_selected(!Selected)

func _on_mouse_entered():
#	print('hover')
	$Sprite.scale = Vector2(1.15, 1.15)

func _on_mouse_exited():
#	print('unhover')
	if not Selected: $Sprite.scale = Vector2(1, 1)


func eat(wealth : int, color : Color) -> void:
	print('eat : ' + str(wealth) + ' - ' + str(color))

func attack() -> void:
#	print('attacked')
	var attack_damage = randi() % (Attack + 1)
	if SlimeAttackMode == AttackMode.SingleAttack:
		print('single attack : ' + str(attack_damage))
	elif SlimeAttackMode == AttackMode.AreaAttack:
		print('area attack : ' + str(attack_damage))
