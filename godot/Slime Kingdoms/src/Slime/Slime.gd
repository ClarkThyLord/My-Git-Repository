extends KinematicBody2D



# Declarations
signal died(_self)

export(String) var Name = ''

export(float, 0, 100, 0.01) var Size : float = 10.0
export(float, 0, 10, 0.01) var GrowthBoost : float = 0.25

export(float, 0, 1, 0.01) var Hunger : float = 1

export(float) var Health : float = 25
export(float) var MaxHealth : float = 25 setget set_max_health
func set_max_health(max_health : float) -> void:
	MaxHealth = max_health
	if Health > max_health: Health = max_health

export(int) var Speed : int = 25
export(float, 1, 10, 0.1) var SpeedBoost : float = 2.0

export(int) var Defense : int = 3

export(int) var Attack : int = 3
enum AttackModes { SingleAttack, AreaAttack, RangeAttack }
export(AttackModes) var AttackMode = AttackModes.SingleAttack

export(Color) var SlimeColor : Color = Color(1, 1, 1) setget set_slime_color
func set_slime_color(color : Color) -> void: modulate = color

enum SlimeStages { Egg, Slimy, Slimer, Slimiest }
export(SlimeStages) var SlimeStage : int = SlimeStages.Egg setget set_slime_stage
func set_slime_stage(slimestage : int) -> void:
	slimestage = slimestage

var target_position

var hovered : bool = false
export(bool) var Selected : bool = false setget set_selected
func set_selected(selected : bool) -> void:
	Selected = selected
	if Selected:
		$Sprite.scale = Vector2(1.15, 1.15)
		if get_node('/root/Core').player: get_node('/root/Core').player.add_selected(self)
	else:
		update()
		$Sprite.scale = Vector2(1, 1)
		if get_node('/root/Core').player: get_node('/root/Core').player.remove_selected(self)



# Core
func _process(delta):
	# Stats update
	Hunger -= Size / 10000
	if Health <= 0 or Hunger <= 0:
		emit_signal('died', self)
		$AnimationPlayer.play('dying')
		yield($AnimationPlayer, 'animation_finished')
		queue_free()
	scale = Vector2.ONE * (Size / 10)
	
	# Stats visuals update
	update()
	
	# Movement handeling
	var movement = Vector2()
	
	if typeof(target_position) == TYPE_VECTOR2:
		if target_position.distance_to(position) < 16:
			target_position = null
		else:
			if target_position.x > position.x: movement.x = 1
			if target_position.x < position.x: movement.x = -1
			if target_position.y > position.y: movement.y = 1
			if target_position.y < position.y: movement.y = -1
	
	if Selected:
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
		
		movement = (movement * Speed) * delta
		if test_move(transform, movement): target_position = null
		else: move_and_collide(movement)

func _draw():
	if Selected or hovered:
		# Health
		draw_line(Vector2(-16, -8), Vector2(16, -8), Color(0, 0, 1), 3)
		draw_line(Vector2(-16, -8), Vector2(Health / MaxHealth * 32 - 16, -8), Color(1, 0, 0), 3)
		
		# Hunger
		draw_line(Vector2(-16, -4), Vector2(16, -4), Color('013220'), 2)
		draw_line(Vector2(-16, -4), Vector2(Hunger * 32 - 16, -4), Color(0, 1, 0), 2)

func _on_input_event(viewport, event, shape_idx):
	if event is InputEventMouseButton and event.pressed:
#		print('selected')
		set_selected(!Selected)

func _on_mouse_entered():
#	print('hover')
	hovered = true
	update()
	$Sprite.scale = Vector2(1.15, 1.15)

func _on_mouse_exited():
#	print('unhover')
	hovered = false
	update()
	if not Selected: $Sprite.scale = Vector2(1, 1)


func eat(wealth : int, color : Color) -> void:
	var growth = wealth
	if self.SlimeColor.r >= 0.75 and color.r >= 0.75:
		growth += wealth * GrowthBoost
	if self.SlimeColor.g >= 0.75 and color.g >= 0.75:
		growth += wealth * GrowthBoost
	if self.SlimeColor.b >= 0.75 and color.b >= 0.75:
		growth += wealth * GrowthBoost
	Size += growth * 0.001
	if Health < MaxHealth: Health += growth * 0.01
	if Hunger < 1: Hunger += growth * 0.01

func handle_damage(damage : int) -> void:
	Health -= damage

func attack() -> void:
#	print('attacked')
	var attack_damage = randi() % (Attack + 1)
	match AttackMode:
		AttackModes.SingleAttack:
#			print('single attack : ' + str(attack_damage))
			if $AttackRange.is_colliding() and $AttackRange.get_collider().is_in_group('slimes'):
				$AttackRange.get_collider().handle_damage(attack_damage)
		AttackModes.AreaAttack:
			print('area attack   : ' + str(attack_damage))
		AttackModes.RangeAttack:
			print('range attack  : ' + str(attack_damage))
